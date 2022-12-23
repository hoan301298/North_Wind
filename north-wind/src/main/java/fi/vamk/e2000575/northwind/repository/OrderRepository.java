package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}