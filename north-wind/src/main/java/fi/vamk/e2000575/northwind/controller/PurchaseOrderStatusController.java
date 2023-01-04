package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.PurchaseOrderStatus;
import fi.vamk.e2000575.northwind.service.PurchaseOrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PurchaseOrderStatus")
public class PurchaseOrderStatusController {

    @Autowired
    private PurchaseOrderStatusService PurchaseOrderStatusService;

    @GetMapping
    public ResponseEntity<?> getPurchaseOrderStatus() {
        List<PurchaseOrderStatus> PurchaseOrderStatus = PurchaseOrderStatusService.getPurchaseOrderStatus();
        return ResponseEntity.ok(PurchaseOrderStatus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchaseOrderStatusById(@PathVariable int id) {
        Optional<PurchaseOrderStatus> PurchaseOrderStatus = PurchaseOrderStatusService.getPurchaseOrderStatusById(id);
        return ResponseEntity.ok(PurchaseOrderStatus);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPurchaseOrderStatus(@RequestParam(name = "keyword") String company) {
        List<PurchaseOrderStatus> PurchaseOrderStatus = PurchaseOrderStatusService.searchPurchaseOrderStatus(company);
        return ResponseEntity.ok(PurchaseOrderStatus);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createPurchaseOrderStatus(@RequestBody PurchaseOrderStatus result) {
        PurchaseOrderStatus PurchaseOrderStatus = PurchaseOrderStatusService.createPurchaseOrderStatus(result);
        return ResponseEntity.ok(PurchaseOrderStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePurchaseOrderStatus(@PathVariable int id, @RequestBody PurchaseOrderStatus result) {
        PurchaseOrderStatus PurchaseOrderStatus = PurchaseOrderStatusService.updatePurchaseOrderStatus(id, result);
        return ResponseEntity.ok(PurchaseOrderStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchaseOrderStatus(@PathVariable("id") int id) {
        List<PurchaseOrderStatus> PurchaseOrderStatus = PurchaseOrderStatusService.deletePurchaseOrderStatus(id);
        return ResponseEntity.ok(PurchaseOrderStatus);
    }

}
