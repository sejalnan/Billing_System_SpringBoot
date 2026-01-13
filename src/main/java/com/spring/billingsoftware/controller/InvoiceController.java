package com.spring.billingsoftware.controller;

import com.spring.billingsoftware.dto.InvoiceRequestDTO;
import com.spring.billingsoftware.entity.Invoice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Invoice")

public class InvoiceController {


    @PostMapping
    public ResponseEntity<Invoice>  generateInvoice(@RequestBody InvoiceRequestDTO invoiceRequestDTO){


        return null;
    }
}
