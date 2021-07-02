/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.characteristic.Material;
import by.epamtc.iovchuk.entity.Ball;
import by.epamtc.iovchuk.entity.Basket;
import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.exception.OverCapacityException;
import by.epamtc.iovchuk.service.BallsWeightCalculator;
import by.epamtc.iovchuk.service.BlueBallsCountCalculator;

import java.util.ArrayList;
import java.util.List;

import static by.epamtc.iovchuk.creator.BallCreatorUtil.*;

/**
 * Создать класс Мяч. Создать класс Корзина.
 * Наполнить корзину мячиками. Определить вес мячиков
 * в корзине и количество синих мячиков.
 * <p>
 * Класс Main.
 * </p>
 *
 * @author Иовчук Андрей
 */
public class Main {

    public static void main(String[] args) {

        //Сервис для расчета веса мячей в корзине
        BallsWeightCalculator ballsWeightCalculator =
                new BallsWeightCalculator();

        //Сервис для расчетаи количества синих мячей в корзине
        BlueBallsCountCalculator blueBallsCountCalculator =
                new BlueBallsCountCalculator();

        Basket basket = new Basket();
        fillBasketWithCustomBalls(basket);

        //Вес всех мячей в корзине
        double ballsWeight = ballsWeightCalculator.calculate(basket);

        //Количество синих мячей в корзине
        int blueBallsCount = blueBallsCountCalculator.calculate(basket);

        System.out.println("Общий вес мячей в корзине = "
                + ballsWeight);

        System.out.println("Общее количество синих мячей в корзине = "
                + blueBallsCount);
    }

    static private void fillBasketWithCustomBalls(Basket basket) {
        List<Ball> balls = new ArrayList<>();

        balls.add(createBall(1.1, Color.GREEN, (byte) 2));
        balls.add(createBall(52.3, Color.BLUE));
        balls.add(createBall(21.9, Color.GREEN, Material.LEATHER, (byte) 3));
        balls.add(createBall(1.3, Color.ORANGE));
        balls.add(createBall(11.6, Color.BLUE, Material.SYNTHETIC, (byte) 4));
        balls.add(createBall(31.6, Color.BLUE, null, (byte) 1));
        balls.add(createBall(11.6, Color.BROWN, (byte) 2));
        balls.add(createBall(1.4, Color.GREEN, Material.LEATHER));

        try {
            basket.putBalls(balls);
        } catch (NullException | OverCapacityException e) {
            e.printStackTrace();
        }
    }
}
