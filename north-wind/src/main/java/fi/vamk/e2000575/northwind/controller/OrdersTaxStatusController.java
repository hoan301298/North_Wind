package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.OrdersTaxStatus;
import fi.vamk.e2000575.northwind.service.OrdersTaxStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OrdersTaxStatus")
public class OrdersTaxStatusController {

    @Autowired
    private OrdersTaxStatusService OrdersTaxStatusService;

    @GetMapping
    public ResponseEntity<?> getOrdersTaxStatus() {
        List<OrdersTaxStatus> OrdersTaxStatus = OrdersTaxStatusService.getOrdersTaxStatus();
        return ResponseEntity.ok(OrdersTaxStatus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrdersTaxStatusById(@PathVariable Byte id) {
        Optional<OrdersTaxStatus> OrdersTaxStatus = OrdersTaxStatusService.getOrdersTaxStatusById(id);
        return ResponseEntity.ok(OrdersTaxStatus);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchOrdersTaxStatus(@RequestParam(name = "keyword") String company) {
        List<OrdersTaxStatus> OrdersTaxStatus = OrdersTaxStatusService.searchOrdersTaxStatus(company);
        return ResponseEntity.ok(OrdersTaxStatus);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createOrdersTaxStatus(@RequestBody OrdersTaxStatus result) {
        OrdersTaxStatus OrdersTaxStatus = OrdersTaxStatusService.createOrdersTaxStatus(result);
        return ResponseEntity.ok(OrdersTaxStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrdersTaxStatus(@PathVariable Byte id, @RequestBody OrdersTaxStatus result) {
        OrdersTaxStatus OrdersTaxStatus = OrdersTaxStatusService.updateOrdersTaxStatus(id, result);
        return ResponseEntity.ok(OrdersTaxStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrdersTaxStatus(@PathVariable("id") Byte id) {
        List<OrdersTaxStatus> OrdersTaxStatus = OrdersTaxStatusService.deleteOrdersTaxStatus(id);
        return ResponseEntity.ok(OrdersTaxStatus);
    }

}
