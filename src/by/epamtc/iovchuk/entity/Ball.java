/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.entity;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.characteristic.Material;
import by.epamtc.iovchuk.exception.BellowMinValueException;
import by.epamtc.iovchuk.exception.BellowOrEqualsZeroException;
import by.epamtc.iovchuk.exception.OverMaxValueException;

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
     * Минималньый вес мяча.
     */
    private static final double MIN_WEIGHT = 1;

    /**
     * Максимальный вес мяча.
     */
    private static final double MAX_WEIGHT = 100.0;

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

        /**
         * Создает строителя мяча с указанным весом и цветом.
         *
         * @param weight вес создаваемого мяча
         * @param color  цвет создаваемого мяча
         * @throws BellowOrEqualsZeroException если указан вес меньше или равный нулю
         * @throws BellowMinValueException если указан вес меньше минимального
         * @throws OverMaxValueException если указан вес больше максимального
         */
        public BallBuilder(double weight, Color color)
                throws BellowOrEqualsZeroException, BellowMinValueException,
                OverMaxValueException {

            if (weight <= 0) {
                throw new BellowOrEqualsZeroException("Вес");
            }

            if (weight < MIN_WEIGHT) {
                throw new BellowMinValueException("Вес", MIN_WEIGHT);
            }

            if (weight > MAX_WEIGHT) {
                throw new OverMaxValueException("Вес", MAX_WEIGHT);
            }

            this.weight = weight;
            this.color = color;
        }

        /**
         * Устанавливает указанный размер для создаваемого мяча.
         *
         * @param size размер создаваемого мяча
         * @return ссылку на объект, вызвавший данный метод
         * @throws BellowMinValueException если указан размер меньше минимального
         * @throws OverMaxValueException   если указан размер больше максимального
         */
        public BallBuilder size(byte size)
                throws OverMaxValueException, BellowMinValueException {

            if (size < MIN_SIZE) {
                throw new BellowMinValueException("Размер мяча", MIN_SIZE);
            }

            if (size > MAX_SIZE) {
                throw new OverMaxValueException("Размер мяча", MAX_SIZE);
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
        public BallBuilder material(Material material) {

            if (material != null) {
                this.material = material;
            }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ball.weight == weight &&
                ball.size == size &&
                ball.color == color &&
                ball.material == material;
    }

    @Override
    public int hashCode() {
        int hashCode = 5;
        hashCode = 31 * hashCode + (int) weight;
        hashCode = 31 * hashCode + (color == null ? 0 : color.hashCode());
        hashCode = 31 * hashCode + size;
        hashCode = 31 * hashCode + (material == null ? 0 : material.hashCode());
        return hashCode;
    }
}
