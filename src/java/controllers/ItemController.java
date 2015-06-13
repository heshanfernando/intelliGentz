/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.DBConnection;
import db.DBHandle;
import db.GenerateId;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Category;
import models.Item;

/**
 *
 * @author Heshan
 */
public class ItemController {
    
    public static Boolean addItem(Item item) throws ClassNotFoundException, SQLException {
//        int itemId = Integer.parseInt(GenerateId.generateId("", "item", "itemId"));
//        item.setItemId(itemId);
        String query="INSERT INTO item VALUES(?,?,?)";
        Object[] data={item.getItemId(),item.getName(),item.getCategory().getCategoryId()};
        boolean status = DBHandle.setData(DBConnection.getConnectionToDB(), query, data);
        return status;
    }
    
    public static List<Item> getAllItems() throws ClassNotFoundException, SQLException {
        String query="SELECT * FROM item";
        Object[] data={};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        List<Item> itemList=new ArrayList<Item>();
        while(resultSet.next()){
            Item item=new Item(resultSet.getInt(1), resultSet.getString(2));
            Category category = CategoryController.searchCategory(resultSet.getInt(3));
            item.setCategory(category);
            itemList.add(item);
        }
        return itemList;
    }    
    
    public static Item searchItem(int code) throws ClassNotFoundException, SQLException{
        String quary ="SELECT * FROM item WHERE itemId=?";
        Object[] data=new Object[]{code};
        ResultSet resultSet=DBHandle.getData(DBConnection.getConnectionToDB(), quary, data);
        if(resultSet.next()){
            Item item = new Item(resultSet.getInt(1), resultSet.getString(1));
            Category category = CategoryController.searchCategory(resultSet.getInt(3));
            item.setCategory(category);
            return item;
        }else{
            return null;
        }
    }
}
