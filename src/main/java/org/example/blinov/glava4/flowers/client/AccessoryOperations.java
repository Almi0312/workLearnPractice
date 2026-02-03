package org.example.blinov.glava4.flowers.client;

import org.example.blinov.glava4.flowers.client.accessories_impl.AccessoryOperationsImpl;
import org.example.blinov.glava4.flowers.dto.accessories.Accessory;

import java.util.List;

public interface AccessoryOperations {

    static AccessoryOperations of(List<Accessory> accessories) {
        return new AccessoryOperationsImpl(accessories);
    }
}
