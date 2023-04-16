package br.com.makersweb.hexagonal.architecture.application.core.exception;

/**
 * @author aaristides
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
