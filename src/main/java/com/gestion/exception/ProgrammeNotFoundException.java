package com.gestion.exception;

public class ProgrammeNotFoundException extends RuntimeException {
    public ProgrammeNotFoundException(Long id) {
        super("Could not find film " + id);
    }
}
