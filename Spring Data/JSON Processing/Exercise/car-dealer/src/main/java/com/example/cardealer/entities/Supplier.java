package com.example.cardealer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity{

    private String name;

    @Column(name = "is_importer")
    Boolean isImporter;

    @OneToMany(mappedBy = "supplier")
    private Set<Part> parts;

    public Supplier() {
    }

    public Supplier(String name, Boolean usesImportedCars) {
        this.name = name;
        this.isImporter = usesImportedCars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsImporter() {
        return isImporter;
    }

    public void setIsImporter(Boolean isImporter) {
        this.isImporter = isImporter;
    }

    public Set<Part> getParts() {
        return Collections.unmodifiableSet(parts);
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
