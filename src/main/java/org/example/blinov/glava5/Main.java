package org.example.blinov.glava5;

import org.example.blinov.glava5.data.Data;

public class Main {

    static void main(String[] args) {
        Data.init();
        ShopDTO shopDTO = new ShopDTO(new ShopDTO.Address());
        ShopDTO.Department department = shopDTO.new Department();
    }


}
