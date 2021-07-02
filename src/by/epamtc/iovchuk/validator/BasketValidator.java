/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.validator;

public class BasketValidator {

    private final static int MAX_CAPACITY = 100;

    public boolean validateLessMaxCapacity(int capacity) {
        return capacity <= MAX_CAPACITY;
    }
}
