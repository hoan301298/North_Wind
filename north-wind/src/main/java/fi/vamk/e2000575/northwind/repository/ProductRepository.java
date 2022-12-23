package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}