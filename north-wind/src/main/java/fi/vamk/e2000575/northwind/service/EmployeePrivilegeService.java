package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.EmployeePrivilege;
import fi.vamk.e2000575.northwind.repository.EmployeePrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePrivilegeService {
    @Autowired
    private EmployeePrivilegeRepository EmployeePrivilegeRepository;

    public List<EmployeePrivilege> getEmployeePrivilege() {
        return EmployeePrivilegeRepository.findAll();
    }
    public EmployeePrivilege getEmployeePrivilegeById(int id) {
        EmployeePrivilege result = null;
        for(EmployeePrivilege employeePrivilege : getEmployeePrivilege()) {
            if(employeePrivilege.getId().equals(id)) {
                result = employeePrivilege;
                break;      
            }
        }
        return result;
    }

    public EmployeePrivilege createEmployeePrivilege(EmployeePrivilege result){
        return EmployeePrivilegeRepository.save(result);
    }
    public EmployeePrivilege updateEmployeePrivilege(int id1, int id2 , EmployeePrivilege employeePrivilege){
        for(EmployeePrivilege employeePrivileges : getEmployeePrivilege()){
            if(employeePrivileges.getEmployee().getId().equals(id1) && employeePrivileges.getPrivilege().getId().equals(id2))
                employeePrivileges = employeePrivilege;
        }
        return employeePrivilege;
    }
    public List<EmployeePrivilege> deleteEmployeePrivilege(EmployeePrivilege result){
        EmployeePrivilegeRepository.delete(result);
        return getEmployeePrivilege();
    }
}
