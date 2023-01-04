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
    public EmployeePrivilege getEmployeeById(int id) {
        EmployeePrivilege result = null;
        for(EmployeePrivilege employeeId : getEmployeePrivilege()) {
            if(employeeId.getEmployeeId().equals(id)) {
                result = employeeId;
                break;      
            }
        }
        return result;
    }

    public EmployeePrivilege getPrivilegeById(int id){
        EmployeePrivilege result = null;
        for(EmployeePrivilege privilegeId : getEmployeePrivilege()){
            if(privilegeId.getPrivilegeId().equals(id))
                result = privilegeId;
        }
        return result;
    }
    public EmployeePrivilege createEmployeePrivilege(EmployeePrivilege result){
        return EmployeePrivilegeRepository.save(result);
    }
    public EmployeePrivilege updateEmployeePrivilege(int id1, int id2 , EmployeePrivilege employeePrivilege){
        EmployeePrivilege result = employeePrivilege;
        for(EmployeePrivilege employeePrivileges : getEmployeePrivilege()){
            if(employeePrivileges.getEmployeeId().equals(id1) && employeePrivileges.getPrivilegeId().equals(id2))
                employeePrivileges = result;
        }
        return result;
    }
    public List<EmployeePrivilege> deleteEmployeePrivilege(EmployeePrivilege result){
        EmployeePrivilegeRepository.delete(result);
        return getEmployeePrivilege();
    }
}
