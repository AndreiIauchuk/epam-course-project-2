/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.exception;

public class MaxLessThanMinException extends Exception {

    public MaxLessThanMinException() {
        super();
    }

    public MaxLessThanMinException(String parameter) {
        super("Максимальный " + parameter + " не может быть меньше минимального");
    }

    public MaxLessThanMinException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaxLessThanMinException(Throwable cause) {
        super(cause);
    }
}
