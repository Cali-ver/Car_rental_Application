package car_rental_application.demo.service;

import car_rental_application.demo.Entity.CreditCard;
import car_rental_application.demo.Entity.User;
import car_rental_application.demo.Repository.CreditCardRepository;
import car_rental_application.demo.Repository.UserRepository;
import car_rental_application.demo.dto.CreditCardDto;
import car_rental_application.demo.exception.NoCreditCardException;
import car_rental_application.demo.security.LoggedInUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static car_rental_application.demo.mapper.CreditCardDtoMapper.mapToCreditCard;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PaymentService {

    private final UserRepository userRepository;
    private final CreditCardRepository creditCardRepository;
    private final LoggedInUser loggedInUser;

    public void addCreditCard(CreditCardDto creditCardDto) {

        log.info("Adding credit card to user");
        User user = (User) loggedInUser.getUser();

        if(user.getCreditCard() != null) {

            throw new IllegalCallerException("You Already Have Credit Card!");
        }
        CreditCard card = creditCardRepository.save(mapToCreditCard(creditCardDto));
        user.setCreditCard(card);
         user = loggedInUser.getUser();

        userRepository.save(user);
    }

    public void moneyTransfer(Long moneyAmount) {

        User user = (User) loggedInUser.getUser();

        if(user.getCreditCard() == null) {

            throw new NoCreditCardException("You Do Not Have Credit Card!");

        } else {

            log.info("Transfer for the amount of {}", moneyAmount);
            CreditCard creditCard = user.getCreditCard();
            creditCard.setAccountBalance(creditCard.getAccountBalance() + moneyAmount);
            userRepository.save(user);

        }
    }

}
