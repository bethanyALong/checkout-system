package kin.carta.demoCheckout.models;

import java.util.HashMap;

public interface Promotion {

    Double applyPromotion(HashMap<String, Integer> listItems, HashMap<ItemEnum, Double> productPrices);

}
