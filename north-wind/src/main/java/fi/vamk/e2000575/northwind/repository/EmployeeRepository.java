package fi.vamk.e2000575.northwind.repository;
import fi.vamk.e2000575.northwind.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
