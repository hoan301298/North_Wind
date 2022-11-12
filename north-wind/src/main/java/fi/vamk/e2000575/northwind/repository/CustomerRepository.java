package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}