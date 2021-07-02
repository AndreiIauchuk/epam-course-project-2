/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.validator;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.characteristic.Material;

public class BallValidator {

    private static final double MIN_WEIGHT = 1;
    private static final double MAX_WEIGHT = 10;
    private static final byte MIN_SIZE = 1;
    private static final byte MAX_SIZE = 5;

    public boolean validateWeight(double weight) {
        return (weight >= MIN_WEIGHT && weight <= MAX_WEIGHT);
    }

    public boolean validateColor(Color color) {
        return (color != null);
    }

    public boolean validateSize(byte size) {
        return (size >= MIN_SIZE && size <= MAX_SIZE);
    }

    public boolean validateMaterial(Material material) {
        return (material != null);
    }
}
