package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.Product;
import fi.vamk.e2000575.northwind.repository.ProductRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> getProduct() {
        List<Product> Product = ProductRepository.findAll();
        return Product;
    }
    public Optional<Product> getProductById(int id) {
        Optional<Product> Product = ProductRepository.findById(id);
        return Product;
    }

    public List<Product> searchProductByCode(String productCode){
        List<Product> result = new ArrayList<>();
        for(Product Products : getProduct()) {
            if(Products.getProductCode().contains(productCode))
                result.add(Products);
        }
        return result;
    }
    public List<Product> searchProductByName(String productName){
        List<Product> result = new ArrayList<>();
        for(Product Products : getProduct()) {
            if(Products.getProductName().contains(productName))
                result.add(Products);
        }
        return result;
    }
    public Product createProduct(Product result){
        return ProductRepository.save(result);
    }

    public Product updateProduct(int id, @NotNull Product result){
        if(result.getId() == id) {
            return ProductRepository.save(result);
        } else {
            return null;
        }
    }

    public List<Product> deleteProduct(int id) {
        Optional<Product> result = ProductRepository.findById(id);
        if(result.isPresent()) {
            ProductRepository.deleteById(id);
            return getProduct();
        } else {
            return null;
        }
    }
}
