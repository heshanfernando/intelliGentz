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
public class Shop {
    private int shopId;
    private String shopName;
    private String shopAddress;
    private String shopContactNo;
    private double shopLongitude;
    private double shopLattitude;
    private int ownerId;
    private String shopMaskedNo;
    private List<ShopTime> shopTimes;
    private List<Item> items;
    

    public Shop(int shopId, String shopName, String shopAddress, String shopContactNo, double shopLongitude, double shopLattitude, int ownerId, String shopMaskedNo) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopContactNo = shopContactNo;
        this.shopLongitude = shopLongitude;
        this.shopLattitude = shopLattitude;
        this.ownerId = ownerId;
        this.shopMaskedNo = shopMaskedNo;
    }

    public Shop(String shopName, String shopAddress, String shopContactNo, double shopLongitude, double shopLattitude, int ownerId, String shopMaskedNo) {
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopContactNo = shopContactNo;
        this.shopLongitude = shopLongitude;
        this.shopLattitude = shopLattitude;
        this.ownerId = ownerId;
        this.shopMaskedNo = shopMaskedNo;
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
     * @return the shopName
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * @param shopName the shopName to set
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * @return the shopAddress
     */
    public String getShopAddress() {
        return shopAddress;
    }

    /**
     * @param shopAddress the shopAddress to set
     */
    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    /**
     * @return the shopContactNo
     */
    public String getShopContactNo() {
        return shopContactNo;
    }

    /**
     * @param shopContactNo the shopContactNo to set
     */
    public void setShopContactNo(String shopContactNo) {
        this.shopContactNo = shopContactNo;
    }

    /**
     * @return the shopLongitude
     */
    public double getShopLongitude() {
        return shopLongitude;
    }

    /**
     * @param shopLongitude the shopLongitude to set
     */
    public void setShopLongitude(double shopLongitude) {
        this.shopLongitude = shopLongitude;
    }

    /**
     * @return the shopLattitude
     */
    public double getShopLattitude() {
        return shopLattitude;
    }

    /**
     * @param shopLattitude the shopLattitude to set
     */
    public void setShopLattitude(double shopLattitude) {
        this.shopLattitude = shopLattitude;
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
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * @return the shopMaskedNo
     */
    public String getShopMaskedNo() {
        return shopMaskedNo;
    }

    /**
     * @param shopMaskedNo the shopMaskedNo to set
     */
    public void setShopMaskedNo(String shopMaskedNo) {
        this.shopMaskedNo = shopMaskedNo;
    }

    /**
     * @return the shopTimes
     */
    public List<ShopTime> getShopTimes() {
        return shopTimes;
    }

    /**
     * @param shopTimes the shopTimes to set
     */
    public void setShopTimes(List<ShopTime> shopTimes) {
        this.shopTimes = shopTimes;
    }


}
