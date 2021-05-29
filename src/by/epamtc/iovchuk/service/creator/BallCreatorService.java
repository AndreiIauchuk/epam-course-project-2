/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.service.creator;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.characteristic.Material;
import by.epamtc.iovchuk.entity.Ball;
import by.epamtc.iovchuk.exception.BellowOrEqualsZeroException;
import by.epamtc.iovchuk.exception.MaxLessThanMinException;
import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.exception.OverMaxValueException;

import java.util.Random;

/**
 * Сервис для создания мяча со случайными параметрами.
 */
public class BallCreatorService extends Creator<Ball>{

    private final Random random = new Random();

    /**
     * Создает мяч со случайными параметрами.
     *
     * @return мяч со случайными параметрами
     */
    @Override
    public Ball create() {

        //Вес создаваемого мяча
        double ballWeight = 0;

        try {
            ballWeight = getRandomWeight(0.1, 3.0);
        } catch (BellowOrEqualsZeroException | MaxLessThanMinException e) {
            e.printStackTrace();
        }

        //Цвет создаваемого мяча
        Color ballColor = getRandomColor();

        //Строитель создаваемого мяча
        Ball.BallBuilder ballBuilder =
                null;

        try {
            ballBuilder = new Ball.BallBuilder(ballWeight, ballColor);
        } catch (BellowOrEqualsZeroException | NullException e) {
            e.printStackTrace();
        }

        //Требуется ли изменять размер по умолчанию для создаваемого мяча
        if (random.nextBoolean()) {
            //Размер создаваемого мяча
            byte ballSize = getRandomSize();

            try {
                ballBuilder.size(ballSize);
            } catch (BellowOrEqualsZeroException | OverMaxValueException e) {
                e.printStackTrace();
            }
        }

        //Требуется ли изменять материал по умолчанию для создаваемого мяча
        if (random.nextBoolean()) {
            //Материал создаваемого мяча
            Material ballMaterial = getRandomMaterial();

            try {
                ballBuilder.material(ballMaterial);
            } catch (NullException e) {
                e.printStackTrace();
            }
        }

        return ballBuilder.build();
    }

    /**
     * Возвращает случайный вес в указанном диапазоне.
     *
     * @param minWeight минимальный вес
     * @param maxWeight максимальный вес
     * @return случайный вес мяча
     */
    private double getRandomWeight(double minWeight, double maxWeight)
            throws BellowOrEqualsZeroException, MaxLessThanMinException {

        if (minWeight <= 0 || maxWeight <= 0) {
            throw new BellowOrEqualsZeroException("Вес");
        }

        if(maxWeight < minWeight) {
            throw new MaxLessThanMinException("Вес");
        }

        if (maxWeight == minWeight) {
            return minWeight;
        }

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
     * @return случайный размер мяча
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

    /**
     * Возвращает случайный материал мяча.
     *
     * @return случайный материал мяча
     */
    private Material getRandomMaterial() {

        Material[] materials = Material.values();

        int materialsCount = materials.length;

        return materials[random.nextInt(materialsCount)];
    }

}
