/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.creator;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.characteristic.Material;
import by.epamtc.iovchuk.entity.Ball;
import by.epamtc.iovchuk.exception.BellowMinValueException;
import by.epamtc.iovchuk.exception.BellowOrEqualsZeroException;
import by.epamtc.iovchuk.exception.OverMaxValueException;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-создатель мячей.
 */
public class BallsCreator {

    /**
     * Создает мячи и возвращает список, заполненный этими мячами.
     *
     * @return список созданных мячей
     */
    public List<Ball> createBalls() {

        List<Ball> balls = new ArrayList<>();

        balls.add(createBall(1.1, Color.GREEN, Material.LEATHER, (byte) 2));
        balls.add(createBall(52.3, Color.BLUE, null, (byte) 5));
        balls.add(createBall(21.9, Color.GREEN, Material.LEATHER, (byte) 3));
        balls.add(createBall(1.3, Color.ORANGE, null, (byte) 2));
        balls.add(createBall(11.6, Color.BLUE, Material.SYNTHETIC, (byte) 4));
        balls.add(createBall(1.4, Color.GREEN, Material.LEATHER, (byte) 3));
        balls.add(createBall(31.6, Color.BLUE, null, (byte) 1));
        balls.add(createBall(11.6, Color.BROWN, null, (byte) 2));

        return balls;
    }

    /**
     * Создает и возвращает мяч.
     *
     * @param weight вес создаваемого мяча
     * @param color цвет создаваемого мяча
     * @param material материал создаваемого мяча
     * @param size размер создаваемого мяча
     * @return мяч с указанными параметрами
     */
    private Ball createBall(double weight, Color color,
                            Material material, byte size) {

        Ball ball = null;

        try {
            ball =
                    new Ball.BallBuilder(weight, color)
                            .material(material)
                            .size(size)
                            .build();
        } catch (OverMaxValueException
                | BellowMinValueException
                | BellowOrEqualsZeroException e) {
            e.printStackTrace();
        }

        return ball;
    }


}
