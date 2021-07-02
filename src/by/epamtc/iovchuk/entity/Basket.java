/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.entity;

import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.exception.OverCapacityException;
import by.epamtc.iovchuk.validator.BasketValidator;

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
    private final List<Ball> balls = new ArrayList<>();

    /**
     * Количество мячей в корзине.
     */
    private int ballsCount;

    /**
     * Вместимость корзины.
     */
    private final int capacity;

    /**
     * Вместимость по умолчанию
     */
    private final static int DEFAULT_CAPACITY = 20;

    /**
     * Создает корзину с вместимостью по умолчанию 50.
     */
    public Basket() {
        capacity = DEFAULT_CAPACITY;
    }

    /**
     * Создает корзину с указанной вместимосью.
     */
    public Basket(int capacity) {
        BasketValidator basketValidator = new BasketValidator();

        if (!basketValidator.validateLessMaxCapacity(capacity)) {
            this.capacity = capacity;
        } else {
            this.capacity = DEFAULT_CAPACITY;
        }

    }

    /**
     * Кладет указанный мяч в корзину.
     *
     * @param ball мяч для добавления в список мячей
     * @return true, если мяч был добавлен в корзину
     * @throws NullException         если указана ссылка на null
     * @throws OverCapacityException если корзина переполнена
     */
    public boolean putBall(Ball ball) throws NullException, OverCapacityException {
        if (ball == null) {
            throw new NullException("Мяч");
        }

        if (ballsCount > capacity) {
            throw new OverCapacityException
                    ("Невозможно добавить мяч в корзину. Корзина переполнена!");
        }

        ++ballsCount;
        return balls.add(ball);
    }

    /**
     * Кладет указанный список мячей в корзину.
     *
     * @param balls мячи для добавления в список мячей
     * @throws NullException         если указана ссылка на null
     * @throws OverCapacityException если корзина переполнена
     */
    public void putBalls(List<Ball> balls) throws NullException, OverCapacityException {
        if (balls == null) {
            throw new NullException("Список мячей");
        }

        if (capacity - ballsCount < balls.size()) {
            throw new OverCapacityException
                    ("Невозможно добавить мяч в корзину. Корзина переполнена!");
        }

        ballsCount = ballsCount + balls.size();
        this.balls.addAll(balls);
    }

    /**
     * Достает указанный мяч из корзины.
     *
     * @param ball мяч, извлекаемый из корзины
     * @return мяч, удаленный из корзины,
     * либо null, если указанного мяча нет в корзине
     * @throws NullException если указана ссылка на null
     */
    public Ball takeBall(Ball ball) throws NullException {
        if (ball == null) {
            throw new NullException("Мяч");
        }

        int ballIndex = balls.indexOf(ball);
        if (ballIndex == -1) {
            return null;
        }

        Ball removedBall = balls.remove(ballIndex);

        --ballsCount;
        return removedBall;
    }

    /**
     * Геттер вместимости корзины.
     *
     * @return вместимость корзины
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Возвращает итератор по списку мячей в корзине.
     *
     * @return итератор по списку мячей в корзине
     */
    public Iterator<Ball> getBallsIterator() {
        return balls.iterator();
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
        hashCode = 31 * hashCode + capacity;
        hashCode = 31 * hashCode + (balls.isEmpty() ? 0 : balls.hashCode());
        return hashCode;
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();

        toStringBuilder
                .append(getClass())
                .append(" { ")
                .append("balls=").append(balls)
                .append(", capacity=").append(capacity)
                .append(" }");

        return toStringBuilder.toString();
    }
}
