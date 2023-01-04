package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.PurchaseOrder;
import fi.vamk.e2000575.northwind.entity.Supplier;
import fi.vamk.e2000575.northwind.repository.PurchaseOrderRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PurchaseOrderService {
    @Autowired
    private PurchaseOrderRepository PurchaseOrderRepository;

    public List<PurchaseOrder> getPurchaseOrder() {
        return PurchaseOrderRepository.findAll();
    }
    public Optional<PurchaseOrder> getPurchaseOrderById(int id) {
        return PurchaseOrderRepository.findById(id);
    }

    public List<PurchaseOrder> searchPurchaseOrder(Supplier supplier){
        List<PurchaseOrder> result = new ArrayList<>();
        for(PurchaseOrder PurchaseOrders : getPurchaseOrder()) {
            if(PurchaseOrders.getSupplier().equals(supplier))
                result.add(PurchaseOrders);
        }
        return result;
    }
    public PurchaseOrder createPurchaseOrder(PurchaseOrder result){
        return PurchaseOrderRepository.save(result);
    }

    public PurchaseOrder updatePurchaseOrder(int id, @NotNull PurchaseOrder result){
        if(result.getId() == id) {
            return PurchaseOrderRepository.save(result);
        } else {
            return null;
        }
    }

    public List<PurchaseOrder> deletePurchaseOrder(int id) {
        Optional<PurchaseOrder> result = PurchaseOrderRepository.findById(id);
        if(result.isPresent()) {
            PurchaseOrderRepository.deleteById(id);
            return getPurchaseOrder();
        } else {
            return null;
        }
    }
}
