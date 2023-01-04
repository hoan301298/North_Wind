package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.InventoryTransaction;
import fi.vamk.e2000575.northwind.entity.PurchaseOrder;
import fi.vamk.e2000575.northwind.repository.InventoryTransactionRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryTransactionService {

    @Autowired
    InventoryTransactionRepository InventoryTransactionRepository;

    public List<InventoryTransaction> getInventoryTransaction() {
        List<InventoryTransaction> InventoryTransaction = InventoryTransactionRepository.findAll();
        return InventoryTransaction;
    }
    public Optional<InventoryTransaction> getInventoryTransactionById(int id) {
        Optional<InventoryTransaction> InventoryTransaction = InventoryTransactionRepository.findById(id);
        return InventoryTransaction;
    }

    public List<InventoryTransaction> searchInventoryTransaction(PurchaseOrder purchaseOrder){
        List<InventoryTransaction> result = new ArrayList<>();
        for(InventoryTransaction InventoryTransactions : getInventoryTransaction()) {
            if(InventoryTransactions.getPurchaseOrder().equals(purchaseOrder))
                result.add(InventoryTransactions);
        }
        return result;
    }
    public InventoryTransaction createInventoryTransaction(InventoryTransaction result){
        return InventoryTransactionRepository.save(result);
    }

    public InventoryTransaction updateInventoryTransaction(int id, @NotNull InventoryTransaction result){
        if(result.getId() == id) {
            return InventoryTransactionRepository.save(result);
        } else {
            return null;
        }
    }

    public List<InventoryTransaction> deleteInventoryTransaction(int id) {
        Optional<InventoryTransaction> result = InventoryTransactionRepository.findById(id);
        if (result.isPresent()) {
            InventoryTransactionRepository.deleteById(id);
            return getInventoryTransaction();
        } else {
            return null;
        }
    }
}
