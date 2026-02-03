package org.example.blinov.glava4.flowers.client.accessories_impl;

import org.example.blinov.glava4.flowers.client.AccessoryOperations;
import org.example.blinov.glava4.flowers.dto.accessories.Accessory;

import java.util.List;

public class AccessoryOperationsImpl implements AccessoryOperations {

    List<Accessory> accessories;

    public AccessoryOperationsImpl(List<Accessory> accessories) {
        this.accessories = accessories;
    }

}
