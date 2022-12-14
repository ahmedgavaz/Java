package com.example.json_processing_exercise.entities.dto;

import com.example.json_processing_exercise.entities.Product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDTO {
    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute
    private Integer age;

    public UserDTO(String firstName, String lastName, Integer age, List<Product> count) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.count = count;
    }

    private List<Product> count;

    public UserDTO() {
    }

    public List<Product> getCount() {
        return count;
    }

    public void setCount(List<Product> count) {
        this.count = count;
    }

    public UserDTO(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   /* public CountWithUserDTO toCountWithUserDto(){
        List<CountWithUserDTO> list = new ArrayList<>()
        for (int i = 0; i < count.size(); i++) {
            list.add()
        }
        return new CountWithUserDTO(count);
    }*/
}
