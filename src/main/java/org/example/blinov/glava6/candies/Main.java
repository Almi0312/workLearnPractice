package org.example.blinov.glava6.candies;

import org.example.blinov.glava6.candies.entity.Brand;
import org.example.blinov.glava6.candies.entity.Chocolate;
import org.example.blinov.glava6.candies.interfaces.*;
import org.example.blinov.glava6.candies.proxy.CandyManageHandler;
import org.example.blinov.glava6.candies.service.CandyManager;

import java.lang.reflect.Proxy;
import java.util.Collections;

/**
 * Разработать проект управления процессами на основе создания и
 * реализации интерфейсов для следующих предметных областей:
 * Конфеты. Возможности:
 * выпустить партию конфет;
 * получить информацию по продукции определенного производителя;
 * добавить и редактировать информацию о продукции;
 * добавить новые ингредиенты;
 * создать новый тип конфет;
 * снять с производства определенный тип конфет.
 * Добавить специализированные методы для Конфеты, Шоколад, Леденец, Ирис.
 */
public class Main {

    public static void main(String[] args) {
        CandyOperations candyManager = (CandyOperations) Proxy.newProxyInstance(
                CandyManager.class.getClassLoader(),
                new Class<?>[]{CandyOperations.class},
                new CandyManageHandler(new CandyManager())
        );
        Discontinue discontinue = candyManager;
        Editable editable = candyManager;
        Findable findable = candyManager;
        IngredientManage ingredientManage = candyManager;
        Producible producible = candyManager;
        TypeCreatable typeCreatable = candyManager;
        editable.addChocolateCandy("Choco John", Brand.FERRERO, 200, Collections.emptyList(), 200, "40%");
        Chocolate chocolate = (Chocolate) findable.findCandyByNameAndBrend("Choco John", Brand.FERRERO).get();
    }
}
