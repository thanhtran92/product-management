package com.thanh.model;

/**
 * This is a model class represents a product entity.
 * 
 * @author thanhtran
 *
 */
public class Product {

    private int id;
    private String name;
    private String price;
    private String category;
    private String description;

    public Product() {
        super();
    }

    public Product(int id) {
        super();
        this.id = id;
    }

    public Product(String name, String price, String category, String description) {
        super();
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public Product(int id, String name, String price, String category, String description) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
