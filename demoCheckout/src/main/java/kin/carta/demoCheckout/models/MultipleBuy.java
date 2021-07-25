package kin.carta.demoCheckout.models;

import java.util.HashMap;
import java.util.Map;

public class MultipleBuy implements Promotion {

    @Override
    public Double applyPromotion(HashMap<String, Integer> listItems, HashMap<ItemEnum, Double> productPrices) {

        Double discount = 0.0;
        for (Map.Entry<String, Integer> entry : listItems.entrySet()) {
            ItemEnum item = ItemEnum.valueOfLabel(entry.getKey());
            Integer numberItems = entry.getValue();

            if (item.equals(ItemEnum.WATER_BOTTLE) && numberItems >= 2) {
                discount = ItemEnum.waterBottleDiscount * numberItems;
                productPrices.replace(item, ItemEnum.waterBottleDiscountedPrice);
                System.out.println("Water bottle discount applied");
            }
        }

        return discount;
    }

}
