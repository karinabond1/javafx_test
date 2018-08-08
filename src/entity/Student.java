package entity;

import java.time.LocalDate;

public class Student extends User {

    public Student(String login, String password, String emeil) throws CreateUserException {
        super(login, password, emeil);
    }

    public void changeProfile() {

    }

    public void takeOfSchedule(LocalDate date) {

    }

}
