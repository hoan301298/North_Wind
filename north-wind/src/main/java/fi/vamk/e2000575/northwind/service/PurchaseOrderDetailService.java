package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.PurchaseOrder;
import fi.vamk.e2000575.northwind.entity.PurchaseOrderDetail;
import fi.vamk.e2000575.northwind.repository.PurchaseOrderDetailRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PurchaseOrderDetailService {
    @Autowired
    private PurchaseOrderDetailRepository PurchaseOrderDetailRepository;

    public List<PurchaseOrderDetail> getPurchaseOrderDetail() {
        return PurchaseOrderDetailRepository.findAll();
    }
    public Optional<PurchaseOrderDetail> getPurchaseOrderDetailById(int id) {
        return PurchaseOrderDetailRepository.findById(id);
    }

    public List<PurchaseOrderDetail> searchPurchaseOrderDetail(PurchaseOrder purchaseOrder){
        List<PurchaseOrderDetail> result = new ArrayList<>();
        for(PurchaseOrderDetail PurchaseOrderDetails : getPurchaseOrderDetail()) {
            if(PurchaseOrderDetails.getPurchaseOrder().equals(purchaseOrder))
                result.add(PurchaseOrderDetails);
        }
        return result;
    }
    public PurchaseOrderDetail createPurchaseOrderDetail(PurchaseOrderDetail result){
        return PurchaseOrderDetailRepository.save(result);
    }

    public PurchaseOrderDetail updatePurchaseOrderDetail(int id, @NotNull PurchaseOrderDetail result){
        if(result.getId() == id) {
            return PurchaseOrderDetailRepository.save(result);
        } else {
            return null;
        }
    }

    public List<PurchaseOrderDetail> deletePurchaseOrderDetail(int id) {
        Optional<PurchaseOrderDetail> result = PurchaseOrderDetailRepository.findById(id);
        if(result.isPresent()) {
            PurchaseOrderDetailRepository.deleteById(id);
            return getPurchaseOrderDetail();
        } else {
            return null;
        }
    }
}
