package org.example.blinov.glava4.flowers.dto.flowers;

public enum FlowerColor {
    RED("Красный"),
    WHITE("Белый"),
    YELLOW("Желтый"),
    PINK("Розовый"),
    ORANGE("Оранжевый"),
    PURPLE("Фиолетовый"),
    BLUE("Синий"),
    MULTICOLOR("Разноцветный");

    public final String color;

    FlowerColor(String color) {
        this.color = color;
    }
}
