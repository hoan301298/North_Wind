package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.Supplier;
import fi.vamk.e2000575.northwind.repository.SupplierRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class SupplierService {
    @Autowired
    private SupplierRepository SupplierRepository;

    public List<Supplier> getSupplier() {
        return SupplierRepository.findAll();
    }
    public Optional<Supplier> getSupplierById(int id) {
        return SupplierRepository.findById(id);
    }

    public List<Supplier> searchSupplier(String company){
        List<Supplier> result = new ArrayList<>();
        for(Supplier Suppliers : getSupplier()) {
            if(Suppliers.getCompany().contains(company))
                result.add(Suppliers);
        }
        return result;
    }
    public Supplier createSupplier(Supplier result){
        return SupplierRepository.save(result);
    }

    public Supplier updateSupplier(int id, @NotNull Supplier result){
        if(result.getId() == id) {
            return SupplierRepository.save(result);
        } else {
            return null;
        }
    }

    public Supplier deleteSupplier(int id) {
        Optional<Supplier> result = SupplierRepository.findById(id);
        if(result.isPresent())
            SupplierRepository.deleteById(id);

        return null;
    }
}
