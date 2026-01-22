package org.example.blinov.glava3.student;

import org.example.blinov.glava3.student.models.Faculty;
import org.example.blinov.glava3.student.models.Group;
import org.example.blinov.glava3.student.models.Student;
import org.example.blinov.glava3.student.service.StudentService;
import org.example.blinov.glava3.student.utils.DateUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Print {

    StudentService studentService;

    public Print(StudentService studentService) {
        this.studentService = studentService;
    }

    public void printAllStudentByFaculty(Faculty faculty) {
        System.out.printf("\nСписок студентов на факультете %s таков:\n%s",
                faculty.facName, replaceStudentsList(studentService.getFindStudents().findAllStudentByFaculty(faculty)));
    }

    public void printAllStudentByAllFacultyAndCourse(Faculty faculty, int course) {
        System.out.printf("\nСписок студентов на %d курсе факультета %s таков:\n%s",
                course, faculty.facName, replaceStudentsList(studentService.getFindStudents().findAllByAllFacultyAndCourse(faculty, course)));
    }

    public void printAllStudentByBirthdayAfterDate(LocalDate localDate) {
        System.out.printf("\nСписок студентов с днем рождения после даты %s таков:\n%s",
                DateUtils.dateByPattern(localDate, DateUtils.DatePattern.DEFAULT), replaceStudentsList(studentService.getFindStudents().findAllByBirthdayAfterDate(localDate)));
    }

    public void printAllStudentByGroupName(Group group) {
        System.out.printf("\nСписок студентов с группы %s таков:\n%s",
                group, replaceStudentsList(studentService.getFindStudents().findAllByGroupName(group)));
    }

    private StringBuilder replaceStudentsList(List<Student> students) {
        AtomicInteger x = new AtomicInteger();
        StringBuilder stringBuilder = new StringBuilder();
        students.forEach(st -> stringBuilder
                .append(x.incrementAndGet())
                .append(". ")
                .append(st.toString()));
        return stringBuilder;
    }
}
