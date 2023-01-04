package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.OrdersTaxStatus;
import fi.vamk.e2000575.northwind.repository.OrdersTaxStatusRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrdersTaxStatusService {
    @Autowired
    private OrdersTaxStatusRepository OrdersTaxStatusRepository;

    public List<OrdersTaxStatus> getOrdersTaxStatus() {
        return OrdersTaxStatusRepository.findAll();
    }
    public Optional<OrdersTaxStatus> getOrdersTaxStatusById(Byte id) {
        return OrdersTaxStatusRepository.findById(id);
    }

    public List<OrdersTaxStatus> searchOrdersTaxStatus(String company){
        List<OrdersTaxStatus> result = new ArrayList<>();
        for(OrdersTaxStatus ordersTaxStatus : getOrdersTaxStatus()) {
            if(ordersTaxStatus.getTaxStatusName().contains(company))
                result.add(ordersTaxStatus);
        }
        return result;
    }
    public OrdersTaxStatus createOrdersTaxStatus(OrdersTaxStatus result){
        return OrdersTaxStatusRepository.save(result);
    }

    public OrdersTaxStatus updateOrdersTaxStatus(Byte id, @NotNull OrdersTaxStatus result){
        if(result.getId() == id) {
            return OrdersTaxStatusRepository.save(result);
        } else {
            return null;
        }
    }

    public List<OrdersTaxStatus> deleteOrdersTaxStatus(Byte id) {
        Optional<OrdersTaxStatus> result = OrdersTaxStatusRepository.findById(id);
        if(result.isPresent()) {
            OrdersTaxStatusRepository.deleteById(id);
            return getOrdersTaxStatus();
        } else {
            return null;
        }
    }
}
