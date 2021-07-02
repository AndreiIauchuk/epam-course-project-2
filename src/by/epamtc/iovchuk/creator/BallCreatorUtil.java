/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.creator;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.characteristic.Material;
import by.epamtc.iovchuk.entity.Ball;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-утилита для создания мячей.
 */
public class BallCreatorUtil {

    /**
     * Создает и возвращает мяч c заданными параметрами.
     *
     * @param weight   вес создаваемого мяча
     * @param color    цвет создаваемого мяча
     * @param material материал создаваемого мяча
     * @param size     размер создаваемого мяча
     * @return мяч с указанными параметрами
     */
    static public Ball createBall(double weight, Color color, Material material, byte size) {
        return new Ball
                .BallBuilder(weight, color)
                .material(material)
                .size(size)
                .build();
    }

    static public Ball createBall(double weight, Color color) {
        return new Ball
                .BallBuilder(weight, color)
                .build();
    }

    static public Ball createBall(double weight, Color color, Material material) {
        return new Ball
                .BallBuilder(weight, color)
                .material(material)
                .build();
    }

    static public Ball createBall(double weight, Color color, byte size) {
        return new Ball
                .BallBuilder(weight, color)
                .size(size)
                .build();
    }


}
