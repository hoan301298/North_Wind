package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.SalesReport;
import fi.vamk.e2000575.northwind.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SalesReport")
public class SalesReportController {

    @Autowired
    private SalesReportService SalesReportService;

    @GetMapping
    public ResponseEntity<?> getSalesReport() {
        List<SalesReport> SalesReport = SalesReportService.getSalesReport();
        return ResponseEntity.ok(SalesReport);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSalesReportById(@PathVariable String id) {
        SalesReport SalesReport = SalesReportService.searchSalesReportById(id);
        return ResponseEntity.ok(SalesReport);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchSalesReportByTitle(@RequestParam(name = "keyword") String title) {
        List<SalesReport> SalesReport = SalesReportService.searchSalesReportByTitle(title);
        return ResponseEntity.ok(SalesReport);
    }
    @PostMapping
    public @ResponseBody ResponseEntity<?> createSalesReport(@RequestBody SalesReport result) {
        SalesReport SalesReport = SalesReportService.createSalesReport(result);
        return ResponseEntity.ok(SalesReport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSalesReport(@PathVariable String id, @RequestBody SalesReport result) {
        SalesReport SalesReport = SalesReportService.updateSalesReport(id, result);
        return ResponseEntity.ok(SalesReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSalesReport(@PathVariable("id") String id) {
        SalesReport SalesReport = SalesReportService.deleteSalesReport(id);
        return ResponseEntity.ok(SalesReport);
    }

}
