package salesorder;

public class StandardShippingCost extends ShippingCostStrategy {
    public StandardShippingCost(SalesOrder salesOrder) {
        super(salesOrder);
    }

    @Override
    public int shippingCost() {
        return standardShippingCost();
    }

    int standardShippingCost() {
        return 15;
    }
}
