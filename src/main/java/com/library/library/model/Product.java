package com.library.library.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Product {



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        productname = productname;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    @Id
    @GeneratedValue
    public long id;
    public String productname;
    public String quantity;
    public int price;
    public int stock;
    public String description;
    public String imagename;

    public Product() {

    }


    public Product(String productname, String quantity, int price, int stock, String description, String imagename) {

    this.productname =productname;
    this.quantity =quantity;
    this.price =price;
    this.stock =stock;
    this.description =description;
    this.imagename =imagename;
}


}
