/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;

/**
 *
 * @author Heshan
 */
public class Owner {
    private int ownerId;
    private String userName;
    private String password;
    private String ownerName;
    private String ownerContactNo;
    private String ownerNicNo;
    private List<Shop> shops;

    public Owner(int ownerId, String userName, String password, String ownerName, String ownerContactNo, String ownerNicNo) {
        this.ownerId = ownerId;
        this.userName = userName;
        this.password = password;
        this.ownerName = ownerName;
        this.ownerContactNo = ownerContactNo;
        this.ownerNicNo = ownerNicNo;
    }

    public Owner(String userName, String password, String ownerName, String ownerContactNo, String ownerNicNo) {
        this.userName = userName;
        this.password = password;
        this.ownerName = ownerName;
        this.ownerContactNo = ownerContactNo;
        this.ownerNicNo = ownerNicNo;
    }
    
    
    
    /**
     * @return the ownerId
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * @param ownerName the ownerName to set
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * @return the ownerNicNo
     */
    public String getOwnerNicNo() {
        return ownerNicNo;
    }

    /**
     * @param ownerNicNo the ownerNicNo to set
     */
    public void setOwnerNicNo(String ownerNicNo) {
        this.ownerNicNo = ownerNicNo;
    }

    /**
     * @return the ownerContactNo
     */
    public String getOwnerContactNo() {
        return ownerContactNo;
    }

    /**
     * @param ownerContactNo the ownerContactNo to set
     */
    public void setOwnerContactNo(String ownerContactNo) {
        this.ownerContactNo = ownerContactNo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the shops
     */
    public List<Shop> getShops() {
        return shops;
    }

    /**
     * @param shops the shops to set
     */
    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    
}
