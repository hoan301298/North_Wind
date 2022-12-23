package fi.vamk.e2000575.northwind.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    @Column(name = "quantity", nullable = false, precision = 18, scale = 4)
    private BigDecimal quantity;

    @Column(name = "unit_price", precision = 19, scale = 4)
    private BigDecimal unitPrice;

    @NotNull
    @Column(name = "discount", nullable = false)
    private Double discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private OrderDetailsStatus status;

    @Column(name = "date_allocated")
    private Instant dateAllocated;

    @Column(name = "purchase_order_id")
    private Integer purchaseOrderId;

    @Column(name = "inventory_id")
    private Integer inventoryId;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public OrderDetailsStatus getStatus() {
        return status;
    }

    public void setStatus(OrderDetailsStatus status) {
        this.status = status;
    }

    public Instant getDateAllocated() {
        return dateAllocated;
    }

    public void setDateAllocated(Instant dateAllocated) {
        this.dateAllocated = dateAllocated;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

}