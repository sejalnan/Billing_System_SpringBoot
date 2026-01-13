package com.spring.billingsoftware.repository;
import com.spring.billingsoftware.entity.Invoice;
import com.spring.billingsoftware.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {

    private final ArrayList<Invoice> list = new ArrayList<>();


    public List<Invoice> findAllInvoices() {
        return list;
    }


    public Invoice findInvoiceById(String id) {
        return list.stream()
                .filter(i -> i.getInvoiceId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Add new invoice
    public Invoice addInvoice(Invoice invoice) {
        list.add(invoice);
        return invoice;
    }


    public List<Invoice> findInvoicesByCustomerId(String customerId) {
        List<Invoice> result = new ArrayList<>();

        for (Invoice invoice : list) {
            if (invoice.getCustomer().getId().equals(customerId)) {
                result.add(invoice);
            }
        }
        return result;
    }

    // Update invoice
    public boolean updateById(String id, Invoice invoice) {
        Invoice existingInvoice = findInvoiceById(id);

        if (existingInvoice != null) {
            existingInvoice.setItems(invoice.getItems());
            existingInvoice.setInvoiceDate(invoice.getInvoiceDate());
            existingInvoice.setDiscount(invoice.getDiscount());
            existingInvoice.setCustomer(invoice.getCustomer());
            existingInvoice.setItems(invoice.getItems());
            existingInvoice.setTotalAmount(invoice.getTotalAmount());

            return true;
        } else {
            throw new ResourceNotFoundException("Invoice Not Found...");
        }
    }
}
