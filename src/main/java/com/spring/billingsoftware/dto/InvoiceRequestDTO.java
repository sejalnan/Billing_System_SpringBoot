package com.spring.billingsoftware.dto;

import com.spring.billingsoftware.entity.Customer;
import com.spring.billingsoftware.entity.InvoiceItem;
import java.util.List;

public class InvoiceRequestDTO {
    private Customer customer;
    private List<InvoiceItem> items;
    private double discount;



}
