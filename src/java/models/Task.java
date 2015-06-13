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
public class Task {
    private int taskId;
    private String mobileNo;
    private double taskLongitude ;
    private double taskLatitude;
    private Date timeStarted;
    private String recievedMessage;
    private Item requestedItem;

    public Task(int taskId, String mobileNo, double taskLongitude, double taskLatitude, Date timeStarted, String recievedMessage) {
        this.taskId = taskId;
        this.mobileNo = mobileNo;
        this.taskLongitude = taskLongitude;
        this.taskLatitude = taskLatitude;
        this.timeStarted = timeStarted;
        this.recievedMessage = recievedMessage;
    }

    
    public Task(int taskId, String mobileNo, double taskLongitude, double taskLatitude, Date timeStarted, String recievedMessage, int requestedItemId) {
        this.taskId = taskId;
        this.mobileNo = mobileNo;
        this.taskLongitude = taskLongitude;
        this.taskLatitude = taskLatitude;
        this.timeStarted = timeStarted;
        this.recievedMessage = recievedMessage;
        Item requestedItem = new Item(requestedItemId);
        this.requestedItem = requestedItem;
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
     * @return the mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo the mobileNo to set
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * @return the taskLongitude
     */
    public double getTaskLongitude() {
        return taskLongitude;
    }

    /**
     * @param taskLongitude the taskLongitude to set
     */
    public void setTaskLongitude(double taskLongitude) {
        this.taskLongitude = taskLongitude;
    }

    /**
     * @return the taskLatitude
     */
    public double getTaskLatitude() {
        return taskLatitude;
    }

    /**
     * @param taskLatitude the taskLatitude to set
     */
    public void setTaskLatitude(double taskLatitude) {
        this.taskLatitude = taskLatitude;
    }

    /**
     * @return the timeStarted
     */
    public Date getTimeStarted() {
        return timeStarted;
    }

    /**
     * @param timeStarted the timeStarted to set
     */
    public void setTimeStarted(Date timeStarted) {
        this.timeStarted = timeStarted;
    }

    /**
     * @return the recievedMessage
     */
    public String getRecievedMessage() {
        return recievedMessage;
    }

    /**
     * @param recievedMessage the recievedMessage to set
     */
    public void setRecievedMessage(String recievedMessage) {
        this.recievedMessage = recievedMessage;
    }

    /**
     * @return the requestedItem
     */
    public Item getRequestedItem() {
        return requestedItem;
    }

    /**
     * @param requestedItem the requestedItem to set
     */
    public void setRequestedItem(Item requestedItem) {
        this.requestedItem = requestedItem;
    }

    
}
