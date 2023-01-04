package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.Customer;
import fi.vamk.e2000575.northwind.entity.Employee;
import fi.vamk.e2000575.northwind.entity.Order;
import fi.vamk.e2000575.northwind.repository.CustomerRepository;
import fi.vamk.e2000575.northwind.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderService OrderService;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<?> getOrder() {
        List<Order> Order = OrderService.getOrder();
        return ResponseEntity.ok(Order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable int id) {
        Optional<Order> Order = OrderService.getOrderById(id);
        return ResponseEntity.ok(Order);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchOrderEmployeeId(@RequestParam(name = "Employee") Employee employee) {
        List<Order> Order = OrderService.searchOrderByEmployeeID(employee);
        return ResponseEntity.ok(Order);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchOrderCustomerId(@RequestParam(name = "Customer") Customer customer) {
        List<Order> Order = OrderService.searchOrderByCustomerID(customer);
        return ResponseEntity.ok(Order);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createOrder(@RequestBody Order result) {
        Order Order = OrderService.createOrder(result);
        return ResponseEntity.ok(Order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable int id, @RequestBody Order result) {
        Order Order = OrderService.updateOrder(id, result);
        return ResponseEntity.ok(Order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") int id) {
        List<Order> Order = OrderService.deleteOrder(id);
        return ResponseEntity.ok(Order);
    }

}