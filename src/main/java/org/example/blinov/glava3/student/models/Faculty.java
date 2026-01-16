package org.example.blinov.glava3.student.models;

public enum Faculty {
    MECH_MATH("Механико-математический"),
    LINGUISTICS("Лингвистика"),
    PHYSIC_MATH("Физико-математический");

    public final String facName;

    Faculty(String facName) {
        this.facName = facName;
    }
}
