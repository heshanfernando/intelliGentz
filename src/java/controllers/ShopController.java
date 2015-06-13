/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.DBConnection;
import db.DBHandle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Item;
import models.Shop;
import models.ShopTime;

/**
 *
 * @author Heshan
 * 
 */

public class ShopController {
    
    public static Boolean addShop(Shop shop) throws ClassNotFoundException, SQLException {
        String query1="INSERT INTO shop VALUES(?,?,?,?,?,?,?,?)";
        Object[] data1={shop.getShopId(),shop.getShopName(),shop.getShopAddress(),shop.getShopContactNo(),shop.getShopLongitude(),shop.getShopLattitude(),shop.getOwnerId(),shop.getShopMaskedNo()};
        boolean status1 = DBHandle.setData(DBConnection.getConnectionToDB(), query1, data1);
        
        boolean status2 = true;
        if(status1){
            List<ShopTime> shopTimeList = shop.getShopTimes();
            
            for (ShopTime shopTime : shopTimeList) {
                String query2="INSERT INTO shop_time VALUES(?,?,?,?)";
                Object[] data2={shopTime.getShopId(),shopTime.getDate(),shopTime.getStartTime(),shopTime.getEndTime()};
                status2 = DBHandle.setData(DBConnection.getConnectionToDB(), query2, data2);
                if(!status2){
                    return false;
                }   
            }
            
            List<Item> items = shop.getItems();
            
            for (Item item : items) {
                String query3="INSERT INTO shop_item_detail VALUES(?,?)";
                Object[] data3={shop.getShopId(),item.getItemId()};
                status2 = DBHandle.setData(DBConnection.getConnectionToDB(), query3, data3);
                if(!status2){
                    return false;
                }   
            }
            status2 =true;
        }
        return status2;
    }

    public static List<Shop> searchShopsByOwner(int ownerId) throws ClassNotFoundException, SQLException {
        String query="SELECT * FROM shop WHERE ownerId = ?";
        Object[] data={ownerId};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        List<Shop> shopList=new ArrayList<Shop>();
        while(resultSet.next()){
            Shop shop=new Shop(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),  resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getInt(7), resultSet.getString(8));
            shopList.add(shop);
        }
        return shopList;
    }
    
    public static Shop searchShopByShopId(int shopId) throws ClassNotFoundException, SQLException {
        String query="SELECT * FROM shop WHERE shopId = ?";
        Object[] data={shopId};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        Shop shop=null;
        if(resultSet.next()){
            shop =new Shop(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),  resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getInt(7), resultSet.getString(8));
        }
        return shop;
    }
    
    public static Shop searchShopByMaskedNo(String maskedNo) throws ClassNotFoundException, SQLException {
        String query="SELECT * FROM shop WHERE shopMaskedNo = ?";
        Object[] data={maskedNo};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        Shop shop=null;
        if(resultSet.next()){
            shop =new Shop(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),  resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getInt(7), resultSet.getString(8));
        }
        return shop;
    }
    
    public static boolean updateMaskedNo(int shopId,String maskedNo) throws ClassNotFoundException, SQLException {
        String query="UPDATE shop SET shopMaskedNo=? WHERE shopId=?";
        Object[] data={maskedNo,shopId};
        if(DBHandle.setData(DBConnection.getConnectionToDB(), query, data)){
            return true;
        }
        return false;
    }
    
    public static List<Shop> searchAvailableShops(int categoryId,int itemId) throws ClassNotFoundException, SQLException {
        String query="SELECT shp.shopId,shp.shopName,shp.shopAddress,shp.shopContactNo,shp.shopLongitude,shp.shopLattitude,shp.ownerId,shp.shopMaskedNo\n" +
                        "FROM shop shp,shop_item_detail sid\n" +
                        "WHERE shp.shopId=sid.shopId AND shp.shopMaskedNo != '' AND\n" +
                        "sid.itemId in\n" +
                        "(\n" +
                        "	SELECT i.itemId\n" +
                        "	FROM category c,item i\n" +
                        "	WHERE i.categoryId = c.categoryId AND\n" +
                        "	c.categoryId = ? AND\n" +
                        "	i.itemId = ?		\n" +
                        ")\n" +
                        "GROUP BY shp.shopId ;";
        
        Object[] data={categoryId,itemId};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        List<Shop> shopList=new ArrayList<Shop>();
        while(resultSet.next()){
            Shop shop=new Shop(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),  resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getInt(7), resultSet.getString(8));
            shopList.add(shop);
        }
        return shopList;
    }
    
    public static Boolean deleteShop(int shopId) throws ClassNotFoundException, SQLException {
        String query="DELETE FROM shop  WHERE shopId=?";
        Object[] data={shopId};
        if(DBHandle.setData(DBConnection.getConnectionToDB(), query, data)){
            return true;
        }
        return false;
    }
    
    public static Boolean updateShop(Shop shop) throws ClassNotFoundException, SQLException {
       boolean status = false;
        if(ShopController.searchShopByShopId(shop.getShopId()) != null){
            if(ShopController.deleteShop(shop.getShopId())){
                if(ShopController.addShop(shop)){
                    return true;
                }
            }else{
                return false;
            }
        } else {
            if(ShopController.addShop(shop)){
                    return true;
            }else{
                return false;
            }
        }
        return false;
    }    
    
    
}

/*

SELECT shp.shopId,shp.shopName,shp.shopAddress,shp.shopContactNo,shp.shopLongitude,shp.shopLattitude,shp.ownerId,shp.shopMaskedNo
FROM shop shp,shop_item_detail sid
WHERE shp.shopId=sid.shopId AND shp.shopMaskedNo != ''AND
sid.itemId in
(
	SELECT i.itemId
	FROM category c,item i
	WHERE i.categoryId = c.categoryId AND
	c.categoryId = 1 AND
	i.itemId = 11		
)
GROUP BY shp.shopId ;
Tel:0771238923
*/