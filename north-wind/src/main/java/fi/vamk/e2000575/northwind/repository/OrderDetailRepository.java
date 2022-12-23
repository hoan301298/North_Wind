package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}