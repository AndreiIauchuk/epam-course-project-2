/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.service;

import by.epamtc.iovchuk.entity.Ball;
import by.epamtc.iovchuk.entity.Basket;
import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.exception.OverCapacityException;

import java.util.List;

/**
 * Сервис для заполнения корзины.
 */
public class BasketFiller {

    /**
     * Корзина для заполнения.
     */
    private Basket basket;

    /**
     * Заполняет указанную корзину указанным списком мячей.
     *
     * @param basket корзина для заполнения
     * @param ballsToFill список мячей для добавления в корзину
     * @throws NullException если указана ссылка на null
     */
    public void fill(Basket basket, List<Ball> ballsToFill) throws NullException{

        if (basket == null) {
            throw new NullException("Корзина");
        }

        this.basket = basket;

        /*
        * Проходит по списку мячей для заполнения
        * и добавляет каждый мяч в список мячей в корзине
         */
        for (Ball ballToFill : ballsToFill) {
            putBallIn(ballToFill);
        }
    }

    /**
     * Кладет указанный мяч в корзину для заполнения.
     *
     * @param ballToFill мяч для добавления в корзину
     */
    private void putBallIn(Ball ballToFill) {
        try {
            basket.addBall(ballToFill);
        } catch (NullException | OverCapacityException e) {
            e.printStackTrace();
        }
    }
}
