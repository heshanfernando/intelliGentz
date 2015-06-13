/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import controllers.ItemController;
import controllers.ShopController;
import controllers.TaskController;
import controllers.TaskDetailController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Item;
import models.Shop;
import models.ShopTime;
import models.Task;
import models.TaskDetail;
import operation.TaskHandler;

/**
 *
 * @author Heshan
 */
public class A extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//                  Shop shop = new  Shop(5, "Jnaka Electricals", "234,Sgara Road,Rathmalana", "077852941",  79.90233707270818, 6.794964000017729, 5, "Tel:072562303");
//                  Date startTime = new SimpleDateFormat("HH:mm:ss").parse("8:00:00");
//                  Date closeTime = new SimpleDateFormat("HH:mm:ss").parse("17:00:00");
//                  ShopTime shopTime1 = new ShopTime(5, "Weekdays", startTime, closeTime);
//                  
//                  startTime = new SimpleDateFormat("HH:mm:ss").parse("8:00:00");
//                  closeTime = new SimpleDateFormat("HH:mm:ss").parse("14:00:00");
//                  ShopTime shopTime2 = new ShopTime(5, "Weekends", startTime, closeTime);
//                  
//                  List<ShopTime> shopTimes = new  ArrayList<ShopTime>();
//                  shopTimes.add(shopTime1);
//                  shopTimes.add(shopTime2);
//                  
//                  shop.setShopTimes(shopTimes);
//                          
//                  Item  item1 =new Item(41);
//                  Item  item2 =new Item(44);
//                  
//                  List<Item> items = new ArrayList<Item>();
//                  items.add(item1);
//                  items.add(item2);
//                  
//                  shop.setItems(items);
//                  
//                  if(ShopController.addShop(shop)){
//                      out.println("Added,,,");
//                  }else{
//                      out.println("Error,,,");
//                  }
                  
//============================================================================================================================================
//            List<Shop> shops =TaskHandler.getAvailableShops(11, 1, 79.88505935616558, 6.787830378970233, 100);
//            
//            
//           // out.println("2222");
//            for (Shop shop : shops) {
//                out.println(shop.getShopName()+" "+shop.getShopAddress()+" "+shop.getShopContactNo()+"<br>");
//           }
//            
            
//===========================================================================================================================================
            
//            Item item = new Item(34, "Lorry", 3);
//            if(ItemController.addItem(item)){
//                out.println("Added,,,");
//            }else{
//                out.println("Error,,,");
//            }
            
//======================================================================================            
//            
//                  if(ShopController.updateMaskedNo(3, "Tel:0771238923")){
//                      out.println("updated,,,");
//                  }else{
//                      out.println("Error,,,");
//                  }
            
//            List<Item> items = ItemController.getAllItems();
//            
//            for (Item item : items) {
//                out.print(item.getItemName()+"<br>");
//            }
   
//=================================================================================================================            
            
//            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            Date date = new Date();
//            Task task = new Task(1, "0772345671", 76.234563892, 6.456783957, date, "Emerald Shirt", 11);
//            
//            
//            if(TaskController.addNewTask(task)){
//                out.print("Task added,!!!!");
//                TaskDetail taskDetail = new TaskDetail(1, 1, null, false);
//                if(TaskDetailController.addNewTaskDetail(taskDetail)){
//                out.print("TaskDetail added,!!!!");
//                }
//            }else{
//                out.print("Error,!!!!");
//            }
//            date = new Date();
//            if(TaskDetailController.updateTaskDetail(3,true,date)){
//                out.print("TaskDetail updated,!!!!");
//            }else{
//                out.print("Error,!!!!");
            
//===========================================================================================================
             Shop shop = new  Shop(5, "Janaka Electricals", "234,Gunathilake Road,Rathmalana", "077852941",  79.90233707270818, 6.794964000017729, 5, "Tel:072562303");
            Date startTime = new SimpleDateFormat("HH:mm:ss").parse("8:00:00");
            Date closeTime = new SimpleDateFormat("HH:mm:ss").parse("17:00:00");
            ShopTime shopTime1 = new ShopTime(5, "Weekdays", startTime, closeTime);

            startTime = new SimpleDateFormat("HH:mm:ss").parse("8:00:00");
            closeTime = new SimpleDateFormat("HH:mm:ss").parse("17:00:00");
            ShopTime shopTime2 = new ShopTime(5, "Weekends", startTime, closeTime);

            List<ShopTime> shopTimes = new  ArrayList<ShopTime>();
            shopTimes.add(shopTime1);
            shopTimes.add(shopTime2);

            shop.setShopTimes(shopTimes);

            Item  item1 =new Item(41);
            Item  item2 =new Item(44);
            Item  item3 =new Item(43);

            List<Item> items = new ArrayList<Item>();
            items.add(item1);
            items.add(item2);
            items.add(item3);

            shop.setItems(items);

            if(ShopController.updateShop(shop)){
                out.println("updated,,,");
            }else{
                out.println("Error,,,");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(A.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(A.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (ClassNotFoundException ex) {
            Logger.getLogger(A.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        // 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
