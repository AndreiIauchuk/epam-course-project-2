/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.service;

import by.epamtc.iovchuk.entity.Ball;
import by.epamtc.iovchuk.entity.Basket;
import by.epamtc.iovchuk.exception.NullException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Сервис для заполнения корзины мячами со случайными параметрами.
 */
public class BasketFillerService {

    /**
     * Заполненяет корзину указанным количеством мячей
     * со случайными параметрами.
     *
     * @param basket     корзина для заполнения
     * @param ballsCount количество мячей для заполнения
     */
    public void fill(Basket basket, int ballsCount) {

        //Список мячей для добавления в корзину
        List<Ball> balls = new ArrayList<>();

        //Сервис для создания мяча со случайными параметрами
        BallCreatorService ballCreator = new BallCreatorService();

        for (int i = 0; i < ballsCount; ++i) {
            //Созданный мяч
            Ball ball = ballCreator.create();

            balls.add(ball);
        }

        try {
            basket.setBalls(balls);
        } catch (NullException e) {
            e.printStackTrace();
        }
    }
}
