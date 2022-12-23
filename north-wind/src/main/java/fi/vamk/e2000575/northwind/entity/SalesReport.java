package fi.vamk.e2000575.northwind.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sales_reports")
public class SalesReport {
    @Id
    @Size(max = 50)
    @Column(name = "group_by", nullable = false, length = 50)
    private String id;

    @Size(max = 50)
    @Column(name = "display", length = 50)
    private String display;

    @Size(max = 50)
    @Column(name = "title", length = 50)
    private String title;

    @Lob
    @Column(name = "filter_row_source")
    private String filterRowSource;

    @NotNull
    @Column(name = "`default`", nullable = false)
    private Boolean defaultField = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilterRowSource() {
        return filterRowSource;
    }

    public void setFilterRowSource(String filterRowSource) {
        this.filterRowSource = filterRowSource;
    }

    public Boolean getDefaultField() {
        return defaultField;
    }

    public void setDefaultField(Boolean defaultField) {
        this.defaultField = defaultField;
    }

}