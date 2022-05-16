package org.example;

public class Product {
    double cost;
    int id;
    String name;
    Double price;
    int quantity;

    public Product(int id, String name,Double price, int quantity) {
        this.cost = cost;
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "cost=" + cost +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
