/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.entity;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.characteristic.Material;

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

        public BallBuilder(double weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public BallBuilder size(byte size) {
            this.size = size;
            return this;
        }

        public BallBuilder material(Material material) {
            this.material = material;
            return this;
        }

        public Ball build() {
            return new Ball(this);
        }


    }
}
