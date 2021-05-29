/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.entity;

import by.epamtc.iovchuk.exception.OverMaxValueException;
import by.epamtc.iovchuk.exception.BellowOrEqualsZeroException;
import by.epamtc.iovchuk.exception.NullException;

import java.util.ArrayList;
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
    private List<Ball> balls = new ArrayList<>();

    /**
     * Вместимость корзины.
     */
    private final byte capacity;

    /**
     * Максимальная вместимость корзины.
     */
    private final static byte MAX_CAPACITY = 100;

    /**
     * Создает корзину с вместимостью по умолчанию 50.
     */
    public Basket() {
        capacity = 50;
    }

    /**
     * Создает корзину с указанной вместимосью.
     *
     * @throws BellowOrEqualsZeroException если указанная вместимостисть
     *                                     меньше или равна нулю
     * @throws OverMaxValueException       если указанная вместимостисть
     *                                     больше максимальной
     */
    public Basket(byte capacity)
            throws BellowOrEqualsZeroException, OverMaxValueException {

        if (capacity <= 0) {
            throw new BellowOrEqualsZeroException("Вместимость корзины");
        }

        if (capacity > MAX_CAPACITY) {
            throw new OverMaxValueException("Вместимость корзины", MAX_CAPACITY);
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
    public void setBalls(List<Ball> balls) throws NullException, OverMaxValueException {

        if (balls == null) {
            throw new NullException("Список мячей");
        }

        if (balls.size() > capacity) {
            throw new OverMaxValueException("Количество мячей в корзине", capacity);
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
