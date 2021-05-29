/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.exception;

/**
 * Выбрасываемое исключение, если пользователь указал
 * ссылку на null.
 */
public class NullException extends Exception{

    public NullException() {
        super();
    }

    public NullException(String parameter) {
        super(parameter + " не может иметь значение null!");
    }

    public NullException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullException(Throwable cause) {
        super(cause);
    }
}
