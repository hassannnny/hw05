package edu.neiu.hw06.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank(message = "First name should be more than 2 characters")
    private String firstName;
    @NotBlank(message = "Last name should be more than 2 characters")
    private String lastName;

    @NotBlank(message = "Please enter an email address")
    @Email(message = "Must be a valid email address")
    @Column(unique = true)
    private String schoolEmail;

    @NotBlank(message = "Please create a password")
    @Column(unique = true)
    private String RegPassword;

    private LocalDateTime created;
    private LocalDateTime modified;


    public Registration() {
        this.firstName = "";
        this.lastName = "";
        this.schoolEmail = "";
    }

    public Registration(String firstName, String lastName, String schoolEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolEmail = schoolEmail;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getRegPassword() {
        return RegPassword;
    }

    public void setRegPassword(String regPassword) {
        RegPassword = regPassword;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @PrePersist
    public void onCreate() {
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate() {
        this.setModified(LocalDateTime.now());
    }

    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
