package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.OrderDetail;
import fi.vamk.e2000575.northwind.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OrderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService OrderDetailService;

    @GetMapping
    public ResponseEntity<?> getOrderDetail() {
        List<OrderDetail> OrderDetail = OrderDetailService.getOrderDetail();
        return ResponseEntity.ok(OrderDetail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetailById(@PathVariable int id) {
        Optional<OrderDetail> OrderDetail = OrderDetailService.getOrderDetailById(id);
        return ResponseEntity.ok(OrderDetail);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchOrderDetail(@RequestParam(name = "keyword") @PathVariable int id) {
        List<OrderDetail> OrderDetail = OrderDetailService.searchOrderDetailByOrderId(id);
        return ResponseEntity.ok(OrderDetail);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createOrderDetail(@RequestBody OrderDetail result) {
        OrderDetail OrderDetail = OrderDetailService.createOrderDetail(result);
        return ResponseEntity.ok(OrderDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(@PathVariable int id, @RequestBody OrderDetail result) {
        OrderDetail OrderDetail = OrderDetailService.updateOrderDetail(id, result);
        return ResponseEntity.ok(OrderDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable("id") int id) {
        List<OrderDetail> OrderDetail = OrderDetailService.deleteOrderDetail(id);
        return ResponseEntity.ok(OrderDetail);
    }

}
