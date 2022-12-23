package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.Employee;
import fi.vamk.e2000575.northwind.repository.EmployeeRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository EmployeeRepository;

    public List<Employee> getEmployee() {
        List<Employee> employee = EmployeeRepository.findAll();
        return employee;
    }
    public Optional<Employee> getEmployeeById(int id) {
        Optional<Employee> employee = EmployeeRepository.findById(id);
        return employee;
    }

    public List<Employee> searchEmployee(String company){
        List<Employee> result = new ArrayList<>();
        for(Employee employees : getEmployee()) {
            if(employees.getCompany().contains(company))
                result.add(employees);
        }
        return result;
    }
    public Employee createEmployee(Employee result){
        return EmployeeRepository.save(result);
    }

    public Employee updateEmployee(int id, @NotNull Employee result){
        if(result.getId() == id) {
            return EmployeeRepository.save(result);
        } else {
            return null;
        }
    }

    public List<Employee> deleteEmployee(int id) {
        Optional<Employee> result = EmployeeRepository.findById(id);
        if(result.isPresent()) {
            EmployeeRepository.deleteById(id);
            return getEmployee();
        } else {
            return null;
        }

    }
}
