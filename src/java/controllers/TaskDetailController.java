/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.DBConnection;
import db.DBHandle;
import db.GenerateId;
import java.sql.SQLException;
import java.util.Date;
import models.TaskDetail;

/**
 *
 * @author Heshan
 */
public class TaskDetailController {
    
    public static boolean addNewTaskDetail(TaskDetail taskDetail) throws ClassNotFoundException, SQLException{
        int taskDetailId = Integer.parseInt(GenerateId.generateId("", "task_detail", "taskDetailId"));
        String query="INSERT INTO task_detail VALUES(?,?,?,?,?)";
        Object[] data={taskDetail.getTaskDetailId(),taskDetail.getTaskId(),taskDetail.getShopId(),taskDetail.getResponseTime(),taskDetail.isItemAvailability()};
        boolean status = DBHandle.setData(DBConnection.getConnectionToDB(), query, data);
        return status;
    }
    public static boolean updateTaskDetail(int taskDetailId,boolean availability,Date responseTime) throws ClassNotFoundException, SQLException{
        String query="UPDATE task_detail SET responseTime=?,itemAvailability=? WHERE taskDetailId = ?";
        System.out.println(availability+" "+responseTime+" "+taskDetailId);
        Object[] data={responseTime,availability,taskDetailId};
        boolean status = DBHandle.setData(DBConnection.getConnectionToDB(), query, data);
        return status;
    }
}
