/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.entity;

import by.epamtc.iovchuk.exception.MaxValueException;
import by.epamtc.iovchuk.exception.BellowOrEqualsZeroException;
import by.epamtc.iovchuk.exception.NullException;

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
     * Вместимость корзины.
     */
    private final byte capacity;

    /**
     * Максимальная вместимость корзины.
     */
    private final static byte MAX_CAPACITY = 100;

    /**
     * Создает корзину с вместимосью по умолчанию 50.
     */
    public Basket() {
        capacity = 50;
    }

    /**
     * Создает корзину с указанной вместимосью.
     *
     * @throws BellowOrEqualsZeroException если указанная вместимостисть
     *                                     меньше или равна нулю
     */
    public Basket(byte capacity)
            throws BellowOrEqualsZeroException, MaxValueException {

        if (capacity <= 0) {
            throw new BellowOrEqualsZeroException("Вместимость корзины");
        }

        if (capacity > MAX_CAPACITY) {
            throw new MaxValueException();
        }

        this.capacity = capacity;
    }

    /**
     * Геттер списка мячей в корзине.
     *
     * @return список мячей в корзине
     */
    public List<Ball> getBalls() {
        return balls;
    }

    /**
     * Сеттер списка мячей в корзине.
     */
    public void setBalls(List<Ball> balls) throws NullException {
        if (balls == null) {
            throw new NullException("Список мячей");
        }

        this.balls = balls;
    }

    /**
     * Геттер вместимости корзины.
     *
     * @return вместимость корзины
     */
    public byte getCapacity() {
        return capacity;
    }
}
