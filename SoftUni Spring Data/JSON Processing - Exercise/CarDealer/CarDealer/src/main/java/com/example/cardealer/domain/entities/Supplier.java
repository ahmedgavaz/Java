package com.example.cardealer.domain.entities;

import com.example.cardealer.domain.entities.Part;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private Boolean isImporter;
    @OneToMany(targetEntity = Part.class, mappedBy = "supplier")
    @Fetch(FetchMode.JOIN)
    private Set<Part> parts=new HashSet<>();

    public Supplier() {
    }

    public Boolean getImporter() {
        return isImporter;
    }

    public Supplier(String name, Boolean isImporter) {
        this.name = name;
        this.isImporter = isImporter;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }

    public Supplier(long id, String name, Set<Part> parts) {
        this.id = id;
        this.name = name;
        this.parts = parts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
