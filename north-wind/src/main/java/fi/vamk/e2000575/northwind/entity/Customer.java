package fi.vamk.e2000575.northwind.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "company", length = 50)
    private String company;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "email_address", length = 50)
    private String emailAddress;

    @Column(name = "job_title", length = 50)
    private String jobTitle;

    @Column(name = "business_phone", length = 25)
    private String businessPhone;

    @Column(name = "home_phone", length = 25)
    private String homePhone;

    @Column(name = "mobile_phone", length = 25)
    private String mobilePhone;

    @Column(name = "fax_number", length = 25)
    private String faxNumber;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "state_province", length = 50)
    private String stateProvince;

    @Column(name = "zip_postal_code", length = 15)
    private String zipPostalCode;

    @Column(name = "country_region", length = 50)
    private String countryRegion;

    @Lob
    @Column(name = "web_page")
    private String webPage;

    @Lob
    @Column(name = "notes")
    private String notes;

    @Column(name = "attachments")
    private byte[] attachments;


}