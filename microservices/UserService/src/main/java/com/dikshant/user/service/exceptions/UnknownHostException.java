package com.dikshant.user.service.exceptions;

public class UnknownHostException extends RuntimeException {

    public UnknownHostException() {
        super("Unknown host exception");
    }

    public UnknownHostException(String msg) {
        super(msg);
    }
}
