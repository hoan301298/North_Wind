package fi.vamk.e2000575.northwind.controller;

import fi.vamk.e2000575.northwind.entity.Product;
import fi.vamk.e2000575.northwind.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @GetMapping
    public ResponseEntity<?> getProduct() {
        List<Product> Product = ProductService.getProduct();
        return ResponseEntity.ok(Product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        Optional<Product> Product = ProductService.getProductById(id);
        return ResponseEntity.ok(Product);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchProductByCode(@RequestParam(name = "ProductCode") String productCode) {
        List<Product> Product = ProductService.searchProductByCode(productCode);
        return ResponseEntity.ok(Product);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchProductByName(@RequestParam(name = "ProductName") String productName) {
        List<Product> Product = ProductService.searchProductByName(productName);
        return ResponseEntity.ok(Product);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<?> createProduct(@RequestBody Product result) {
        Product Product = ProductService.createProduct(result);
        return ResponseEntity.ok(Product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody Product result) {
        Product Product = ProductService.updateProduct(id, result);
        return ResponseEntity.ok(Product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
        List<Product> Product = ProductService.deleteProduct(id);
        return ResponseEntity.ok(Product);
    }

}
