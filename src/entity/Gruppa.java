package entity;

import java.util.*;

public class Gruppa extends Department {
    private Set<Student> spisGrupAll = new TreeSet<>();
    private Map<Disciplina, List<List<Student>>> podGrup = new TreeMap<>();
    Teacher kurator;

    void changePositionInListGrup(Student st1, int position) {

    }

}
