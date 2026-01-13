package com.spring.billingsoftware.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Invoice {

    private String invoiceId;
    private LocalDateTime invoiceDate;
    private Customer customer;
    private double totalAmount;
    private double totalTax;
    private double discount;
    private double finalAmount;
    private List<InvoiceItem> items;

    public Invoice(String invoiceId, LocalDateTime invoiceDate, Customer customer,
                   double totalAmount, double totalTax, double discount,
                   double finalAmount, List<InvoiceItem> items) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.totalTax = totalTax;
        this.discount = discount;
        this.finalAmount = finalAmount;
        this.items = items;
    }

    public Invoice(){

    }
    public String getInvoiceId() { return invoiceId; }
    public void setInvoiceId(String invoiceId) { this.invoiceId = invoiceId; }

    public LocalDateTime getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(LocalDateTime invoiceDate) { this.invoiceDate = invoiceDate; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getTotalTax() { return totalTax; }
    public void setTotalTax(double totalTax) { this.totalTax = totalTax; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public double getFinalAmount() { return finalAmount; }
    public void setFinalAmount(double finalAmount) { this.finalAmount = finalAmount; }

    public List<InvoiceItem> getItems() { return items; }
    public void setItems(List<InvoiceItem> items) { this.items = items; }
}
