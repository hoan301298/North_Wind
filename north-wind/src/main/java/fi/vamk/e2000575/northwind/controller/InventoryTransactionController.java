package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.InventoryTransaction;
import fi.vamk.e2000575.northwind.entity.PurchaseOrder;
import fi.vamk.e2000575.northwind.service.InventoryTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/InventoryTransaction")
public class InventoryTransactionController {

    @Autowired
    private InventoryTransactionService InventoryTransactionService;

    @GetMapping
    public ResponseEntity<?> getInventoryTransaction() {
        List<InventoryTransaction> InventoryTransaction = InventoryTransactionService.getInventoryTransaction();
        return ResponseEntity.ok(InventoryTransaction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInventoryTransactionById(@PathVariable int id) {
        Optional<InventoryTransaction> InventoryTransaction = InventoryTransactionService.getInventoryTransactionById(id);
        return ResponseEntity.ok(InventoryTransaction);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchInventoryTransaction(@RequestParam(name = "keyword") PurchaseOrder purchaseOrder) {
        List<InventoryTransaction> InventoryTransaction = InventoryTransactionService.searchInventoryTransaction(purchaseOrder);
        return ResponseEntity.ok(InventoryTransaction);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<?> createInventoryTransaction(@RequestBody InventoryTransaction result) {
        InventoryTransaction InventoryTransaction = InventoryTransactionService.createInventoryTransaction(result);
        return ResponseEntity.ok(InventoryTransaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInventoryTransaction(@PathVariable int id, @RequestBody InventoryTransaction result) {
        InventoryTransaction InventoryTransaction = InventoryTransactionService.updateInventoryTransaction(id, result);
        return ResponseEntity.ok(InventoryTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInventoryTransaction(@PathVariable("id") int id) {
        List<InventoryTransaction> InventoryTransaction = InventoryTransactionService.deleteInventoryTransaction(id);
        return ResponseEntity.ok(InventoryTransaction);
    }
}
