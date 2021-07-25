package kin.carta.demoCheckout.services;

import kin.carta.demoCheckout.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Override
    public String checkoutBasket(Items items) {
        ArrayList<Promotion> promotionalRules = new ArrayList<>();
        String response;
        promotionalRules.add(new MultipleBuy());
        promotionalRules.add(new MinimumSpend());

        Checkout checkout = new Checkout(promotionalRules);

        try {
            checkout.scan(items);
            response = "£" + checkout.total();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            response = e.getMessage();
        }
        return response;
    }
}
