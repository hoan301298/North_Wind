package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.Employee;
import fi.vamk.e2000575.northwind.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService EmployeeService;

    @GetMapping
    public ResponseEntity<?> getEmployee() {
        List<Employee> Employee = EmployeeService.getEmployee();
        return ResponseEntity.ok(Employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
        Optional<Employee> Employee = EmployeeService.getEmployeeById(id);
        return ResponseEntity.ok(Employee);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchEmployee(@RequestParam(name = "keyword") String company) {
        List<Employee> Employee = EmployeeService.searchEmployee(company);
        return ResponseEntity.ok(Employee);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createEmployee(@RequestBody Employee result) {
        Employee Employee = EmployeeService.createEmployee(result);
        return ResponseEntity.ok(Employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee result) {
        Employee Employee = EmployeeService.updateEmployee(id, result);
        return ResponseEntity.ok(Employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
        List<Employee> Employee = EmployeeService.deleteEmployee(id);
        return ResponseEntity.ok(Employee);
    }
}
