/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.exception;

/**
 * Выбрасываемое исключение, если пользователь указал
 * вместимость корзины больше максимальной
 */
public class MaxValueException extends Exception{

    public MaxValueException() {
        super("Вместимость корзины не может быть боьше максимальной!");
    }

    public MaxValueException(String parameter, int intMaxValue) {
        super(parameter + " не может быть больше " + intMaxValue + "!");
    }

    public MaxValueException(String parameter, double doubleMaxValue) {
        super(parameter + " не может быть больше " + doubleMaxValue + "!");
    }

    public MaxValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaxValueException(Throwable cause) {
        super(cause);
    }
}
