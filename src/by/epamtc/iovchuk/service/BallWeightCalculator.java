/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.service;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.entity.Ball;
import by.epamtc.iovchuk.entity.Basket;
import by.epamtc.iovchuk.exception.NullException;

import java.util.Iterator;
import java.util.List;

/**
 * Сервис для расчета веса мячей в корзине.
 */
public class BallWeightCalculator {

    /**
     * Вычисляет вес всех мячей в указанной корзине.
     *
     * @param basket корзина, для которой
     *               производится расчет веса
     * @return вес всех мячей в корзине
     */
    public double calculate(Basket basket) throws NullException {

        if (basket == null) {
            throw new NullException("Корзина");
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
