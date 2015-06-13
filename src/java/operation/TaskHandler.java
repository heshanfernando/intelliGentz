/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import controllers.ShopController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Shop;
import models.Task;

/**
 *
 * @author Heshan
 */
public class TaskHandler {
    
    //getAvailableShops(String itemName,String categoryName,double customerLongitude,double customerLattitude,int checkingDistance) ---> checkingDistance(Km)
    public static List<Shop> getAvailableShops(int itemId,int categoryId,double customerLongitude,double customerLattitude,int checkingDistance) throws ClassNotFoundException, SQLException{
        List<Shop> shopsList = ShopController.searchAvailableShops(categoryId, itemId); // not filtered from distance
        List<Shop> availableShops = new ArrayList<Shop>();
        
        for (Shop shop : shopsList) {
            if(isLocatedIntheRange(shop, customerLongitude, customerLattitude, checkingDistance)){
                availableShops.add(shop);
            }
        }
        return availableShops;
    }
    
    // check whether shop is at the given range 
    private static boolean isLocatedIntheRange(Shop shop,double customerLongitude,double customerLattitude,int checkingDistance){ 
        double shopLongitude = shop.getShopLongitude();
        double shopLattitude = shop.getShopLattitude();
        
        double R = 6378.137; // Radius of earth in KM
        double dLon = (customerLongitude - shopLongitude) * Math.PI / 180;
        double dLat = (customerLattitude - shopLattitude) * Math.PI / 180;
        
        dLon = Math.abs(dLon);
        dLat = Math.abs(dLat);
        
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
        Math.cos(shopLattitude * Math.PI / 180) * Math.cos(customerLattitude * Math.PI / 180) *
        Math.sin(dLon/2) * Math.sin(dLon/2);
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = R * c;    // distance -> kilometers
        
        if((distance <= checkingDistance)){
            return true;
        }else{
            return false;
        }
    }
    
    
    // store task
    public void storeNewTask(Task task){
        //TaskController.addNewTask(task);
    }
    
    /////////// store task details   (New task details & updating process) /////////////////
    
        //addNewTaskDetail(TaskDetail)    ---> when send message to the seller
        //updateTaskDetail(TaskDetail)    ---> when received message from the seller
        
    /////////////////////////// configure timer /////////////////////////////////////////////
       // * timing 
       // * incerse the distance to check
       // * storing data in db
    
    
    
}
