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

/***
 *
 * @author Heshan
 * 
 **/

public class CategoryController {

    public static Boolean addCategory(Category category) throws ClassNotFoundException, SQLException {
        int categoryId = Integer.parseInt(GenerateId.generateId("", "category", "categoryId"));
        category.setCategoryId(categoryId);
        String query="INSERT INTO category VALUES(?,?)";
        Object[] data={category.getCategoryId(),category.getCategoryName()};
        boolean status = DBHandle.setData(DBConnection.getConnectionToDB(), query, data);
        return status;
    }
    
    
    public static List<Category> getAllCategories() throws ClassNotFoundException, SQLException {
        String query="SELECT * FROM category";
        Object[] data={};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        List<Category> categoryList=new ArrayList<Category>();
        while(resultSet.next()){
            Category category=new Category(resultSet.getInt(1), resultSet.getString(2));
            categoryList.add(category);
        }
        return categoryList;
    }
    
//    public static List<Category> searchCategories(String code) throws ClassNotFoundException, SQLException{
//        String quary ="SELECT c.categoryId,c.name FROM category c,item_category_details icd WHERE icd.categoryId = c.categoryId AND icd.itemId=?";
//        Object[] data=new Object[]{code};
//        ResultSet resultSet=DBHandle.getData(DBConnection.getConnectionToDB(), quary, data);
//        List<Category> categories = new ArrayList<Category>();
//        while(resultSet.next()){
//            Category category = new Category(resultSet.getInt(1), resultSet.getString(1));
//            categories.add(category);
//        }
//        return categories;
//    }
    
    public static Category searchCategory(int categoryId) throws ClassNotFoundException, SQLException {
        String query="SELECT * FROM category WHERE categoryId = ?";
        Object[] data={categoryId};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        Category category = null;
        if(resultSet.next()){
            category=new Category(resultSet.getInt(1), resultSet.getString(2));
        }
        return category;
    }    
}
