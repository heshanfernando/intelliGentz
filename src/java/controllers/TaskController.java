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
import models.Item;
import models.Task;

/**
 *
 * @author Heshan
 */
public class TaskController {

    public static boolean addNewTask(Task task) throws ClassNotFoundException, SQLException {
        int taskId = Integer.parseInt(GenerateId.generateId("", "task", "taskId"));
        String query="INSERT INTO task VALUES(?,?,?,?,?,?,?)";
        Object[] data={task.getTaskId(),task.getMobileNo(),task.getTaskLongitude(),task.getTaskLatitude(),task.getTimeStarted(),task.getRecievedMessage(),task.getRequestedItem().getItemId()};
        boolean status = DBHandle.setData(DBConnection.getConnectionToDB(), query, data);
        return status;
    }
    

    // viewTask(taskId) 
    public static Task searchTask(int taskId) throws ClassNotFoundException, SQLException {
        String query="SELECT * FROM task WHERE taskId = ?";
        Object[] data={taskId};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        Task task=new Task(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getDate(5), resultSet.getString(6));
        Item item = ItemController.searchItem(resultSet.getInt(7));
        task.setRequestedItem(item);
        return task;
    }   
    // viewTask(mobileNo)
    public static Task searchTask(String mobileNo) throws ClassNotFoundException, SQLException {
        String query="SELECT * FROM task WHERE mobileNo = ?";
        Object[] data={mobileNo};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        Task task=new Task(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getDate(5), resultSet.getString(6));
        Item item = ItemController.searchItem(resultSet.getInt(7));
        task.setRequestedItem(item);
        return task;
    }  
    
    // getAllTask(Date) 
    public static List<Task> getAllTasks() throws ClassNotFoundException, SQLException {
        String query="SELECT * FROM task";
        Object[] data={};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        List<Task> taskList=new ArrayList<Task>();
        while(resultSet.next()){
            Task task=new Task(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getDate(5), resultSet.getString(6));
            Item item = ItemController.searchItem(resultSet.getInt(7));
            task.setRequestedItem(item);
            taskList.add(task);
        }
        return taskList;
    }
    
}
