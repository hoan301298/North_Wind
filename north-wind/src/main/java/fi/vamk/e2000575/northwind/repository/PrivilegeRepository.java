package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
}