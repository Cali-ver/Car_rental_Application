package car_rental_application.demo.exception;

public class NoCreditCardException extends RuntimeException {
    public NoCreditCardException(String message) {
        super(message);
    }
}
