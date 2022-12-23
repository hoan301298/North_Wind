package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.PurchaseOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderStatusRepository extends JpaRepository<PurchaseOrderStatus, Integer> {
}