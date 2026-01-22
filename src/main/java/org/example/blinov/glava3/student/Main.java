package org.example.blinov.glava3.student;

import org.example.blinov.glava3.student.database.Data;
import org.example.blinov.glava3.student.models.Faculty;
import org.example.blinov.glava3.student.models.Group;
import org.example.blinov.glava3.student.service.StudentService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Data.init();
        Print print = new Print(new StudentService());
        print.printAllStudentByFaculty(Faculty.LINGUISTICS);
        print.printAllStudentByAllFacultyAndCourse(Faculty.LINGUISTICS, 3);
        print.printAllStudentByBirthdayAfterDate(LocalDate.of(1999, 1, 1));
        print.printAllStudentByGroupName(Group._01243);
    }
}
