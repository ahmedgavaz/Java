package com.example.json_processing_exercise.entities.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesWrapper {
    @XmlElement(name = "category")
    private List<CategoryTotalProductsDTO> list;

    public CategoriesWrapper(List<CategoryTotalProductsDTO> list) {
        this.list = list;
    }

    public CategoriesWrapper() {
    }

    public List<CategoryTotalProductsDTO> getList() {
        return list;
    }

    public void setList(List<CategoryTotalProductsDTO> list) {
        this.list = list;
    }
}

