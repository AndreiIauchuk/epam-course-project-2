/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.entity;

import java.util.List;

/**
 * Класс, характеризующий корзину.
 */
public class Basket {

    /**
     * Список мячей в корзине.
     * <p>
     * Количество мячей не превышает вместимость {@code capacity}.
     * </p>
     */
    private List<Ball> balls;

    /**
     * Вместитмость корзины.
     */
    private byte capacity;
}
