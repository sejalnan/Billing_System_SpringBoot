package com.spring.billingsoftware.controller;

import com.spring.billingsoftware.Interface.InvoiceService;
import com.spring.billingsoftware.dto.InvoiceRequestDTO;
import com.spring.billingsoftware.dto.InvoiceResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    // 1️⃣ POST /invoices → Generate new invoice
    @PostMapping
    public ResponseEntity<InvoiceResponseDTO> createInvoice(@RequestBody InvoiceRequestDTO request) {
        InvoiceResponseDTO response = invoiceService.generateInvoice(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 2️⃣ GET /invoices → Get all invoices
    @GetMapping
    public ResponseEntity<List<InvoiceResponseDTO>> getAllInvoices() {
        List<InvoiceResponseDTO> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }

    // 3️⃣ GET /invoices/{id} → Get invoice by ID
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponseDTO> getInvoiceById(@PathVariable String id) {
        InvoiceResponseDTO invoice = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoice);
    }

    // 4️⃣ GET /invoices/customer/{customerId} → Get invoices by customer ID
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<InvoiceResponseDTO>> getInvoicesByCustomer(@PathVariable String customerId) {
        List<InvoiceResponseDTO> invoices = invoiceService.getInvoicesByCustomer(customerId);
        return ResponseEntity.ok(invoices);
    }
}
