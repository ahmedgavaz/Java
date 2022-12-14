package com.example.json_processing_exercise.entities.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsInRangeWrapper {
    @XmlElement(name = "product")
    private List<ProductInRangeDTO> list;

    public ProductsInRangeWrapper(List<ProductInRangeDTO> list) {
        this.list = list;
    }

    public ProductsInRangeWrapper() {
    }

    public List<ProductInRangeDTO> getList() {
        return list;
    }

    public void setList(List<ProductInRangeDTO> list) {
        this.list = list;
    }
}
