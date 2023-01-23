package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.PurchaseOrderStatus;
import fi.vamk.e2000575.northwind.repository.PurchaseOrderStatusRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PurchaseOrderStatusService {
    @Autowired
    private PurchaseOrderStatusRepository PurchaseOrderStatusRepository;

    public List<PurchaseOrderStatus> getPurchaseOrderStatus() {
        List<PurchaseOrderStatus> PurchaseOrderStatus = PurchaseOrderStatusRepository.findAll();
        return PurchaseOrderStatus;
    }
    public Optional<PurchaseOrderStatus> getPurchaseOrderStatusById(int id) {
        Optional<PurchaseOrderStatus> PurchaseOrderStatus = PurchaseOrderStatusRepository.findById(id);
        return PurchaseOrderStatus;
    }

    public List<PurchaseOrderStatus> searchPurchaseOrderStatus(String status){
        List<PurchaseOrderStatus> result = new ArrayList<>();
        for(PurchaseOrderStatus PurchaseOrderStatuss : getPurchaseOrderStatus()) {
            if(PurchaseOrderStatuss.getStatus().contains(status))
                result.add(PurchaseOrderStatuss);
        }
        return result;
    }
    public PurchaseOrderStatus createPurchaseOrderStatus(PurchaseOrderStatus result){
        return PurchaseOrderStatusRepository.save(result);
    }

    public PurchaseOrderStatus updatePurchaseOrderStatus(int id, @NotNull PurchaseOrderStatus result){
        if(result.getId() == id) {
            return PurchaseOrderStatusRepository.save(result);
        } else {
            return null;
        }
    }

    public List<PurchaseOrderStatus> deletePurchaseOrderStatus(int id) {
        Optional<PurchaseOrderStatus> result = PurchaseOrderStatusRepository.findById(id);
        if(result.isPresent()) {
            PurchaseOrderStatusRepository.deleteById(id);
            return getPurchaseOrderStatus();
        } else {
            return null;
        }
    }
}
