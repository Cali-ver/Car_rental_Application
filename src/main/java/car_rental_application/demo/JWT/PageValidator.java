package car_rental_application.demo.jwt;

public class PageValidator {

    private PageValidator() {
    }

    public static Integer pageNumber(Integer page) {
        return page == null || page <= 0 ? 1 : page;
    }

}
