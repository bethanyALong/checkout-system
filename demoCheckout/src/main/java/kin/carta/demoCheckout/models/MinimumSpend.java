package kin.carta.demoCheckout.models;

import java.util.HashMap;
import java.util.Map;

public class MinimumSpend implements Promotion {


    @Override
    public Double applyPromotion(HashMap<String, Integer> listItems, HashMap<ItemEnum, Double> productPrices) {

        double discount = 0.0;
        double price = 0.0;

        for (Map.Entry<String, Integer> entry : listItems.entrySet()) {
            ItemEnum item = ItemEnum.valueOfLabel(entry.getKey());
            Integer numberItems = entry.getValue();
            Double itemPrice = productPrices.get(item);
            price += itemPrice * numberItems;
        }

        if (price >= 75.00) {
            discount = price * 0.1;
            System.out.println("Minimum spend promotion applied");
        }
        return discount;
    }
}