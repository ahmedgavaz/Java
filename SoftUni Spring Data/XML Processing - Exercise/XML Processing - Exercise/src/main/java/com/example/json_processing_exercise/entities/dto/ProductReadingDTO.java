package com.example.json_processing_exercise.entities.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductReadingDTO {
    @XmlElement(name = "product")
    List<ProductDTO> list;

    public ProductReadingDTO(List<ProductDTO> list) {
        this.list = list;
    }

    public ProductReadingDTO() {
    }

    public List<ProductDTO> getList() {
        return list;
    }

    public void setList(List<ProductDTO> list) {
        this.list = list;
    }
}
