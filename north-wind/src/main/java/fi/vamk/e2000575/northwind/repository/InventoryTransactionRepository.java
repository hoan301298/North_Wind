package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction, Integer> {
}