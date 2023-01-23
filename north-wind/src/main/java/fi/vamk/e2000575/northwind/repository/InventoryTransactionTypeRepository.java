package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.InventoryTransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryTransactionTypeRepository extends JpaRepository<InventoryTransactionType, Byte> {
}