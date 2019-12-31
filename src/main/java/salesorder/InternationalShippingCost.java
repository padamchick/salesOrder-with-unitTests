package salesorder;

public class InternationalShippingCost extends ShippingCostStrategy {

    @Override
    public int shippingCost() {
        return internationalShippingCost();
    }

    int internationalShippingCost() {
        if (isTooHeavy()) {
            return 70;
        }
        return 50;
    }

    boolean isTooHeavy() {
        return salesOrder.totalWeight() > 10.0;
    }

    public InternationalShippingCost(SalesOrder salesOrder) {
        super(salesOrder);
    }
}
