package edu.neiu.hw06.models;

public class GoGetter {

    private String firstName;
    private String lastName;
    private String schoolEmail;

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

}
