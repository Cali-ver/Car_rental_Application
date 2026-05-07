package car_rental_application.demo.controller;



import car_rental_application.demo.entity.PlacedOrder;
import car_rental_application.demo.dto.AccessKeyDto;
import car_rental_application.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public List<PlacedOrder> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/orders")
    public AccessKeyDto submitOrder(@RequestParam String carPackage, @RequestParam Integer hours) {
        return orderService.submitOrder(carPackage, hours);
    }

}
