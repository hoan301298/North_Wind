package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.EmployeePrivilege;
import fi.vamk.e2000575.northwind.repository.EmployeePrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePrivilegeService {
    @Autowired
    private EmployeePrivilegeRepository EmployeePrivilegeRepository;
    @Autowired

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

    public Optional<EmployeePrivilege> getPrivilegeById(int id){
        Optional<EmployeePrivilege> result = Optional.empty();
        for(EmployeePrivilege privilegeId : getEmployeePrivilege()){
            if(privilegeId.getPrivilegeId().equals(id))
                result = Optional.of(privilegeId);
        }
        return result;
    }
    public EmployeePrivilege createEmployeePrivilege(EmployeePrivilege result){
        return EmployeePrivilegeRepository.save(result);
    }
}
