/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.entity;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.characteristic.Material;
import by.epamtc.iovchuk.validator.BallValidator;


/**
 * Класс, характеризующий мяч.
 */
public class Ball {

    /**
     * Вес мяча.
     */
    private double weight;

    /**
     * Цвет мяча.
     */
    private Color color;

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
        private final static double DEFAULT_WEIGHT = 2;
        private final static Color DEFAULT_COLOR = Color.RED;
        private final static byte DEFAULT_SIZE = 4;
        private final static Material DEFAULT_MATERIAL = Material.SYNTHETIC;

        //Вес создаваемого мяча
        private final double weight;
        //Цвет создаваемого мяча
        private final Color color;
        //Размер создаваемого мяча
        private byte size;
        //Материал, из которого изготовлен
        private Material material;

        private final BallValidator ballValidator = new BallValidator();

        /**
         * Создает строителя мяча с указанным весом и цветом.
         *
         * @param weight вес создаваемого мяча
         * @param color  цвет создаваемого мяча
         */
        public BallBuilder(double weight, Color color) {
            if (ballValidator.validateWeight(weight)) {
                this.weight = weight;
            } else {
                this.weight = DEFAULT_WEIGHT;
            }

            if (ballValidator.validateColor(color)) {
                this.color = color;
            } else {
                this.color = DEFAULT_COLOR;
            }

            size = DEFAULT_SIZE;
            material = DEFAULT_MATERIAL;
        }

        /**
         * Устанавливает указанный размер для создаваемого мяча.
         *
         * @param size размер создаваемого мяча
         * @return ссылку на объект, вызвавший данный метод
         */
        public BallBuilder size(byte size) {
            if (ballValidator.validateSize(size)) {
                this.size = size;
            }

            return this;
        }

        /**
         * Устанавливает указанный материал для создаваемого мяча.
         *
         * @param material материал создаваемого мяча
         * @return ссылку на объект, вызвавший данный метод
         */
        public BallBuilder material(Material material) {
            if (ballValidator.validateMaterial(material)) {
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color =  color;
    }

    public int getSize() {
        return size;
    }

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
