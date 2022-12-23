package fi.vamk.e2000575.northwind.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "order_date")
    private Instant orderDate;

    @Column(name = "shipped_date")
    private Instant shippedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

    @Size(max = 50)
    @Column(name = "ship_name", length = 50)
    private String shipName;

    @Lob
    @Column(name = "ship_address")
    private String shipAddress;

    @Size(max = 50)
    @Column(name = "ship_city", length = 50)
    private String shipCity;

    @Size(max = 50)
    @Column(name = "ship_state_province", length = 50)
    private String shipStateProvince;

    @Size(max = 50)
    @Column(name = "ship_zip_postal_code", length = 50)
    private String shipZipPostalCode;

    @Size(max = 50)
    @Column(name = "ship_country_region", length = 50)
    private String shipCountryRegion;

    @Column(name = "shipping_fee", precision = 19, scale = 4)
    private BigDecimal shippingFee;

    @Column(name = "taxes", precision = 19, scale = 4)
    private BigDecimal taxes;

    @Size(max = 50)
    @Column(name = "payment_type", length = 50)
    private String paymentType;

    @Column(name = "paid_date")
    private Instant paidDate;

    @Lob
    @Column(name = "notes")
    private String notes;

    @Column(name = "tax_rate")
    private Double taxRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_status_id")
    private OrdersTaxStatus taxStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private OrdersStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }

    public Instant getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Instant shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipStateProvince() {
        return shipStateProvince;
    }

    public void setShipStateProvince(String shipStateProvince) {
        this.shipStateProvince = shipStateProvince;
    }

    public String getShipZipPostalCode() {
        return shipZipPostalCode;
    }

    public void setShipZipPostalCode(String shipZipPostalCode) {
        this.shipZipPostalCode = shipZipPostalCode;
    }

    public String getShipCountryRegion() {
        return shipCountryRegion;
    }

    public void setShipCountryRegion(String shipCountryRegion) {
        this.shipCountryRegion = shipCountryRegion;
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Instant getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Instant paidDate) {
        this.paidDate = paidDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public OrdersTaxStatus getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(OrdersTaxStatus taxStatus) {
        this.taxStatus = taxStatus;
    }

    public OrdersStatus getStatus() {
        return status;
    }

    public void setStatus(OrdersStatus status) {
        this.status = status;
    }

}