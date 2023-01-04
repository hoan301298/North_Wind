package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.Customer;
import fi.vamk.e2000575.northwind.repository.CustomerRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomer() {
        List<Customer> customer = customerRepository.findAll();
        return customer;
    }
    public Optional<Customer> getCustomerById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }

    public List<Customer> searchCustomer(String company){
        List<Customer> result = new ArrayList<>();
        for(Customer customers : getCustomer()) {
            if(customers.getCompany().contains(company))
                result.add(customers);
        }
        return result;
    }
    public Customer createCustomer(Customer result){
        return customerRepository.save(result);
    }

    public Customer updateCustomer(int id, @NotNull Customer result){
        if(result.getId() == id) {
            return customerRepository.save(result);
        } else {
            return null;
        }
    }

    public List<Customer> deleteCustomer(int id) {
        Optional<Customer> result = customerRepository.findById(id);
        if(result.isPresent()) {
            customerRepository.deleteById(id);
            return getCustomer();
        } else {
            return null;
        }
    }
}
