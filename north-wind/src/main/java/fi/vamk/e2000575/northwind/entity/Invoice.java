package fi.vamk.e2000575.northwind.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "invoice_date")
    private Instant invoiceDate;

    @Column(name = "due_date")
    private Instant dueDate;

    @Column(name = "tax", precision = 19, scale = 4)
    private BigDecimal tax;

    @Column(name = "shipping", precision = 19, scale = 4)
    private BigDecimal shipping;

    @Column(name = "amount_due", precision = 19, scale = 4)
    private BigDecimal amountDue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Instant getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Instant invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getShipping() {
        return shipping;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    public BigDecimal getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }

}