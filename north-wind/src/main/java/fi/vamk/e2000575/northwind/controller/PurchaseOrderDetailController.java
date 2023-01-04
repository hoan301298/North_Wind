package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.PurchaseOrder;
import fi.vamk.e2000575.northwind.entity.PurchaseOrderDetail;
import fi.vamk.e2000575.northwind.service.PurchaseOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PurchaseOrderDetail")
public class PurchaseOrderDetailController {

    @Autowired
    private PurchaseOrderDetailService PurchaseOrderDetailService;

    @GetMapping
    public ResponseEntity<?> getPurchaseOrderDetail() {
        List<PurchaseOrderDetail> PurchaseOrderDetail = PurchaseOrderDetailService.getPurchaseOrderDetail();
        return ResponseEntity.ok(PurchaseOrderDetail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchaseOrderDetailById(@PathVariable int id) {
        Optional<PurchaseOrderDetail> PurchaseOrderDetail = PurchaseOrderDetailService.getPurchaseOrderDetailById(id);
        return ResponseEntity.ok(PurchaseOrderDetail);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPurchaseOrderDetail(@RequestParam(name = "keyword") PurchaseOrder purchaseOrder) {
        List<PurchaseOrderDetail> PurchaseOrderDetail = PurchaseOrderDetailService.searchPurchaseOrderDetail(purchaseOrder);
        return ResponseEntity.ok(PurchaseOrderDetail);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<?> createPurchaseOrderDetail(@RequestBody PurchaseOrderDetail result) {
        PurchaseOrderDetail PurchaseOrderDetail = PurchaseOrderDetailService.createPurchaseOrderDetail(result);
        return ResponseEntity.ok(PurchaseOrderDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePurchaseOrderDetail(@PathVariable int id, @RequestBody PurchaseOrderDetail result) {
        PurchaseOrderDetail PurchaseOrderDetail = PurchaseOrderDetailService.updatePurchaseOrderDetail(id, result);
        return ResponseEntity.ok(PurchaseOrderDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchaseOrderDetail(@PathVariable("id") int id) {
        List<PurchaseOrderDetail> PurchaseOrderDetail = PurchaseOrderDetailService.deletePurchaseOrderDetail(id);
        return ResponseEntity.ok(PurchaseOrderDetail);
    }

}