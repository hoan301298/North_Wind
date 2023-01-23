package fi.vamk.e2000575.northwind.service;

import fi.vamk.e2000575.northwind.entity.SalesReport;
import fi.vamk.e2000575.northwind.repository.SalesReportRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SalesReportService {
    @Autowired
    private SalesReportRepository SalesReportRepository;

    public List<SalesReport> getSalesReport() {
        return SalesReportRepository.findAll();
    }
    public SalesReport searchSalesReportById(String id){
        SalesReport s = null;
        for(SalesReport salesReport : getSalesReport()) {
            if(salesReport.getId().contains(id))
                s = salesReport;
        }
        return s;
    }

    public List<SalesReport> searchSalesReportByTitle(String title){
        List<SalesReport> result = new ArrayList<>();
        for(SalesReport SalesReports : getSalesReport()) {
            if(SalesReports.getTitle().contains(title))
                result.add(SalesReports);
        }
        return result;
    }
    public SalesReport createSalesReport(SalesReport result){
        return SalesReportRepository.save(result);
    }

    public SalesReport updateSalesReport(String id, @NotNull SalesReport result){
        if(result.getId().equals(id)) {
            return SalesReportRepository.save(result);
        } else {
            return null;
        }
    }

    public SalesReport deleteSalesReport(String id) {
        SalesReportRepository.delete(searchSalesReportById(id));
        return null;
    }
}
