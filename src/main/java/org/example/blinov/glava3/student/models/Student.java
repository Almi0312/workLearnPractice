package org.example.blinov.glava3.student.models;

import org.example.blinov.glava3.student.utils.DateUtils;

import javax.annotation.Nonnull;
import java.time.LocalDate;

import static java.lang.String.format;

public class Student {
    private static long id = 0;

    private String firstName;
    private String name;
    private String lastName;
    private LocalDate birthday;
    private Address address;
    private PhoneNumber phone;
    private Faculty faculty;
    private int course;
    // Формируется путем прибавления к названию группы текущего курса студента
    private Group group;

    public Student(@Nonnull String firstName,
                   @Nonnull String name,
                   @Nonnull String lastName,
                   @Nonnull LocalDate birthday,
                   @Nonnull Address address,
                   @Nonnull PhoneNumber phone,
                   @Nonnull Faculty faculty,
                   @Nonnull Group group,
                   int course) {
        id = id + 1;
        this.firstName = firstName;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    //    GETTERS
    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhone() {
        return phone;
    }

    public String getFaculty() {
        return faculty.facName;
    }

    public int getCourse() {
        return course;
    }

    public Group getGroup() {
        return group;
    }

//    SETTERS

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(PhoneNumber phone) {
        this.phone = phone;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setCourse(int course) {
        if (course > 5) {
            throw new RuntimeException(format("Вы указали %d курс. Курс не может быть больше 5", course));
        }
        this.course = course;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return format("Студент - %s %s %s, год рождения - %s, тел. %s;\nАдрес - %s;\nФакультет: %s, курс: %s, группа: %s\n",
                firstName,
                name,
                lastName,
                DateUtils.dateByPattern(birthday, DateUtils.DatePattern.DEFAULT),
                phone,
                address,
                faculty.facName,
                course,
                group);
    }
}
