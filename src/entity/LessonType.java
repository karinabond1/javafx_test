package entity;

public enum LessonType {
    Lection(0), Practic(5), Seminar(10), Exam(15), Zalic(20);
    int codTip;

    LessonType(int i) {
        this.codTip = i;
    }
}
