package kin.carta.demoCheckout.models;

public enum ItemEnum {

    WATER_BOTTLE("0001", 24.95),
    HOODIE("0002", 65.00),
    STICKER_SET("0003", 3.99);

    public Double price;
    public String code;

    public static Double waterBottleDiscount = 1.96;
    public static Double waterBottleDiscountedPrice = 22.99;


    ItemEnum(String code, Double price) {
        this.code = code;
        this.price = price;

    }

    public static ItemEnum valueOfLabel(String label) {
        for (ItemEnum e : values()) {
            if (e.code.equals(label)) {
                return e;
            }
        }
        return null;
    }
}
