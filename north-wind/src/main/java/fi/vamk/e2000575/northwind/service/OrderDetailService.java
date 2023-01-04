package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.Order;
import fi.vamk.e2000575.northwind.entity.OrderDetail;
import fi.vamk.e2000575.northwind.repository.OrderDetailRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDetailService {
    @Autowired
    private OrderDetailRepository OrderDetailRepository;
    @Autowired
    private Order Order;

    public List<OrderDetail> getOrderDetail() {
        return OrderDetailRepository.findAll();
    }
    public Optional<OrderDetail> getOrderDetailById(int id) {
        return OrderDetailRepository.findById(id);
    }

    public List<OrderDetail> searchOrderDetail(Order order){
        List<OrderDetail> result = new ArrayList<>();
        for(OrderDetail OrderDetails : getOrderDetail()) {
            if(OrderDetails.getOrder().equals(order))
                result.add(OrderDetails);
        }
        return result;
    }
    public OrderDetail createOrderDetail(OrderDetail result){
        return OrderDetailRepository.save(result);
    }

    public OrderDetail updateOrderDetail(int id, @NotNull OrderDetail result){
        if(result.getId() == id) {
            return OrderDetailRepository.save(result);
        } else {
            return null;
        }
    }

    public List<OrderDetail> deleteOrderDetail(int id) {
        Optional<OrderDetail> result = OrderDetailRepository.findById(id);
        if(result.isPresent()) {
            OrderDetailRepository.deleteById(id);
            return getOrderDetail();
        } else {
            return null;
        }
    }
}
