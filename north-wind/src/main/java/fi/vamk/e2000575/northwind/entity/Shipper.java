package fi.vamk.e2000575.northwind.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "shippers")
public class Shipper {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "company", length = 50)
    private Strings company;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private Strings lastName;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private Strings firstName;

    @Size(max = 50)
    @Column(name = "email_address", length = 50)
    private Strings emailAddress;

    @Size(max = 50)
    @Column(name = "job_title", length = 50)
    private Strings jobTitle;

    @Size(max = 25)
    @Column(name = "business_phone", length = 25)
    private Strings businessPhone;

    @Size(max = 25)
    @Column(name = "home_phone", length = 25)
    private Strings homePhone;

    @Size(max = 25)
    @Column(name = "mobile_phone", length = 25)
    private Strings mobilePhone;

    @Size(max = 25)
    @Column(name = "fax_number", length = 25)
    private Strings faxNumber;

    @Lob
    @Column(name = "address")
    private Strings address;

    @Size(max = 50)
    @Column(name = "city", length = 50)
    private Strings city;

    @Size(max = 50)
    @Column(name = "state_province", length = 50)
    private Strings stateProvince;

    @Size(max = 15)
    @Column(name = "zip_postal_code", length = 15)
    private Strings zipPostalCode;

    @Size(max = 50)
    @Column(name = "country_region", length = 50)
    private Strings countryRegion;

    @Lob
    @Column(name = "web_page")
    private Strings webPage;

    @Lob
    @Column(name = "notes")
    private Strings notes;

    @Column(name = "attachments")
    private byte[] attachments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Strings getCompany() {
        return company;
    }

    public void setCompany(Strings company) {
        this.company = company;
    }

    public Strings getLastName() {
        return lastName;
    }

    public void setLastName(Strings lastName) {
        this.lastName = lastName;
    }

    public Strings getFirstName() {
        return firstName;
    }

    public void setFirstName(Strings firstName) {
        this.firstName = firstName;
    }

    public Strings getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(Strings emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Strings getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(Strings jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Strings getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(Strings businessPhone) {
        this.businessPhone = businessPhone;
    }

    public Strings getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(Strings homePhone) {
        this.homePhone = homePhone;
    }

    public Strings getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Strings mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Strings getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(Strings faxNumber) {
        this.faxNumber = faxNumber;
    }

    public Strings getAddress() {
        return address;
    }

    public void setAddress(Strings address) {
        this.address = address;
    }

    public Strings getCity() {
        return city;
    }

    public void setCity(Strings city) {
        this.city = city;
    }

    public Strings getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(Strings stateProvince) {
        this.stateProvince = stateProvince;
    }

    public Strings getZipPostalCode() {
        return zipPostalCode;
    }

    public void setZipPostalCode(Strings zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
    }

    public Strings getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(Strings countryRegion) {
        this.countryRegion = countryRegion;
    }

    public Strings getWebPage() {
        return webPage;
    }

    public void setWebPage(Strings webPage) {
        this.webPage = webPage;
    }

    public Strings getNotes() {
        return notes;
    }

    public void setNotes(Strings notes) {
        this.notes = notes;
    }

    public byte[] getAttachments() {
        return attachments;
    }

    public void setAttachments(byte[] attachments) {
        this.attachments = attachments;
    }

}