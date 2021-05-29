/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.exception;

/**
 * Выбрасываемое исключение, если пользователь указал
 * вместимость корзины больше максимальной
 */
public class OverMaxValueException extends Exception{

    public OverMaxValueException() {
        super();
    }

    public OverMaxValueException(String parameter, int intMaxValue) {
        super(parameter + " не может быть больше " + intMaxValue + "!");
    }

    public OverMaxValueException(String parameter, double doubleMaxValue) {
        super(parameter + " не может быть больше " + doubleMaxValue + "!");
    }

    public OverMaxValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverMaxValueException(Throwable cause) {
        super(cause);
    }
}
