package kin.carta.demoCheckout.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Checkout {

    ArrayList<Promotion> promotionalRules;
    Double price = 0.0;
    HashMap<String, Integer> listItems = new HashMap<>();
    HashMap<ItemEnum, Double> productPrices = new HashMap<>();

    public Checkout(ArrayList<Promotion> promotionalRules){
        this.promotionalRules = promotionalRules;
    }

    public void scan(Items list) throws Exception{
        String[] items = list.items;

        if (items != null) {
            for (String item : list.getItems()){
                if (listItems.containsKey(item)){
                    Integer numberItems = listItems.get(item);
                    listItems.put(item, numberItems + 1);
                } else {
                    listItems.put(item, 1);
                }}
                for (Map.Entry<String, Integer> entry : listItems.entrySet()){
                    ItemEnum itemEnum = ItemEnum.valueOfLabel(entry.getKey());
                    if (itemEnum == null){
                        String exceptionMessage = "Item code x does not match specifications".replace("x", entry.getKey());
                        throw new Exception(exceptionMessage);
                    }
                    Integer numberItems = entry.getValue();
                    double priceItems = itemEnum.price * numberItems;
                    price += priceItems;
                    productPrices.put(itemEnum, itemEnum.price);
                }
            } else {
            throw new Exception("Item list must not be empty");
        }
    }


    public Double total(){
        if (price > 0) {
            for (Promotion promotion : promotionalRules) {
                price = price - promotion.applyPromotion(listItems, productPrices);
            }
        }
        BigDecimal bdUp = new BigDecimal(price).setScale(2, RoundingMode.HALF_DOWN);
        price = bdUp.doubleValue();
        listItems.clear();
        productPrices.clear();
        return price;
    }
}
