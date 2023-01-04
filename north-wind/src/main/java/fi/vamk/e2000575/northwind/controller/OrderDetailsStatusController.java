package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.OrderDetailsStatus;
import fi.vamk.e2000575.northwind.service.OrderDetailsStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OrderDetailsStatus")
public class OrderDetailsStatusController {

    @Autowired
    private OrderDetailsStatusService OrderDetailsStatusService;

    @GetMapping
    public ResponseEntity<?> getOrderDetailsStatus() {
        List<OrderDetailsStatus> OrderDetailsStatus = OrderDetailsStatusService.getOrderDetailsStatus();
        return ResponseEntity.ok(OrderDetailsStatus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetailsStatusById(@PathVariable int id) {
        Optional<OrderDetailsStatus> OrderDetailsStatus = OrderDetailsStatusService.getOrderDetailsStatusById(id);
        return ResponseEntity.ok(OrderDetailsStatus);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchOrderDetailsStatus(@RequestParam(name = "keyword") String statusName) {
        List<OrderDetailsStatus> OrderDetailsStatus = OrderDetailsStatusService.searchOrderDetailsStatus(statusName);
        return ResponseEntity.ok(OrderDetailsStatus);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createOrderDetailsStatus(@RequestBody OrderDetailsStatus result) {
        OrderDetailsStatus OrderDetailsStatus = OrderDetailsStatusService.createOrderDetailsStatus(result);
        return ResponseEntity.ok(OrderDetailsStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetailsStatus(@PathVariable int id, @RequestBody OrderDetailsStatus result) {
        OrderDetailsStatus OrderDetailsStatus = OrderDetailsStatusService.updateOrderDetailsStatus(id, result);
        return ResponseEntity.ok(OrderDetailsStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetailsStatus(@PathVariable("id") int id) {
        List<OrderDetailsStatus> OrderDetailsStatus = OrderDetailsStatusService.deleteOrderDetailsStatus(id);
        return ResponseEntity.ok(OrderDetailsStatus);
    }

}
