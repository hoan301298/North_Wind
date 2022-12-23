package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.OrdersTaxStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersTaxStatusRepository extends JpaRepository<OrdersTaxStatus, Byte> {
}