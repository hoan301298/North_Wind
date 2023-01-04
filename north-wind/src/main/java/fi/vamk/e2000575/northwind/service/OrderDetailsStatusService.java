package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.OrderDetailsStatus;
import fi.vamk.e2000575.northwind.repository.OrderDetailsStatusRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDetailsStatusService {
    @Autowired
    private OrderDetailsStatusRepository OrderDetailsStatusRepository;

    public List<OrderDetailsStatus> getOrderDetailsStatus() {
        return OrderDetailsStatusRepository.findAll();
    }

    public Optional<OrderDetailsStatus> getOrderDetailsStatusById(int id) {
        return OrderDetailsStatusRepository.findById(id);
    }

    public List<OrderDetailsStatus> searchOrderDetailsStatus(String statusName){
        List<OrderDetailsStatus> result = new ArrayList<>();
        for(OrderDetailsStatus OrderDetailsStatus : getOrderDetailsStatus()) {
            if(OrderDetailsStatus.getStatusName().contains(statusName))
                result.add(OrderDetailsStatus);
        }
        return result;
    }

    public OrderDetailsStatus createOrderDetailsStatus(OrderDetailsStatus result){
        return OrderDetailsStatusRepository.save(result);
    }

    public OrderDetailsStatus updateOrderDetailsStatus(int id, @NotNull OrderDetailsStatus result){
        if(result.getId() == id) {
            return OrderDetailsStatusRepository.save(result);
        } else {
            return null;
        }
    }

    public List<OrderDetailsStatus> deleteOrderDetailsStatus(int id) {
        Optional<OrderDetailsStatus> result = OrderDetailsStatusRepository.findById(id);
        if(result.isPresent()) {
            OrderDetailsStatusRepository.deleteById(id);
            return getOrderDetailsStatus();
        } else {
            return null;
        }
    }
}
