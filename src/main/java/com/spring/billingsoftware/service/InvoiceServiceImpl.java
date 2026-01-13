package com.spring.billingsoftware.service;

import com.spring.billingsoftware.Interface.InvoiceService;
import com.spring.billingsoftware.entity.Customer;
import com.spring.billingsoftware.entity.Invoice;
import com.spring.billingsoftware.entity.InvoiceItem;
import com.spring.billingsoftware.entity.Product;
import com.spring.billingsoftware.dto.InvoiceRequestDTO;
import com.spring.billingsoftware.dto.InvoiceResponseDTO;
import com.spring.billingsoftware.exception.InsufficientStockException;
import com.spring.billingsoftware.exception.ResourceNotFoundException;
import com.spring.billingsoftware.repository.CustomerRepository;
import com.spring.billingsoftware.repository.InvoiceRepository;
import com.spring.billingsoftware.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
                              CustomerRepository customerRepository,
                              ProductRepository productRepository) {
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public InvoiceResponseDTO generateInvoice(InvoiceRequestDTO request) {


        Customer customer = customerRepository.findCutomerById(request.getCustomer().getId());
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found");
        }

        List<InvoiceItem> invoiceItems = new ArrayList<>();
        double totalAmount = 0;
        double totalTax = 0;


        for (InvoiceItem item : request.getItems()) {
            Product product = productRepository.findProductById(item.getProduct().getId());
            if (product == null) {
                throw new ResourceNotFoundException("Product not found");
            }
            if (product.getStockQuantity() < item.getQuantity()) {
                throw new InsufficientStockException("Insufficient stock for product: " + product.getName());
            }


            double price = product.getPrice() * item.getQuantity();
            double tax = price * product.getGstPercentage() / 100;
            double total = price + tax;


            product.setStockQuantity(product.getStockQuantity() - item.getQuantity());


            InvoiceItem invoiceItem = new InvoiceItem(
                    item.getId(),
                    product,
                    item.getQuantity(),
                    price,
                    tax,
                    total
            );
            invoiceItems.add(invoiceItem);

            totalAmount += price;
            totalTax += tax;
        }

        double discount = request.getDiscount();
        double finalAmount = totalAmount + totalTax - discount;


        Invoice invoice = new Invoice();
        invoice.setInvoiceId(UUID.randomUUID().toString());
        invoice.setInvoiceDate(LocalDateTime.now());
        invoice.setCustomer(customer);
        invoice.setItems(invoiceItems);
        invoice.setTotalAmount(totalAmount);
        invoice.setTotalTax(totalTax);
        invoice.setDiscount(discount);
        invoice.setFinalAmount(finalAmount);

        invoiceRepository.addInvoice(invoice);

        return new InvoiceResponseDTO(
                invoice.getInvoiceId(),
                invoice.getInvoiceDate(),
                customer.getName(),
                totalAmount,
                totalTax,
                discount,
                finalAmount,
                invoiceItems
        );
    }

    @Override
    public List<InvoiceResponseDTO> getAllInvoices() {
        List<InvoiceResponseDTO> response = new ArrayList<>();
        for (Invoice invoice : invoiceRepository.findAllInvoices()) {
            response.add(new InvoiceResponseDTO(
                    invoice.getInvoiceId(),
                    invoice.getInvoiceDate(),
                    invoice.getCustomer().getName(),
                    invoice.getTotalAmount(),
                    invoice.getTotalTax(),
                    invoice.getDiscount(),
                    invoice.getFinalAmount(),
                    invoice.getItems()
            ));
        }
        return response;
    }

    @Override
    public InvoiceResponseDTO getInvoiceById(String invoiceId) {
        Invoice invoice = invoiceRepository.findInvoiceById(invoiceId);
        if (invoice == null) {
            throw new ResourceNotFoundException("Invoice not found");
        }
        return new InvoiceResponseDTO(
                invoice.getInvoiceId(),
                invoice.getInvoiceDate(),
                invoice.getCustomer().getName(),
                invoice.getTotalAmount(),
                invoice.getTotalTax(),
                invoice.getDiscount(),
                invoice.getFinalAmount(),
                invoice.getItems()
        );
    }

    @Override
    public List<InvoiceResponseDTO> getInvoicesByCustomer(String customerId) {
        List<Invoice> invoices = invoiceRepository.findInvoicesByCustomerId(customerId);
        List<InvoiceResponseDTO> response = new ArrayList<>();
        for (Invoice invoice : invoices) {
            response.add(new InvoiceResponseDTO(
                    invoice.getInvoiceId(),
                    invoice.getInvoiceDate(),
                    invoice.getCustomer().getName(),
                    invoice.getTotalAmount(),
                    invoice.getTotalTax(),
                    invoice.getDiscount(),
                    invoice.getFinalAmount(),
                    invoice.getItems()
            ));
        }
        return response;
    }
}
