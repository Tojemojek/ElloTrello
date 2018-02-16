package pl.kostrowski.finalny.restclients.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

public class MyUserDto {

    private String id;

    private String name;

    private String surname;

    private String password;

    private String region;

    private String role;

    public MyUserDto(String id, String name, String surname, String password, String region, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.region = region;
        this.role = role;
    }

    public MyUserDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
