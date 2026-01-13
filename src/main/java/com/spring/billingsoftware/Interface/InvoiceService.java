package com.spring.billingsoftware.Interface;

import com.spring.billingsoftware.dto.InvoiceRequestDTO;
import com.spring.billingsoftware.dto.InvoiceResponseDTO;
import java.util.List;

public interface InvoiceService {


    InvoiceResponseDTO generateInvoice(InvoiceRequestDTO request);

    List<InvoiceResponseDTO> getAllInvoices();

    InvoiceResponseDTO getInvoiceById(String invoiceId);

    List<InvoiceResponseDTO> getInvoicesByCustomer(String customerId);
}
