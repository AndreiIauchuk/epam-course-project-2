/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.entity;

import by.epamtc.iovchuk.exception.OverCapacityException;
import by.epamtc.iovchuk.exception.OverMaxValueException;
import by.epamtc.iovchuk.exception.BellowOrEqualsZeroException;
import by.epamtc.iovchuk.exception.NullException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс, характеризующий корзину.
 */
public class Basket implements Serializable {

    private static final long serialVersionUID = 1L;

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
     */
    public Basket(byte capacity) {
        this.capacity = capacity;
    }

    /**
     * Геттер вместимости корзины.
     *
     * @return вместимость корзины
     */
    public byte getCapacity() {
        return capacity;
    }

    /**
     * Возвращает итератор по списку мячей в корзине.
     * @return итератор по списку мячей в корзине
     */
    public Iterator<Ball> getBallsIterator() {
        return balls.iterator();
    }

    /**
     * Добавляет указанный мяч в список мячей.
     *
     * @param ball мяч для добавления в список мячей
     * @throws NullException если указана ссылка на null
     */
    public void addBall(Ball ball) throws NullException, OverCapacityException {

        if (ball == null) {
            throw new NullException("Мяч");
        }

        if (balls.size() <= capacity) {
            balls.add(ball);
        } else {
            throw new OverCapacityException("Невозможно добавить мяч в корзину. Корзина переполнена!");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return basket.balls.equals(balls) &&
                basket.capacity == capacity;
    }

    @Override
    public int hashCode() {
        int hashCode = 5;
        hashCode = 31 * hashCode + (int) capacity;
        hashCode = 31 * hashCode
                + ((balls == null || balls.isEmpty()) ? 0 : balls.hashCode());
        return hashCode;
    }

}
