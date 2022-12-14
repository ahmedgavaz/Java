package com.example.json_processing_exercise.entities.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class CountOfUserDTO {
    @XmlAttribute
    private Long count;
    @XmlElement(name = "user")
    private List<UsersAndProductsDTO> users = new ArrayList<>();

    public CountOfUserDTO() {
    }

    public CountOfUserDTO(List<UsersAndProductsDTO> list) {
        this.count=Long.valueOf(list.size());
        this.users = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<UsersAndProductsDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UsersAndProductsDTO> users) {
        this.users = users;
    }
}
