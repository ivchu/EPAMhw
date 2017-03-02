package hw.epam.marks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MM8 on 02.03.2017.
 */
public class StudentsGroupCreator {
    private List<Student> allStudents = new ArrayList<>();

    public void addStudent(Student student) {
        allStudents.add(student);
    }

    public List<Student> getStudentsParticipateDiscipline(Disciplines discipline) {
        List<Student> studentsInDiscipline = new ArrayList<>();
        for (Student student : allStudents) {
            if (student.getParticapatingDisciplines().containsKey(discipline)){
                studentsInDiscipline.add(student);
            }
        }
        return studentsInDiscipline;
    }
}
