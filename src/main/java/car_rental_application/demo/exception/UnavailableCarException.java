package car_rental_application.demo.exception;

public class UnavailableCarException extends RuntimeException{
    public UnavailableCarException(String message) {
        super(message);
    }

}
