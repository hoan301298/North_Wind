package fi.vamk.e2000575.northwind.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "orders_tax_status")
public class OrdersTaxStatus {
    @Id
    @Column(name = "id", nullable = false)
    private Byte id;

    @Size(max = 50)
    @NotNull
    @Column(name = "tax_status_name", nullable = false, length = 50)
    private String taxStatusName;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getTaxStatusName() {
        return taxStatusName;
    }

    public void setTaxStatusName(String taxStatusName) {
        this.taxStatusName = taxStatusName;
    }

}