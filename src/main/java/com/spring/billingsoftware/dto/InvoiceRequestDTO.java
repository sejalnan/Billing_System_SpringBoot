package com.spring.billingsoftware.dto;

import com.spring.billingsoftware.entity.Customer;
import com.spring.billingsoftware.entity.InvoiceItem;
import java.util.List;

public class InvoiceRequestDTO {

    private Customer customer;
    private List<InvoiceItem> items;
    private double discount;

    public InvoiceRequestDTO(Customer customer, List<InvoiceItem> items, double discount) {
        this.customer = customer;
        this.items = items;
        this.discount = discount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

