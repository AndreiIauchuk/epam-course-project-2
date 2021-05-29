/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.service;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.entity.Ball;
import by.epamtc.iovchuk.entity.Basket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Сервис для заполнения корзины случайно сгенерованным
 * набором мячей со случайными параметрами.
 */
public class BasketFillerService {

    /**
     * Заполненяет корзину случайно сгенерованным
     * набором мячей со случайными параметрами.
     */
    public void fill(Basket basket) {
        List<Ball> balls = new ArrayList<>();

        Random random = new Random();

        int ballsCount = random.nextInt(1000);

        for (int i = 0; i < ballsCount; ++i) {

        }
    }
}
