/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Heshan
 */
public class Item {
    private int itemId;
    private String itemName;
    private Category category;

    public Item() {
    }

    public Item(int itemId) {
        this.itemId = itemId;
    }
    
    

    public Item(int itemId, String itemName, int categoryId) {
        this.itemId = itemId;
        this.itemName = itemName;
        Category c = new Category(categoryId);
        this.category = c;
    }

    public Item(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }
    
    
    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return getItemName();
    }

    /**
     * @param itemName the itemName to set
     */
    public void setName(String itemName) {
        this.setItemName(itemName);
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    
}
