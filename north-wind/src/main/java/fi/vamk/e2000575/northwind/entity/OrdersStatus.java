package fi.vamk.e2000575.northwind.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "orders_status")
public class OrdersStatus {
    @Id
    @Column(name = "id", nullable = false)
    private Byte id;

    @Size(max = 50)
    @NotNull
    @Column(name = "status_name", nullable = false, length = 50)
    private String statusName;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

}