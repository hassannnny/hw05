package edu.neiu.hw06.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank()
    @Column(unique = true)
    private String singleTask;


    @NotBlank
    private String subject;


    public Tasks() {
        this.singleTask = " ";
        this.subject = " ";
    }

    public Tasks(String task, String subject) {
        this.singleTask = singleTask;
        this.subject = subject;
    }

    public String getSingleTask() {
        return singleTask;
    }

    public void setSingleTask(String singleTask) {
        this.singleTask = singleTask;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getId() {
        return this.id;
    }
    public String toString() {
        return this.singleTask + " " + this.subject;
    }
}
