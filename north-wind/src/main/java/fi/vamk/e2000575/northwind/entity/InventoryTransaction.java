package fi.vamk.e2000575.northwind.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "inventory_transactions")
public class InventoryTransaction {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_type", nullable = false)
    private InventoryTransactionType transactionType;

    @Column(name = "transaction_created_date")
    private Instant transactionCreatedDate;

    @Column(name = "transaction_modified_date")
    private Instant transactionModifiedDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_order_id")
    private Order customerOrder;

    @Size(max = 255)
    @Column(name = "comments")
    private String comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InventoryTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(InventoryTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Instant getTransactionCreatedDate() {
        return transactionCreatedDate;
    }

    public void setTransactionCreatedDate(Instant transactionCreatedDate) {
        this.transactionCreatedDate = transactionCreatedDate;
    }

    public Instant getTransactionModifiedDate() {
        return transactionModifiedDate;
    }

    public void setTransactionModifiedDate(Instant transactionModifiedDate) {
        this.transactionModifiedDate = transactionModifiedDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Order getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(Order customerOrder) {
        this.customerOrder = customerOrder;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}