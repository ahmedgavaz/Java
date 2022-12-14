package com.example.json_processing_exercise.entities.dto;

import com.example.json_processing_exercise.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDTO {
    private String firstName;
    private String lastName;
    private Integer age;

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
