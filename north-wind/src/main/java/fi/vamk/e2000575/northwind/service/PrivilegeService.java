package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.Privilege;
import fi.vamk.e2000575.northwind.repository.PrivilegeRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PrivilegeService {
    @Autowired
    private PrivilegeRepository PrivilegeRepository;

    public List<Privilege> getPrivilege() {
        return PrivilegeRepository.findAll();
    }
    public Optional<Privilege> getPrivilegeById(int id) {
        return PrivilegeRepository.findById(id);
    }

    public List<Privilege> searchPrivilege(String company){
        List<Privilege> result = new ArrayList<>();
        for(Privilege Privileges : getPrivilege()) {
            if(Privileges.getPrivilegeName().contains(company))
                result.add(Privileges);
        }
        return result;
    }
    public Privilege createPrivilege(Privilege result){
        return PrivilegeRepository.save(result);
    }

    public Privilege updatePrivilege(int id, @NotNull Privilege result){
        if(result.getId() == id) {
            return PrivilegeRepository.save(result);
        } else {
            return null;
        }
    }

    public List<Privilege> deletePrivilege(int id) {
        Optional<Privilege> result = PrivilegeRepository.findById(id);
        if(result.isPresent()) {
            PrivilegeRepository.deleteById(id);
            return getPrivilege();
        } else {
            return null;
        }
    }
}
