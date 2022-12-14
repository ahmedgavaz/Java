package com.example.json_processing_exercise.entities.dto;

public class UsersAndProductsDTO {
    private String firstName;
    private String lastName;
    private Integer age;

    private CountAndProductsDTO count;

    public UsersAndProductsDTO(String firstName, String lastName, Integer age, CountAndProductsDTO count) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.count = count;
    }

    public CountAndProductsDTO getCount() {
        return count;
    }

    public void setCount(CountAndProductsDTO count) {
        this.count = count;
    }

    public UsersAndProductsDTO() {
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

  /*  public CountWithUserDTO toCountWithUserDto(){
        return new CountWithUserDTO(count);
    }*/
}
