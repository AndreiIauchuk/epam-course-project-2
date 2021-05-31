/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk;

import by.epamtc.iovchuk.creator.BallsCreator;
import by.epamtc.iovchuk.entity.Ball;
import by.epamtc.iovchuk.entity.Basket;
import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.service.BallWeightCalculator;
import by.epamtc.iovchuk.service.BasketFiller;
import by.epamtc.iovchuk.service.BlueBallsCountCalculator;

import java.util.List;

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

        //Класс-создатель списка мячей
        BallsCreator ballsCreator = new BallsCreator();

        //Сервис для заполнения корзины
        BasketFiller basketFiller = new BasketFiller();

        //Сервис для расчета веса мячей в корзине
        BallWeightCalculator ballWeightCalculator =
                new BallWeightCalculator();

        //Сервис для расчетаи количества синих мячей в корзине
        BlueBallsCountCalculator blueBallsCountCalculator =
                new BlueBallsCountCalculator();

        Basket basket = new Basket((byte) 40);

        //Созданный классом-создателем список мячей
        List<Ball> createdBalls = ballsCreator.createBalls();

        //Вес всех мячей в корзине
        double ballsWeight = 0;

        //Количество синих мячей в корзине
        int blueBallsCount = 0;

        try {
            basketFiller.fill(basket, createdBalls);
            ballsWeight = ballWeightCalculator.calculate(basket);
            blueBallsCount = blueBallsCountCalculator.calculate(basket);
        } catch (NullException e) {
            e.printStackTrace();
        }

        System.out.println("Общий вес мячиков в корзине = "
                + ballsWeight);

        System.out.println("Общее количество синих мячей в корзине = "
                + blueBallsCount);
    }


}
