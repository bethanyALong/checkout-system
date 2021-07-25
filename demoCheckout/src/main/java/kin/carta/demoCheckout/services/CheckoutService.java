package kin.carta.demoCheckout.services;

import kin.carta.demoCheckout.models.Items;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutService {

    String checkoutBasket(Items items);
}
