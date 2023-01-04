package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.EmployeePrivilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EmployeePrivilege")
public class EmployeePrivilegeController {
    @Autowired
    private fi.vamk.e2000575.northwind.service.EmployeePrivilegeService EmployeePrivilegeService;

    @GetMapping
    public ResponseEntity<?> getEmployeePrivilege() {
        List<EmployeePrivilege> EmployeePrivilege = EmployeePrivilegeService.getEmployeePrivilege();
        return ResponseEntity.ok(EmployeePrivilege);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@RequestParam(name = "Employee") @PathVariable int id) {
        EmployeePrivilege EmployeePrivilege = EmployeePrivilegeService.getEmployeeById(id);
        return ResponseEntity.ok(EmployeePrivilege);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPrivilegeById(@RequestParam(name = "Privilege") @PathVariable int id) {
        EmployeePrivilege EmployeePrivilege = EmployeePrivilegeService.getPrivilegeById(id);
        return ResponseEntity.ok(EmployeePrivilege);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<?> createEmployeePrivilege(@RequestBody EmployeePrivilege result) {
        EmployeePrivilege EmployeePrivilege = EmployeePrivilegeService.createEmployeePrivilege(result);
        return ResponseEntity.ok(EmployeePrivilege);
    }

    @PutMapping("/{id}")
    public void updateEmployeePrivilege(@RequestParam("Employee") @PathVariable int id1, @RequestParam("Privilege") @PathVariable int id2, @RequestBody EmployeePrivilege result) {
        EmployeePrivilege employeePrivilege = EmployeePrivilegeService.updateEmployeePrivilege(id1, id2, result);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeePrivilege(@RequestParam("delete") @RequestBody EmployeePrivilege result) {
        List<EmployeePrivilege> employeePrivilege = EmployeePrivilegeService.deleteEmployeePrivilege(result);
    }
}
