package org.example.blinov.glava3.student.models;

public enum Group {
    _01222("01222", Faculty.LINGUISTICS),
    _01243("01243", Faculty.LINGUISTICS),
    _02313("02313", Faculty.MECH_MATH);

    public String name;
    public Faculty faculty;

    Group(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return name;
    }
}
