package com.spring.billingsoftware.entity;

public class InvoiceItem {

private  int id;
private Product product;
private int quantity;
private double price;
private double taxAmount;
private double total;

    public InvoiceItem(int quantity, double taxAmount, double total, double price, Product product, int id) {
        this.quantity = quantity;
        this.taxAmount = taxAmount;
        this.total = total;
        this.price = price;
        this.product = product;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
