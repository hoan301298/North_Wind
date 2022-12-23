package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.OrderDetailsStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsStatusRepository extends JpaRepository<OrderDetailsStatus, Integer> {
}