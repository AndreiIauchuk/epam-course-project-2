/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.exception;

/**
 * Выбрасываемое исключение, если пользователь указал
 * значение меньше минимального.
 */
public class BellowMinValueException extends Exception{

    public BellowMinValueException() {
        super();
    }

    public BellowMinValueException(String parameter, int intMinValue) {
        super(parameter + " не может быть меньше " + intMinValue + "!");
    }

    public BellowMinValueException(String parameter, double doubleMinValue) {
        super(parameter + " не может быть меньше " + doubleMinValue + "!");
    }

    public BellowMinValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public BellowMinValueException(Throwable cause) {
        super(cause);
    }
}
