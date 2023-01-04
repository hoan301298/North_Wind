package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.Shipper;
import fi.vamk.e2000575.northwind.repository.ShipperRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShipperService {
    @Autowired
    private ShipperRepository ShipperRepository;

    public List<Shipper> getShipper() {
        return ShipperRepository.findAll();
    }
    public Optional<Shipper> getShipperById(int id) {
        return ShipperRepository.findById(id);
    }

    public List<Shipper> searchShipper(String company){
        List<Shipper> result = new ArrayList<>();
        for(Shipper Shippers : getShipper()) {
            if(Shippers.getCompany().contains(company))
                result.add(Shippers);
        }
        return result;
    }
    public Shipper createShipper(Shipper result){
        return ShipperRepository.save(result);
    }

    public Shipper updateShipper(int id, @NotNull Shipper result){
        if(result.getId() == id) {
            return ShipperRepository.save(result);
        } else {
            return null;
        }
    }

    public Shipper deleteShipper(int id) {
        Optional<Shipper> result = ShipperRepository.findById(id);
        if(result.isPresent()) {
            ShipperRepository.deleteById(id);
        }
        return null;
    }
}
