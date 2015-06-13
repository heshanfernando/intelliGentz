/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Heshan
 */
public class TaskDetail {
    private int taskDetailId;
    private int taskId;
    private int shopId;
    private Date responseTime;
    private boolean itemAvailability;

    public TaskDetail(int taskDetailId, int taskId, int shopId, Date responseTime, boolean itemAvailability) {
        this.taskDetailId = taskDetailId;
        this.taskId = taskId;
        this.shopId = shopId;
        this.responseTime = responseTime;
        this.itemAvailability = itemAvailability;
    }

    public TaskDetail(int taskId, int shopId, Date responseTime, boolean itemAvailability) {
        this.taskId = taskId;
        this.shopId = shopId;
        this.responseTime = responseTime;
        this.itemAvailability = itemAvailability;
    }

    /**
     * @return the taskDetailId
     */
    public int getTaskDetailId() {
        return taskDetailId;
    }

    /**
     * @param taskDetailId the taskDetailId to set
     */
    public void setTaskDetailId(int taskDetailId) {
        this.taskDetailId = taskDetailId;
    }

    /**
     * @return the taskId
     */
    public int getTaskId() {
        return taskId;
    }

    /**
     * @param taskId the taskId to set
     */
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    /**
     * @return the shopId
     */
    public int getShopId() {
        return shopId;
    }

    /**
     * @param shopId the shopId to set
     */
    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    /**
     * @return the responseTime
     */
    public Date getResponseTime() {
        return responseTime;
    }

    /**
     * @param responseTime the responseTime to set
     */
    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * @return the itemAvailability
     */
    public boolean isItemAvailability() {
        return itemAvailability;
    }

    /**
     * @param itemAvailability the itemAvailability to set
     */
    public void setItemAvailability(boolean itemAvailability) {
        this.itemAvailability = itemAvailability;
    }

    
    
}
