package fi.vamk.e2000575.northwind.repository;

import fi.vamk.e2000575.northwind.entity.SalesReport;
import fi.vamk.e2000575.northwind.entity.Strings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesReportRepository extends JpaRepository<SalesReport, Strings> {
}