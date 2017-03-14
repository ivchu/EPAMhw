package hw.epam.properties.Exceptions;

public class NoSuchPropertyFileException extends RuntimeException {
    public NoSuchPropertyFileException(String message) {
        super(message);
    }
}
