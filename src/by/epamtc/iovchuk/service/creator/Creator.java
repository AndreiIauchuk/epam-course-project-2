/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.service.creator;

/**
 * Абстрактный класс для создания экземпляров класса.
 */
public abstract class Creator<T> {

    /**
     * Создает объект класса.
     *
     * @return объект класса
     */
    abstract T create();
}
