package com.gestion.exception;

public class SalleNotFoundException extends RuntimeException {
    public SalleNotFoundException(Long id) {
        super("Could not find film " + id);
    }
}
