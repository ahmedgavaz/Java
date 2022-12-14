package com.example.json_processing_exercise.entities.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSoldWrapper {
    @XmlElement(name = "product")
    List<ProductSoldDTO> list;

    public ProductSoldWrapper(List<ProductSoldDTO> list) {
        this.list = list;
    }

    public ProductSoldWrapper() {
    }

    public List<ProductSoldDTO> getList() {
        return list;
    }

    public void setList(List<ProductSoldDTO> list) {
        this.list = list;
    }
}
