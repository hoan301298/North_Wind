package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.Supplier;
import fi.vamk.e2000575.northwind.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Supplier")
public class SupplierController {

    @Autowired
    private SupplierService SupplierService;

    @GetMapping
    public ResponseEntity<?> getSupplier() {
        List<Supplier> Supplier = SupplierService.getSupplier();
        return ResponseEntity.ok(Supplier);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSupplierById(@PathVariable int id) {
        Optional<Supplier> Supplier = SupplierService.getSupplierById(id);
        return ResponseEntity.ok(Supplier);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchSupplier(@RequestParam(name = "keyword") String company) {
        List<Supplier> Supplier = SupplierService.searchSupplier(company);
        return ResponseEntity.ok(Supplier);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createSupplier(@RequestBody Supplier result) {
        Supplier Supplier = SupplierService.createSupplier(result);
        return ResponseEntity.ok(Supplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSupplier(@PathVariable int id, @RequestBody Supplier result) {
        Supplier Supplier = SupplierService.updateSupplier(id, result);
        return ResponseEntity.ok(Supplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable("id") int id) {
        Supplier Supplier = SupplierService.deleteSupplier(id);
        return ResponseEntity.ok(Supplier);
    }

}
