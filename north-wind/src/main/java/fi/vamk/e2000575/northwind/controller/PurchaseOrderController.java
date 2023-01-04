package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.PurchaseOrder;
import fi.vamk.e2000575.northwind.entity.Supplier;
import fi.vamk.e2000575.northwind.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PurchaseOrder")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService PurchaseOrderService;

    @GetMapping
    public ResponseEntity<?> getPurchaseOrder() {
        List<PurchaseOrder> PurchaseOrder = PurchaseOrderService.getPurchaseOrder();
        return ResponseEntity.ok(PurchaseOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchaseOrderById(@PathVariable int id) {
        Optional<PurchaseOrder> PurchaseOrder = PurchaseOrderService.getPurchaseOrderById(id);
        return ResponseEntity.ok(PurchaseOrder);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPurchaseOrder(@RequestParam(name = "keyword") Supplier supplier) {
        List<PurchaseOrder> PurchaseOrder = PurchaseOrderService.searchPurchaseOrder(supplier);
        return ResponseEntity.ok(PurchaseOrder);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createPurchaseOrder(@RequestBody PurchaseOrder result) {
        PurchaseOrder PurchaseOrder = PurchaseOrderService.createPurchaseOrder(result);
        return ResponseEntity.ok(PurchaseOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePurchaseOrder(@PathVariable int id, @RequestBody PurchaseOrder result) {
        PurchaseOrder PurchaseOrder = PurchaseOrderService.updatePurchaseOrder(id, result);
        return ResponseEntity.ok(PurchaseOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchaseOrder(@PathVariable("id") int id) {
        List<PurchaseOrder> PurchaseOrder = PurchaseOrderService.deletePurchaseOrder(id);
        return ResponseEntity.ok(PurchaseOrder);
    }

}
