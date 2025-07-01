package car_rental_application.demo.exception;

public class NoAccessKeyException extends RuntimeException {
    public NoAccessKeyException(String message) {
        super(message);
    }
}
