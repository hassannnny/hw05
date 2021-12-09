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
    private String task;


    @NotBlank
    private String subject;


    public Tasks() {
        this.task = "";
        this.subject = "";
    }

    public Tasks(String task, String subject) {
        this.task = task;
        this.subject = subject;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
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
        return this.task + " " + this.subject;
    }
}
