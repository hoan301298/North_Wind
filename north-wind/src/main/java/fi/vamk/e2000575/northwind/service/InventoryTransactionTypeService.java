package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.InventoryTransactionType;
import fi.vamk.e2000575.northwind.repository.InventoryTransactionTypeRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryTransactionTypeService {

    @Autowired
    private InventoryTransactionTypeRepository InventoryTransactionTypeRepository;

    public List<InventoryTransactionType> getInventoryTransactionType() {
        List<InventoryTransactionType> InventoryTransactionType = InventoryTransactionTypeRepository.findAll();
        return InventoryTransactionType;
    }
    public Optional<InventoryTransactionType> getInventoryTransactionTypeById(Byte id) {
        Optional<InventoryTransactionType> InventoryTransactionType = InventoryTransactionTypeRepository.findById(id);
        return InventoryTransactionType;
    }

    public List<InventoryTransactionType> searchInventoryTransactionType(String typename){
        List<InventoryTransactionType> result = new ArrayList<>();
        for(InventoryTransactionType InventoryTransactionTypes : getInventoryTransactionType()) {
            if(InventoryTransactionTypes.getTypeName().contains(typename))
                result.add(InventoryTransactionTypes);
        }
        return result;
    }
    public InventoryTransactionType createInventoryTransactionType(InventoryTransactionType result){
        return InventoryTransactionTypeRepository.save(result);
    }

    public InventoryTransactionType updateInventoryTransactionType(Byte id, @NotNull InventoryTransactionType result){
        if(result.getId() == id) {
            return InventoryTransactionTypeRepository.save(result);
        } else {
            return null;
        }
    }

    public List<InventoryTransactionType> deleteInventoryTransactionType(Byte id) {
        Optional<InventoryTransactionType> result = InventoryTransactionTypeRepository.findById(id);
        if(result.isPresent()) {
            InventoryTransactionTypeRepository.deleteById(id);
            return getInventoryTransactionType();
        } else {
            return null;
        }
    }
}
