package com.drifter;

import java.util.Objects;

public class Costumer {
    private Integer id;
    private Integer age;
    String name;
    private String email;

    public Costumer(Integer id, Integer age, String name, String email){
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public Costumer(){

    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setId(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Costumer costumer = (Costumer) o;
        return Objects.equals(id, costumer.id) && Objects.equals(age, costumer.age) && Objects.equals(name, costumer.name) && Objects.equals(email, costumer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, email);
    }
}
