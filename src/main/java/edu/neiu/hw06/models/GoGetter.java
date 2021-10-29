package edu.neiu.hw06.models;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class GoGetter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String firstName;
    private String lastName;
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
