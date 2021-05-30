/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.service.creator;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.characteristic.Material;
import by.epamtc.iovchuk.entity.Ball;
import by.epamtc.iovchuk.exception.*;

import java.util.Random;

/**
 * Сервис для создания мяча со случайными параметрами.
 */
public class RandomBallCreatorService {

    private final Random random = new Random();

    /**
     * Строитель мяча.
     */
    private Ball.BallBuilder ballBuilder;

    /**
     * Создает и возвращает мяч со случайными параметрами.
     *
     * @return мяч со случайными параметрами
     */
    public Ball create() {

        //Вес создаваемого мяча
        double ballWeight = getRandomWeight();

        //Цвет создаваемого мяча
        Color ballColor = getRandomColor();

        //Создает нового строителя мяча
        createBallBuilder(ballWeight, ballColor);

        /*
         * C вероятностью 50% изменяет размер по умолчанию
         * для создаваемого мяча на случайный
         */
        randomlyChangeDefaultSize();

        /*
         * C вероятностью 50% изменяет материал по умолчанию
         * для создаваемого мяча на случайный
         */
        randomlyChangeDefaultMaterial();

        return ballBuilder.build();
    }

    /**
     * Возвращает случайный вес в указанном диапазоне.
     *
     * @return случайный вес мяча
     */
    private double getRandomWeight() {

        return Ball.getMinWeight() + random.nextDouble()
                * (Ball.getMaxWeight() - Ball.getMinWeight());
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
     * Создает нового строителя мяча.
     *
     * @param ballWeight вес создаваемого мяча
     * @param ballColor  цвет оздаваемого мяча
     */
    private void createBallBuilder(double ballWeight, Color ballColor) {
        try {
            ballBuilder = new Ball.BallBuilder(ballWeight, ballColor);
        } catch (BellowOrEqualsZeroException | NullException
                | BellowMinValueException | OverMaxValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * С вероятностью 50% изменяет размер по умолчанию
     * для создаваемого мяча на случайный.
     */
    private void randomlyChangeDefaultSize() {
        if (random.nextBoolean()) {
            //Размер создаваемого мяча
            byte ballSize = getRandomSize();

            try {
                ballBuilder.size(ballSize);
            } catch (BellowOrEqualsZeroException | OverMaxValueException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * С вероятностью 50% изменяет материал по умолчанию
     * для создаваемого мяча на случайный.
     */
    private void randomlyChangeDefaultMaterial() {
        if (random.nextBoolean()) {
            //Материал создаваемого мяча
            Material ballMaterial = getRandomMaterial();

            try {
                ballBuilder.material(ballMaterial);
            } catch (NullException e) {
                e.printStackTrace();
            }
        }
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
