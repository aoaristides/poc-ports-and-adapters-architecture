package br.com.makersweb.hexagonal.architecture.application.core.exception;

/**
 * @author aaristides
 */
public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super(message);
    }
}
