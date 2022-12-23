package fi.vamk.e2000575.northwind.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "purchase_order_details")
public class PurchaseOrderDetail {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchase_order_id", nullable = false)
    private PurchaseOrder purchaseOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    @Column(name = "quantity", nullable = false, precision = 18, scale = 4)
    private BigDecimal quantity;

    @NotNull
    @Column(name = "unit_cost", nullable = false, precision = 19, scale = 4)
    private BigDecimal unitCost;

    @Column(name = "date_received")
    private Instant dateReceived;

    @NotNull
    @Column(name = "posted_to_inventory", nullable = false)
    private Boolean postedToInventory = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    private InventoryTransaction inventory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
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

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public Instant getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Instant dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Boolean getPostedToInventory() {
        return postedToInventory;
    }

    public void setPostedToInventory(Boolean postedToInventory) {
        this.postedToInventory = postedToInventory;
    }

    public InventoryTransaction getInventory() {
        return inventory;
    }

    public void setInventory(InventoryTransaction inventory) {
        this.inventory = inventory;
    }

}