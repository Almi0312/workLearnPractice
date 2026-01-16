package org.example.blinov.glava3.student.models;

import static java.lang.String.format;

public class Address {
    Country country;
    String city;
    String street;
    String numberHouse;
    String numberApart;

    public static Address create(Country country, String city, String street, String numberHouse, String numberApart) {
        return new Address(country, city, street, numberHouse, numberApart);
    }

    public static Address createRu(String city, String street, String numberHouse, String numberApart) {
        return new Address(Country.RUSSIA, city, street, numberHouse, numberApart);
    }

    public static Address createLocale(String street, String numberHouse, String numberApart) {
        return new Address(Country.RUSSIA, "Саратов", street, numberHouse, numberApart);
    }

    private Address(Country country, String city, String street, String numberHouse, String numberApart) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.numberHouse = numberHouse;
        this.numberApart = numberApart;
    }

    public String getNumberApart() {
        return numberApart;
    }

    public void setNumberApart(String numberApart) {
        this.numberApart = numberApart;
    }

    public String getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return format("%s, г. %s, ул. %s, д. %s, кв. %s",
                country.country, city, street, numberHouse, numberApart);
    }
}
