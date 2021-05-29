/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.exception;

/**
 * Выбрасываемое исключение, если пользователь указал
 * значение меньшее или равное нулю.
 */
public class BellowOrEqualsZeroException extends Exception {

    public BellowOrEqualsZeroException() {
        super();
    }

    /**
     * Создает исключение для указанного параметра объекта.
     *
     * @param parameter параметр объекта
     */
    public BellowOrEqualsZeroException(String parameter) {
        super(parameter + " не может быть меньше или равен нулю!");
    }

    public BellowOrEqualsZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public BellowOrEqualsZeroException(Throwable cause) {
        super(cause);
    }
}

