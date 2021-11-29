package edu.neiu.hw06.models;

import org.apache.tomcat.jni.Local;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class GoGetter {

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


    private LocalDateTime created;
    private LocalDateTime modified;


    public GoGetter() {
        this.firstName = "";
        this.lastName = "";
        this.schoolEmail = "";
    }

    public GoGetter(String firstName, String lastName, String schoolEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolEmail = schoolEmail;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
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

    public long getId() {
        return id;
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
