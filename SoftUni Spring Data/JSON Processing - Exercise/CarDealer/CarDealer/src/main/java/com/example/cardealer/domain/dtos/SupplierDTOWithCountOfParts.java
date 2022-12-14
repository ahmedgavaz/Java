package com.example.cardealer.domain.dtos;

public class SupplierDTOWithCountOfParts {
    private long id;
    private String name;
    private Integer partsCount;

    public SupplierDTOWithCountOfParts() {
    }

    public SupplierDTOWithCountOfParts(long id, String name, int count) {
        this.id = id;
        this.name = name;
        this.partsCount = count;
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

    public Integer getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(Integer partsCount) {
        this.partsCount = partsCount;
    }
}
