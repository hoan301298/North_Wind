package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.Customer;
import fi.vamk.e2000575.northwind.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getCustomer() {
        List<Customer> customer = customerService.getCustomer();
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchCustomer(@RequestParam(name = "company") String company) {
        List<Customer> customer = customerService.searchCustomer(company);
        return ResponseEntity.ok(customer);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createCustomer(@RequestBody Customer result) {
        Customer customer = customerService.createCustomer(result);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable int id, @RequestBody Customer result) {
        Customer customer = customerService.updateCustomer(id, result);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") int id) {
        List<Customer> customer = customerService.deleteCustomer(id);
        return ResponseEntity.ok(customer);
    }

}
