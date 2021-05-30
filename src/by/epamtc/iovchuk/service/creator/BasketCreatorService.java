/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.service.creator;

import by.epamtc.iovchuk.entity.Basket;
import by.epamtc.iovchuk.exception.BellowOrEqualsZeroException;
import by.epamtc.iovchuk.exception.OverMaxValueException;

/**
 * Сервис для создания корзины.
 */
public class BasketCreatorService{

    /**
     * Создает и возвращает корзину с вместимосью по умолчанию 50.
     *
     * @return созданную корзину
     */
    public Basket create() {
        return new Basket();
    }

    /**
     * Создает и возвращает корзину с указанной вместимосью.
     */
    public Basket create(byte capacity) {

        try {
            return new Basket(capacity);
        } catch (BellowOrEqualsZeroException | OverMaxValueException e) {
            e.printStackTrace();
        }

        return null;
    }

}
