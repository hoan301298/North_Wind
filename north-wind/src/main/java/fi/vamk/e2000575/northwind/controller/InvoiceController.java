package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.Invoice;
import fi.vamk.e2000575.northwind.entity.Order;
import fi.vamk.e2000575.northwind.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService InvoiceService;

    @GetMapping
    public ResponseEntity<?> getInvoice() {
        List<Invoice> Invoice = InvoiceService.getInvoice();
        return ResponseEntity.ok(Invoice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoiceById(@PathVariable int id) {
        Optional<Invoice> Invoice = InvoiceService.getInvoiceById(id);
        return ResponseEntity.ok(Invoice);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchInvoice(@RequestParam(name = "keyword") Order order) {
        List<Invoice> Invoice = InvoiceService.searchInvoice(order);
        return ResponseEntity.ok(Invoice);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createInvoice(@RequestBody Invoice result) {
        Invoice Invoice = InvoiceService.createInvoice(result);
        return ResponseEntity.ok(Invoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInvoice(@PathVariable int id, @RequestBody Invoice result) {
        Invoice Invoice = InvoiceService.updateInvoice(id, result);
        return ResponseEntity.ok(Invoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable("id") int id) {
        List<Invoice> Invoice = InvoiceService.deleteInvoice(id);
        return ResponseEntity.ok(Invoice);
    }

}
