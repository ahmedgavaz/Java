package com.example.json_processing_exercise.entities.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserReadingDTO {
    @XmlElement(name = "user")
    private List<UserDTO> users;

    public UserReadingDTO(List<UserDTO> users) {
        this.users = users;
    }

    public UserReadingDTO() {
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
