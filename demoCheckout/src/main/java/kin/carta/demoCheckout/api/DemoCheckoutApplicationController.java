package kin.carta.demoCheckout.api;

import kin.carta.demoCheckout.models.Items;
import kin.carta.demoCheckout.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoCheckoutApplicationController {

    @Autowired
    CheckoutService checkoutService;


    @PostMapping(path = "/purchase", consumes = "application/json")
    public ResponseEntity<String> purchase(@RequestBody Items list){
        String price = checkoutService.checkoutBasket(list);
        ResponseEntity<String> response = new ResponseEntity<String>(price, HttpStatus.OK);
        return response;
    }
}
