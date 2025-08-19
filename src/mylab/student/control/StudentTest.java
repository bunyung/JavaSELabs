package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
    public static void main(String[] args) {
        try {
            Student s1 = new Student("2025001", "��μ�", "��ǻ�Ͱ���", 3);
            System.out.println(s1);

            s1.setGrade(5); // 5�г� �� ���� �߻�
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
    }
}
