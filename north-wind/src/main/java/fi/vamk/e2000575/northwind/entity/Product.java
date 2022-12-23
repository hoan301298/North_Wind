package fi.vamk.e2000575.northwind.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "supplier_ids")
    private String supplierIds;

    @Size(max = 25)
    @Column(name = "product_code", length = 25)
    private String productCode;

    @Size(max = 50)
    @Column(name = "product_name", length = 50)
    private String productName;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "standard_cost", precision = 19, scale = 4)
    private BigDecimal standardCost;

    @NotNull
    @Column(name = "list_price", nullable = false, precision = 19, scale = 4)
    private BigDecimal listPrice;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @Column(name = "target_level")
    private Integer targetLevel;

    @Size(max = 50)
    @Column(name = "quantity_per_unit", length = 50)
    private String quantityPerUnit;

    @NotNull
    @Column(name = "discontinued", nullable = false)
    private Boolean discontinued = false;

    @Column(name = "minimum_reorder_quantity")
    private Integer minimumReorderQuantity;

    @Size(max = 50)
    @Column(name = "category", length = 50)
    private String category;

    @Column(name = "attachments")
    private byte[] attachments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplierIds() {
        return supplierIds;
    }

    public void setSupplierIds(String supplierIds) {
        this.supplierIds = supplierIds;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(BigDecimal standardCost) {
        this.standardCost = standardCost;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Integer getTargetLevel() {
        return targetLevel;
    }

    public void setTargetLevel(Integer targetLevel) {
        this.targetLevel = targetLevel;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

    public Integer getMinimumReorderQuantity() {
        return minimumReorderQuantity;
    }

    public void setMinimumReorderQuantity(Integer minimumReorderQuantity) {
        this.minimumReorderQuantity = minimumReorderQuantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public byte[] getAttachments() {
        return attachments;
    }

    public void setAttachments(byte[] attachments) {
        this.attachments = attachments;
    }

}