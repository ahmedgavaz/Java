package com.example.json_processing_exercise.entities.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class CountAndProductsDTO {
    @XmlAttribute
    private Long count;
    @XmlElement(name = "product")
    private List<ProductDTO> products;

    public CountAndProductsDTO() {
    }

    public CountAndProductsDTO(List<ProductDTO> products) {
        this.count= Long.valueOf(products.size());
        this.products = products;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
