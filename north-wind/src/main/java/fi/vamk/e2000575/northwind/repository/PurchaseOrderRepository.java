package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {
}