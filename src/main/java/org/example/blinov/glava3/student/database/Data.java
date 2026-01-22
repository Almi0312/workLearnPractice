package org.example.blinov.glava3.student.database;

import org.example.blinov.glava3.student.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Student> students = new ArrayList<>();
    private static List<LocalDate> birthdays = new ArrayList<>();
    private static List<Address> addresses = new ArrayList<>();
    private static List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public static void init() {
        students = initStudent();
    }

    private static List<Student> initStudent() {
        birthdays = initBirthday();
        addresses = initAddress();
        phoneNumbers = initPhoneNumber();
        students.add(new Student("Минаев", "Александр", "Дмитриевич", birthdays.get(0), addresses.get(0), phoneNumbers.get(0), Faculty.LINGUISTICS, Group._01222, 3));
        students.add(new Student("Казеева", "Асель", "Александровна", birthdays.get(1), addresses.get(1), phoneNumbers.get(1), Faculty.LINGUISTICS, Group._01243, 3));
        students.add(new Student("Барышников", "Семен", "Алексеевич", birthdays.get(2), addresses.get(2), phoneNumbers.get(2), Faculty.LINGUISTICS, Group._01243, 2));
        students.add(new Student("Бояршинова", "Светлана", "Батьковна", birthdays.get(3), addresses.get(3), phoneNumbers.get(3), Faculty.LINGUISTICS, Group._01222, 1));
        return students;
    }

    private static List<LocalDate> initBirthday() {
        birthdays.add(LocalDate.of(1997, 12, 3));
        birthdays.add(LocalDate.of(2000, 4, 6));
        birthdays.add(LocalDate.of(2000, 5, 29));
        birthdays.add(LocalDate.of(1997, 1, 1));
        return birthdays;
    }

    private static List<Address> initAddress() {
        addresses.add(Address.createLocale("Ленина", "10", "2"));
        addresses.add(Address.createLocale("Тутуева", "11", "4"));
        addresses.add(Address.createLocale("Тельмана", "121/4", "5"));
        addresses.add(Address.createLocale("Ленина", "10", "2"));
        return addresses;
    }

    private static List<PhoneNumber> initPhoneNumber() {
        phoneNumbers.add(PhoneNumber.of("+7987", "1234567"));
        phoneNumbers.add(PhoneNumber.of("+7999", "3451232"));
        phoneNumbers.add(PhoneNumber.of("+7927", "5678912"));
        phoneNumbers.add(PhoneNumber.of("+8889", "9993322"));
        return phoneNumbers;
    }
}
