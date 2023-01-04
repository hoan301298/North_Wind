package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.Shipper;
import fi.vamk.e2000575.northwind.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Shipper")
public class ShipperController {

    @Autowired
    private ShipperService ShipperService;

    @GetMapping
    public ResponseEntity<?> getShipper() {
        List<Shipper> Shipper = ShipperService.getShipper();
        return ResponseEntity.ok(Shipper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShipperById(@PathVariable int id) {
        Optional<Shipper> Shipper = ShipperService.getShipperById(id);
        return ResponseEntity.ok(Shipper);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchShipper(@RequestParam(name = "keyword") String company) {
        List<Shipper> Shipper = ShipperService.searchShipper(company);
        return ResponseEntity.ok(Shipper);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createShipper(@RequestBody Shipper result) {
        Shipper Shipper = ShipperService.createShipper(result);
        return ResponseEntity.ok(Shipper);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateShipper(@PathVariable int id, @RequestBody Shipper result) {
        Shipper Shipper = ShipperService.updateShipper(id, result);
        return ResponseEntity.ok(Shipper);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShipper(@PathVariable("id") int id) {
        Shipper Shipper = ShipperService.deleteShipper(id);
        return ResponseEntity.ok(Shipper);
    }

}
