package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.Customer;
import fi.vamk.e2000575.northwind.entity.Employee;
import fi.vamk.e2000575.northwind.entity.Order;
import fi.vamk.e2000575.northwind.repository.OrderRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {
    @Autowired
    private OrderRepository OrderRepository;

    public List<Order> getOrder() {
        List<Order> Order = OrderRepository.findAll();
        return Order;
    }
    public Optional<Order> getOrderById(int id) {
        Optional<Order> Order = OrderRepository.findById(id);
        return Order;
    }

    public List<Order> searchOrderByCustomerID(Customer customer){
        List<Order> result = new ArrayList<>();
        for(Order Orders : getOrder()) {
            if(Orders.getCustomer().equals(customer))
                result.add(Orders);
        }
        return result;
    }
    public List<Order> searchOrderByEmployeeID(Employee employee) {
        List<Order> result = new ArrayList<>();
        for (Order Orders : getOrder()) {
            if (Orders.getEmployee().equals(employee))
                result.add(Orders);
        }
        return result;
    }
    public Order createOrder(Order result){
        return OrderRepository.save(result);
    }

    public Order updateOrder(int id, @NotNull Order result){
        if(result.getId() == id) {
            return OrderRepository.save(result);
        } else {
            return null;
        }
    }

    public List<Order> deleteOrder(int id) {
        Optional<Order> result = OrderRepository.findById(id);
        if(result.isPresent()) {
            OrderRepository.deleteById(id);
            return getOrder();
        } else {
            return null;
        }
    }
}
