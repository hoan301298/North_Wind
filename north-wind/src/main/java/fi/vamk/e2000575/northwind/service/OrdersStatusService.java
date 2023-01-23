package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.OrdersStatus;
import fi.vamk.e2000575.northwind.repository.OrdersStatusRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class OrdersStatusService {
    @Autowired
    private OrdersStatusRepository OrdersStatusRepository;

    public List<OrdersStatus> getOrdersStatus() {
        return OrdersStatusRepository.findAll();
    }
    public Optional<OrdersStatus> getOrdersStatusById(Byte id) {
        return OrdersStatusRepository.findById(id);
    }

    public List<OrdersStatus> searchOrdersStatus(String company){
        List<OrdersStatus> result = new ArrayList<>();
        for(OrdersStatus ordersStatus : getOrdersStatus()) {
            if(ordersStatus.getStatusName().contains(company))
                result.add(ordersStatus);
        }
        return result;
    }
    public OrdersStatus createOrdersStatus(OrdersStatus result){
        return OrdersStatusRepository.save(result);
    }

    public OrdersStatus updateOrdersStatus(int id, @NotNull OrdersStatus result){
        if(result.getId() == id) {
            return OrdersStatusRepository.save(result);
        } else {
            return null;
        }
    }

    public List<OrdersStatus> deleteOrdersStatus(Byte id) {
        Optional<OrdersStatus> result = OrdersStatusRepository.findById(id);
        if(result.isPresent()) {
            OrdersStatusRepository.deleteById(id);
            return getOrdersStatus();
        } else {
            return null;
        }
    }
}
