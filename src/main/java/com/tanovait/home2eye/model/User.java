package com.tanovait.home2eye.model;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "isAgency")
    private Boolean isAgency;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String secondName) {
        this.lastName = secondName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAgency() {
        return isAgency;
    }

    public void setAgency(Boolean agency) {
        isAgency = agency;
    }
}
