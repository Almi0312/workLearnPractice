package org.example.blinov.glava3.student.service;

import org.example.blinov.glava3.student.database.Data;
import org.example.blinov.glava3.student.models.Faculty;
import org.example.blinov.glava3.student.models.Group;
import org.example.blinov.glava3.student.models.Student;

import java.time.LocalDate;
import java.util.List;

public class StudentService {
    FindStudents findStudents;

    public FindStudents getFindStudents() {
        return new FindStudents();
    }

    public static class FindStudents {

        public List<Student> findAllStudentByFaculty(Faculty faculty) {
            return Data.students.stream()
                    .filter(x -> x.getFaculty().equals(faculty.facName)).toList();
        }

        public List<Student> findAllByAllFacultyAndCourse(Faculty faculty, int course) {
            return Data.students.stream()
                    .filter(x -> x.getFaculty().equals(faculty.facName) && x.getCourse() == course).toList();
        }

        public List<Student> findAllByBirthdayAfterDate(LocalDate localDate) {
            return Data.students.stream()
                    .filter(st -> st.getBirthday().isAfter(localDate)).toList();
        }

        public List<Student> findAllByGroupName(Group group) {
            return Data.students.stream()
                    .filter(x -> x.getGroup().equals(group)).toList();
        }
    }
}
