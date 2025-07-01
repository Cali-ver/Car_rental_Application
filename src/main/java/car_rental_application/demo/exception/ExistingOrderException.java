package car_rental_application.demo.exception;

public class ExistingOrderException extends RuntimeException {

    public ExistingOrderException(String message) {
        super(message);
    }
}
