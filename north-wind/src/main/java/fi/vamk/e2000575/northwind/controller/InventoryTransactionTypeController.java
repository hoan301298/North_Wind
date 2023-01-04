package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.InventoryTransactionType;
import fi.vamk.e2000575.northwind.service.InventoryTransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/InventoryTransactionType")
public class InventoryTransactionTypeController {

    @Autowired
    private InventoryTransactionTypeService InventoryTransactionTypeService;

    @GetMapping
    public ResponseEntity<?> getInventoryTransactionType() {
        List<InventoryTransactionType> InventoryTransactionType = InventoryTransactionTypeService.getInventoryTransactionType();
        return ResponseEntity.ok(InventoryTransactionType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInventoryTransactionTypeById(@PathVariable Byte id) {
        Optional<InventoryTransactionType> InventoryTransactionType = InventoryTransactionTypeService.getInventoryTransactionTypeById(id);
        return ResponseEntity.ok(InventoryTransactionType);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchInventoryTransactionType(@RequestParam(name = "keyword") String company) {
        List<InventoryTransactionType> InventoryTransactionType = InventoryTransactionTypeService.searchInventoryTransactionType(company);
        return ResponseEntity.ok(InventoryTransactionType);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createInventoryTransactionType(@RequestBody InventoryTransactionType result) {
        InventoryTransactionType InventoryTransactionType = InventoryTransactionTypeService.createInventoryTransactionType(result);
        return ResponseEntity.ok(InventoryTransactionType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInventoryTransactionType(@PathVariable Byte id, @RequestBody InventoryTransactionType result) {
        InventoryTransactionType InventoryTransactionType = InventoryTransactionTypeService.updateInventoryTransactionType(id, result);
        return ResponseEntity.ok(InventoryTransactionType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInventoryTransactionType(@PathVariable("id") Byte id) {
        List<InventoryTransactionType> InventoryTransactionType = InventoryTransactionTypeService.deleteInventoryTransactionType(id);
        return ResponseEntity.ok(InventoryTransactionType);
    }

}
