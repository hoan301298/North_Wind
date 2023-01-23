package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}