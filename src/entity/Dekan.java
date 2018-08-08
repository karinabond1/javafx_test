package entity;

import java.util.List;

public class Dekan extends Teacher {
    public Dekan(String login, String password, String emeil) throws CreateUserException {
        super(login, password, emeil);
    }

    public void viewStudentUspevaemost(List<Student> st1) {

    }

    public void viewDolgiForStudent(Student st1) {

    }
}
