package fi.vamk.e2000575.northwind.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Employee createdBy;

    @Column(name = "submitted_date")
    private Instant submittedDate;

    @Column(name = "creation_date")
    private Instant creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private PurchaseOrderStatus status;

    @Column(name = "expected_date")
    private Instant expectedDate;

    @NotNull
    @Column(name = "shipping_fee", nullable = false, precision = 19, scale = 4)
    private BigDecimal shippingFee;

    @NotNull
    @Column(name = "taxes", nullable = false, precision = 19, scale = 4)
    private BigDecimal taxes;

    @Column(name = "payment_date")
    private Instant paymentDate;

    @Column(name = "payment_amount", precision = 19, scale = 4)
    private BigDecimal paymentAmount;

    @Size(max = 50)
    @Column(name = "payment_method", length = 50)
    private String paymentMethod;

    @Lob
    @Column(name = "notes")
    private String notes;

    @Column(name = "approved_by")
    private Integer approvedBy;

    @Column(name = "approved_date")
    private Instant approvedDate;

    @Column(name = "submitted_by")
    private Integer submittedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Instant submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public PurchaseOrderStatus getStatus() {
        return status;
    }

    public void setStatus(PurchaseOrderStatus status) {
        this.status = status;
    }

    public Instant getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Instant expectedDate) {
        this.expectedDate = expectedDate;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getTaxes() {
        return taxes;
    }

    public void setTaxes(BigDecimal taxes) {
        this.taxes = taxes;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Instant getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Instant approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Integer getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(Integer submittedBy) {
        this.submittedBy = submittedBy;
    }

}