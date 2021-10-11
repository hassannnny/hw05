package edu.neiu.hw06.models;

public class Go_Getter {

    private static String firstName;
    private static String lastName;
    private static String schoolEmail;

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getSchoolEmail() {
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
