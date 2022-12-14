package com.example.cardealer.domain.dtos;

import javax.persistence.Column;

public class SupplierDTO {
    private String name;

    private Boolean isImporter;

    public SupplierDTO() {
    }

    public SupplierDTO(String name, Boolean isImporter) {
        this.name = name;
        this.isImporter = isImporter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImporter() {
        return isImporter;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }
}
