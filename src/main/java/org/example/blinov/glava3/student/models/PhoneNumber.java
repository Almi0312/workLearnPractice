package org.example.blinov.glava3.student.models;

public class PhoneNumber {
    private String code;
    private String number;

    public static PhoneNumber of(String code, String number) {
        return new PhoneNumber(code, number);
    }

    private PhoneNumber(String code, String number) {
        setCode(code);
        setNumber(number);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number.length() != 7) {
            throw new NumberFormatException("Номер без кода должен состоять из 7 цифр");
        }
        this.number = number;
    }

    @Override
    public String toString() {
        return code + number;
    }
}
