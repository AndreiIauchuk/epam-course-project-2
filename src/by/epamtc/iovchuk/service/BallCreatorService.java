/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.service;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.entity.Ball;

import java.util.Random;

/**
 * Сервис для создания мяча со случайными параметрами.
 */
public class BallCreatorService {

    Random random = new Random();

    /**
     * Созданиет мяч со случайными параметрами.
     *
     * @return мяч со случайными параметрами
     */
    public Ball create() {

        double ballWeight = getRandomWeight(0.1, 3.0);
        Ball ball = new Ball.BallBuilder(1.0, Color.BLUE).size(3).build();
    }

    /**
     * Возвращает случайный вес в указанном диапазоне.
     *
     * @param minWeight минимальный вес
     * @param maxWeight максимальный вес
     * @return случайный вес мяча
     */
    private double getRandomWeight(double minWeight, double maxWeight) {
        return minWeight + random.nextDouble() * (maxWeight - minWeight);
    }

    /**
     * Возвращает случайный цвет мяча.
     *
     * @return случайный цвет мяча
     */
    private Color getRandomColor() {

        Color[] colors = Color.values();

        int colorsCount = colors.length;

        return colors[random.nextInt(colorsCount)];
    }

    /**
     * Возвращает случайный размер мяча.
     *
     * @return
     */
    private byte getRandomSize() {
        /*
         * Т.к. метод nextInt(int bound) класса Random возвращает
         * случайное целое число в диапазоне 0 ≤ x < n,
         * а значение размера мяча находится в диапазоне 1 ≤ x ≤ 5,
         * вычисляет случайное целое число в диапазоне 0 ≤ x < 5
         * и добавляет к полученному результату единицу
         */

        return (byte) (random.nextInt(5) + 1);

    }


}
