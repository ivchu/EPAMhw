package hw.epam.marks;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created by MM8 on 02.03.2017.
 */
public class StudentsGroupCreatorTest extends TestCase {
    public void testGetStudentsParticipateDisciplineWorksFine() {
        Mark intMark = new IntMark(4);
        Mark doubleMark = new DoubleMark(4.5);
        Student q = new Student(Disciplines.MATH, doubleMark);
        Student w = new Student(Disciplines.MATH, doubleMark);
        Student e = new Student(Disciplines.MATH, doubleMark);
        Student r = new Student(Disciplines.MATH, doubleMark);
        Student t = new Student(Disciplines.MATH, doubleMark);
        Student y = new Student(Disciplines.PHILOSOPHY, intMark);
        Student u = new Student(Disciplines.PHILOSOPHY, intMark);

        StudentsGroupCreator studentsGroupCreator = new StudentsGroupCreator();
        studentsGroupCreator.addStudent(q);
        studentsGroupCreator.addStudent(w);
        studentsGroupCreator.addStudent(e);
        studentsGroupCreator.addStudent(r);
        studentsGroupCreator.addStudent(t);
        studentsGroupCreator.addStudent(y);
        studentsGroupCreator.addStudent(u);
        List studentsOnMath = studentsGroupCreator.getStudentsParticipateDiscipline(Disciplines.MATH);
        List studentsOnPhylosophy = studentsGroupCreator.getStudentsParticipateDiscipline(Disciplines.PHILOSOPHY);
        assertEquals(studentsGroupCreator.getOverallAmountOfStudents(),
                studentsOnMath.size() + studentsOnPhylosophy.size());
    }
}