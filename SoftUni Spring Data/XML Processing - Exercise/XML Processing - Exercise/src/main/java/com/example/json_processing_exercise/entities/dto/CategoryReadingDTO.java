package com.example.json_processing_exercise.entities.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryReadingDTO {
    @XmlElement(name = "category")
    List<CategoryDTO> categories;

    public CategoryReadingDTO(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public CategoryReadingDTO() {
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
