package car_rental_application.demo.JWT;

public class PageValidator {

    private PageValidator() {
    }

    public static Integer pageNumber(Integer page) {
        return page == null || page <= 0 ? 1 : page;
    }

}
