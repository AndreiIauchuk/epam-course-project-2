/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.entity;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.characteristic.Material;
import by.epamtc.iovchuk.exception.BellowOrEqualsZeroException;
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
                throws BellowOrEqualsZeroException, NullException {

            if (weight <= 0) {
                throw new BellowOrEqualsZeroException("Вес");
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
        public BallBuilder size(byte size) throws BellowOrEqualsZeroException {

            if (size <= 0) {
                throw new BellowOrEqualsZeroException
                        ("Размер мяча");
            }

            if (size > 5) {
                throw new BellowOrEqualsZeroException
                        ("Размер мяча не может превышать пяти!");
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

}
