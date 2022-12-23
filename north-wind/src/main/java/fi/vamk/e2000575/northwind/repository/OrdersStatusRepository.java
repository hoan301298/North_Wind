package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.OrdersStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersStatusRepository extends JpaRepository<OrdersStatus, Byte> {
}