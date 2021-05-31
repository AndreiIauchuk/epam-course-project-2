/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.service;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.entity.Ball;
import by.epamtc.iovchuk.entity.Basket;
import by.epamtc.iovchuk.exception.NullException;

import java.util.Iterator;

/**
 * Сервис для расчета количества
 * синих мячей в указанной корзине.
 */
public class BlueBallsCountCalculator {

    /**
     * Вычисляет количество синих мячей в указанной корзине.
     *
     * @param basket корзина, для которой производится
     *               расчет количества синих мячей
     * @return количество синих мячей в корзине
     */
    public int calculate(Basket basket) throws NullException {

        if (basket == null) {
            throw new NullException("Корзина");
        }

        //Количество синих мячей в указанной корзине
        int blueBallsCount = 0;

        //Итератор по списку мячей в указанной корзине
        Iterator<Ball> ballsIterator = basket.getBallsIterator();

        /*
         * Проходит по списку мячей в корзине
         * и вычисляет количество синих мячей
         */
        while (ballsIterator.hasNext()) {
            Ball nextBall = ballsIterator.next();
            if (nextBall.getColor() == Color.BLUE) {
                ++blueBallsCount;
            }
        }

        return blueBallsCount;
    }
}
