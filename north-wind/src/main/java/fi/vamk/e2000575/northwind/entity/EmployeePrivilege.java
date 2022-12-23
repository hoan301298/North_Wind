package fi.vamk.e2000575.northwind.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "employee_privileges")
@NoArgsConstructor
public class EmployeePrivilege {

    @Id
    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Id
    @Column(name = "privilege_id", nullable = false)
    private Integer privilegeId;
    @MapsId("employeeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @MapsId("privilegeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "privilege_id", nullable = false)
    private Privilege privilege;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

}