package entity;

import java.time.LocalDate;

public class Teacher extends User{


    public Teacher(String login, String password, String emeil) throws CreateUserException {
        super(login, password, emeil);
    }

    void estimate(Student st1, LocalDate date, Disciplina disc, int bal) {

    }

    void sverkaGurnala(Lesson para) {

    }
}
