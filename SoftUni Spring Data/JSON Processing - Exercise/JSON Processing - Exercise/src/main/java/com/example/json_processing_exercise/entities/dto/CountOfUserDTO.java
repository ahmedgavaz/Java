package com.example.json_processing_exercise.entities.dto;

import java.util.List;

public class CountOfUserDTO {
    private Long count;
    private List<UsersAndProductsDTO> users;

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
