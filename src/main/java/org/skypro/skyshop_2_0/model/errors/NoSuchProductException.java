package org.skypro.skyshop_2_0.model.errors;
import java.io.IOException;

public class NoSuchProductException extends RuntimeException {

    public NoSuchProductException() {
        super();
    }

    public NoSuchProductException(String message) {
        super(message);
    }

    public NoSuchProductException(Throwable t) {
        super(t);
    }
    public NoSuchProductException(String message, Throwable t) {
        super(message, t);
    }
}
