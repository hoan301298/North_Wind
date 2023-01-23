package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.OrderDetail;
import fi.vamk.e2000575.northwind.repository.OrderDetailRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository OrderDetailRepository;


    public List<OrderDetail> getOrderDetail() {
        return OrderDetailRepository.findAll();
    }
    public Optional<OrderDetail> getOrderDetailById(int id) {
        return OrderDetailRepository.findById(id);
    }

    public List<OrderDetail> searchOrderDetailByOrderId(int id){
        List<OrderDetail> result = new ArrayList<>();
        for(OrderDetail OrderDetails : getOrderDetail()) {
            if(OrderDetails.getOrder().getId().equals(id))
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
