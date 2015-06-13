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

/**
 *
 * @author Heshan
 */
public class ShopItemController {
    
    //addItemDetailShop(List<Item>,shopId)
    // updateItemDetailShop(List<Item>,shopId)
    
    public static List<Item> searchItemsbById(String shopId) throws ClassNotFoundException, SQLException {
        String query="SELECT i.itemId,i.itemName,i.categoryId FROM item i ,shop_item_detail sid WHERE sid.itemId = i.itemId AND sid.shopId = ?";
        Object[] data={shopId};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        List<Item> items = new ArrayList<Item>();
        while(resultSet.next()){
            Item item =new Item(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3));
            items.add(item);
        }
        return items;
    }
    
    public static boolean addNewItemDetail(List<Item> items,String shopId) throws ClassNotFoundException, SQLException {
        boolean status = false;
        for (Item item : items) {
            String query="INSERT INTO shop_item_detail VALUES(?,?)";
            Object[] data ={shopId,item.getItemId()};
                status = DBHandle.setData(DBConnection.getConnectionToDB(), query, data);
                if(!status){
                    return status;
                }  
        }
        return status;
    }
    

    
}
