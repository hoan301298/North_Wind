package fi.vamk.e2000575.northwind.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "strings")
public class Strings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "string_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "string_data")
    private String stringData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

}