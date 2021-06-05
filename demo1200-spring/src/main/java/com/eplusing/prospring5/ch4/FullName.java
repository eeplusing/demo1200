package com.eplusing.prospring5.ch4;

/**
 * @author eplusing
 * @date 2020/2/29
 */
public class FullName {
    private String firstName;
    private String lastName;

    public FullName(String s, String s1) {
        this.firstName = s;
        this.lastName = s1;
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

    @Override
    public String toString() {
        return "FullName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
