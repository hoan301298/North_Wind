package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.OrdersStatus;
import fi.vamk.e2000575.northwind.service.OrdersStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OrdersStatus")
public class OrdersStatusController {

    @Autowired
    private OrdersStatusService OrdersStatusService;

    @GetMapping
    public ResponseEntity<?> getOrdersStatus() {
        List<OrdersStatus> OrdersStatus = OrdersStatusService.getOrdersStatus();
        return ResponseEntity.ok(OrdersStatus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrdersStatusById(@PathVariable Byte id) {
        Optional<OrdersStatus> OrdersStatus = OrdersStatusService.getOrdersStatusById(id);
        return ResponseEntity.ok(OrdersStatus);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchOrdersStatus(@RequestParam(name = "keyword") String company) {
        List<OrdersStatus> OrdersStatus = OrdersStatusService.searchOrdersStatus(company);
        return ResponseEntity.ok(OrdersStatus);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createOrdersStatus(@RequestBody OrdersStatus result) {
        OrdersStatus OrdersStatus = OrdersStatusService.createOrdersStatus(result);
        return ResponseEntity.ok(OrdersStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrdersStatus(@PathVariable int id, @RequestBody OrdersStatus result) {
        OrdersStatus OrdersStatus = OrdersStatusService.updateOrdersStatus(id, result);
        return ResponseEntity.ok(OrdersStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrdersStatus(@PathVariable("id") Byte id) {
        List<OrdersStatus> OrdersStatus = OrdersStatusService.deleteOrdersStatus(id);
        return ResponseEntity.ok(OrdersStatus);
    }

}