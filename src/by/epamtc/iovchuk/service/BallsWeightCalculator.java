/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.service;

import by.epamtc.iovchuk.entity.Ball;
import by.epamtc.iovchuk.entity.Basket;
import by.epamtc.iovchuk.exception.NullException;

import java.util.Iterator;

/**
 * Сервис для расчета веса мячей в корзине.
 */
public class BallsWeightCalculator {

    /**
     * Вычисляет вес всех мячей в указанной корзине.
     *
     * @param basket корзина, для которой
     *               производится расчет веса
     * @return вес всех мячей в корзине,
     * либо -1, если ссылочная переменная имеет значение null
     */
    public double calculate(Basket basket) {

        if (basket == null) {
            return -1;
        }

        //Вес всех мячей в указанной корзине
        double ballsWeight = 0;

        //Итератор по списку мячей в указанной корзине
        Iterator<Ball> ballsIterator = basket.getBallsIterator();

        /*
         * Проходит по списку мячей в корзине
         * и вычисляет вес всех мячей
         */
        while (ballsIterator.hasNext()) {
            Ball nextBall = ballsIterator.next();
            ballsWeight += nextBall.getWeight();
        }

        return ballsWeight;
    }

}
