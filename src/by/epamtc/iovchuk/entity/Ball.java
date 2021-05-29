/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.entity;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.characteristic.Material;
import by.epamtc.iovchuk.exception.BellowMinValueException;
import by.epamtc.iovchuk.exception.BellowOrEqualsZeroException;
import by.epamtc.iovchuk.exception.OverMaxValueException;
import by.epamtc.iovchuk.exception.NullException;

/**
 * Класс, характеризующий мяч.
 */
public class Ball {

    /**
     * Вес мяча.
     */
    private final double weight;

    /**
     * Цвет мяча.
     */
    private final Color color;

    /**
     * Размер мяча.
     */
    private final int size;

    /**
     * Материал, из которого изготовлен мяч.
     */
    private final Material material;

    /**
     * Минималньый размер мяча.
     */
    private static final byte MIN_SIZE = 1;

    /**
     * Максимальный размер мяча.
     */
    private static final byte MAX_SIZE = 5;

    /**
     * Минималньый размер мяча.
     */
    private static final double MIN_WEIGHT = 0.1;

    /**
     * Максимальный размер мяча.
     */
    private static final double MAX_WEIGHT = 3.0;

    private Ball(BallBuilder builder) {
        weight = builder.weight;
        color = builder.color;
        size = builder.size;
        material = builder.material;
    }

    /**
     * Класс-строитель мяча.
     */
    public static class BallBuilder {

        //Вес создаваемого мяча
        private final double weight;
        //Цвет создаваемого мяча
        private final Color color;
        //Размер создаваемого мяча
        private byte size = 4;
        //Материал, из которого изготовлен
        private Material material = Material.SYNTHETIC;

        public BallBuilder(double weight, Color color)
                throws BellowOrEqualsZeroException, NullException,
                BellowMinValueException, OverMaxValueException {

            if (weight <= 0) {
                throw new BellowOrEqualsZeroException("Вес");
            }

            if (weight < MIN_WEIGHT) {
                throw new BellowMinValueException("Вес", MIN_WEIGHT);
            }

            if (weight > MAX_WEIGHT) {
                throw new OverMaxValueException("Вес", MAX_WEIGHT);
            }

            if (color == null) {
                throw new NullException("Цвет ");
            }

            this.weight = weight;
            this.color = color;
        }

        /**
         * Устанавливает указанный размер для создаваемого мяча.
         *
         * @param size размер создаваемого мяча
         * @return ссылку на объект, вызвавший данный метод
         * @throws BellowOrEqualsZeroException если указан размер меньший или равный нулю
         */
        public BallBuilder size(byte size)
                throws BellowOrEqualsZeroException, OverMaxValueException {

            if (size < MIN_SIZE) {
                throw new BellowOrEqualsZeroException("Размер мяча");
            }

            if (size > MAX_SIZE) {
                throw new OverMaxValueException("Размер мяча", 5);
            }

            this.size = size;

            return this;
        }

        /**
         * Устанавливает указанный материал для создаваемого мяча.
         *
         * @param material материал создаваемого мяча
         * @return ссылку на объект, вызвавший данный метод
         */
        public BallBuilder material(Material material) throws NullException {

            if (material == null) {
                throw new NullException("Материал");

            }

            this.material = material;

            return this;
        }

        /**
         * Создает мяч.
         *
         * @return созданный мяч
         */
        public Ball build() {
            return new Ball(this);
        }

    }

    /**
     * Геттер веса мяча.
     *
     * @return вес мяча
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Геттер цвета мяча.
     *
     * @return цвет мяча
     */
    public Color getColor() {
        return color;
    }

    /**
     * Геттер размера мяча.
     *
     * @return цвет мяча
     */
    public int getSize() {
        return size;
    }

    /**
     * Геттер материала мяча.
     *
     * @return цвет мяча
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Геттер минимального веса мяча.
     *
     * @return минимальный вес мяча
     */
    public static double getMinWeight() {
        return MIN_WEIGHT;
    }

    /**
     * Геттер максимального веса мяча.
     *
     * @return максимальный вес мяча
     */
    public static double getMaxWeight() {
        return MAX_WEIGHT;
    }
}
