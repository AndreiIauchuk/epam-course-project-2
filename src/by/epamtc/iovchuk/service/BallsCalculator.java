/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.service;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.entity.Ball;
import by.epamtc.iovchuk.entity.Basket;

import java.util.List;

/**
 * Сервис для расчета веса мячей
 * и количество синих мячиков в корзине.
 */
public class BallsCalculator {

    /**
     * Вычисляет вес всех мячей в корзине
     *
     * @param basket корзина, для которой
     *               производится расчет веса
     * @return вес всех мячей в корзине
     */
    public double calcWeight(Basket basket) {

        //Вес всех мячей в указанной корзине
        double ballsWeight = 0;

        //Список мячей в указанной корзине
        List<Ball> ballsInBasket = basket.getBalls();

        /*
         * Проходит по списку мячей в корзине
         * и вычисляет вес всех мячей
         */
        for (Ball ball : ballsInBasket) {
            ballsWeight += ball.getWeight();
        }

        return ballsWeight;
    }

    public int calcBlueBallsCount(Basket basket) {

        //Количество синих мячей в указанной корзине
        int blueBallsCount = 0;

        //Список мячей в указанной корзине
        List<Ball> ballsInBasket = basket.getBalls();

        int i = 0;

        /*
         * Проходит по списку мячей в корзине
         * и вычисляет количество синих мячей
         */
        for (Ball ball : ballsInBasket) {
            if (ball.getColor() == Color.BLUE) {
                ++blueBallsCount;
            }
            i++;
        }

        return blueBallsCount;
    }
}
