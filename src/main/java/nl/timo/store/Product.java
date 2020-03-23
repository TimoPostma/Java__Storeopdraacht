package nl.timo.store;

/**
 * @author Timo Postma
 * @version 1.0
 * @since feb 2020
 * MIT License
 * Copyright 2020 Voornaam Achternaam
 */
public class Product {
    private int productId;
    private String brand;
    private String type;
    private double price;



    public Product(int productId, String brand, String type, double price) {
        this.productId = productId;
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
