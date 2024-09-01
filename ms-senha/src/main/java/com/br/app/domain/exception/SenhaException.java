package com.br.app.domain.exception;

import java.io.Serializable;

public class SenhaException extends RuntimeException implements Serializable {

    public SenhaException() {
        super();
    }

    public SenhaException(String message) {
        super(message);
    }

    public SenhaException(String message, Throwable cause) {
        super(message, cause);
    }
}
