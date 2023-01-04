package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.Invoice;
import fi.vamk.e2000575.northwind.entity.Order;
import fi.vamk.e2000575.northwind.repository.InvoiceRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceService {
    @Autowired
    private InvoiceRepository InvoiceRepository;
    @Autowired
    private Order Order;

    public List<Invoice> getInvoice() {
        List<Invoice> Invoice = InvoiceRepository.findAll();
        return Invoice;
    }
    public Optional<Invoice> getInvoiceById(int id) {
        Optional<Invoice> Invoice = InvoiceRepository.findById(id);
        return Invoice;
    }

    public List<Invoice> searchInvoice(Order order){
        List<Invoice> result = new ArrayList<>();
        for(Invoice Invoices : getInvoice()) {
            if(Invoices.getOrder().equals(order))
                result.add(Invoices);
        }
        return result;
    }
    public Invoice createInvoice(Invoice result){
        return InvoiceRepository.save(result);
    }

    public Invoice updateInvoice(int id, @NotNull Invoice result){
        if(result.getId() == id) {
            return InvoiceRepository.save(result);
        } else {
            return null;
        }
    }

    public List<Invoice> deleteInvoice(int id) {
        Optional<Invoice> result = InvoiceRepository.findById(id);
        if(result.isPresent()) {
            InvoiceRepository.deleteById(id);
            return getInvoice();
        } else {
            return null;
        }
    }
}
