/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk;

import by.epamtc.iovchuk.entity.Basket;
import by.epamtc.iovchuk.service.BallsCalculator;
import by.epamtc.iovchuk.service.creator.BasketCreatorService;
import by.epamtc.iovchuk.service.BasketFillerService;

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

        //Сервис для создания мяча со случайными параметрами
        BasketCreatorService basketCreatorService = new BasketCreatorService();

        //Сервис заполнения корзины мячами со случайными параметрами
        BasketFillerService basketFillerService = new BasketFillerService();

        /*
         * Сервис для расчета веса мячей
         * и количество синих мячиков в корзине
         */
        BallsCalculator ballsCalculator = new BallsCalculator();

        //Созданная корзина
        Basket basket = basketCreatorService.create();

        System.out.println("basket = " + basket);

        //Заполняет созданную корзину пятьюстами мячиков
        basketFillerService.fill(basket, 500);

        System.out.println(basket.getBalls());

        //Вес всех мячей в корзине
        double ballsWeight = ballsCalculator.calcWeight(basket);

        //Количество синих мячей в корзине
        int blueBallsCount = ballsCalculator.calcBlueBallsCount(basket);

        System.out.println("Общий вес мячиков в корзине = "
                + ballsWeight);

        System.out.println("Общее количество синих мячей в корзине = "
                + blueBallsCount);
    }


}
