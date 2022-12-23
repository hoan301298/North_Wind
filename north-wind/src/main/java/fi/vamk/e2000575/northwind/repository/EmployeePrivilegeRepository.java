package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.EmployeePrivilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePrivilegeRepository extends JpaRepository<EmployeePrivilege, Integer> {
}