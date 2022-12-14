package com.example.json_processing_exercise.entities.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductWrapper {
    @XmlElement(name = "user")
    List<UserWithSoldProductDTO> list;

    public UserWithSoldProductWrapper(List<UserWithSoldProductDTO> list) {
        this.list = list;
    }

    public UserWithSoldProductWrapper() {
    }

    public List<UserWithSoldProductDTO> getList() {
        return list;
    }

    public void setList(List<UserWithSoldProductDTO> list) {
        this.list = list;
    }
}
