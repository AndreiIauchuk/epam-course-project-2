/*
 * Copyright (c) 2021. All rights reserved.
 */

package by.epamtc.iovchuk.exception;

public class OverCapacityException extends Exception {

    public OverCapacityException() {
        super();
    }

    public OverCapacityException(String message) {
        super(message);
    }

    public OverCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverCapacityException(Throwable cause) {
        super(cause);
    }
}
