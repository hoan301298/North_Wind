package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.Privilege;
import fi.vamk.e2000575.northwind.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Privilege")
public class PrivilegeController {

    @Autowired
    private PrivilegeService PrivilegeService;

    @GetMapping
    public ResponseEntity<?> getPrivilege() {
        List<Privilege> Privilege = PrivilegeService.getPrivilege();
        return ResponseEntity.ok(Privilege);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPrivilegeById(@PathVariable int id) {
        Optional<Privilege> Privilege = PrivilegeService.getPrivilegeById(id);
        return ResponseEntity.ok(Privilege);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPrivilege(@RequestParam(name = "keyword") String company) {
        List<Privilege> Privilege = PrivilegeService.searchPrivilege(company);
        return ResponseEntity.ok(Privilege);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createPrivilege(@RequestBody Privilege result) {
        Privilege Privilege = PrivilegeService.createPrivilege(result);
        return ResponseEntity.ok(Privilege);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePrivilege(@PathVariable int id, @RequestBody Privilege result) {
        Privilege Privilege = PrivilegeService.updatePrivilege(id, result);
        return ResponseEntity.ok(Privilege);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrivilege(@PathVariable("id") int id) {
        List<Privilege> Privilege = PrivilegeService.deletePrivilege(id);
        return ResponseEntity.ok(Privilege);
    }

}