package car_rental_application.demo.exception;

public class ExistingEntityException extends RuntimeException{


    public ExistingEntityException(String message) {
        super(message);
    }
}
