package salesorder;

import common.Country;

public class SalesOrder {

    private LineItems lineItems = new LineItems();
    private Country country;

    public void addItem(LineItem lineItem) {
        lineItems.addItem(lineItem);
    }


    public int totalPrice() {
        return itemPrice() + shippingCost();
    }

    public int itemPrice() {
        return lineItems.totalPrice();
    }

    private int shippingCost() {
        return ShippingStrategyFactory.createShippingCostStrategy(this).shippingCost();
    }

//    private ShippingCostStrategy createShippingCostStrategy() {
//        if (isInternational()) {
//            return new InternationalShippingCost(this);
//        }
//        if (hasOnlyBooks()) {
//            return new BooksPromotionShippingCost(this);
//        }
//        return new StandardShippingCost(this);
//    }

    public double totalWeight() {
        return lineItems.totalWeight();
    }

    public void setDeliveryCountry(Country country) {
        this.country = country;
    }

    public boolean hasOnlyBooks() {
        return lineItems.hasOnlyBooks();
    }

    public boolean isInternational() {
        return !country.equals(Country.POLAND);
    }

    public SalesOrder() {
    }


}
