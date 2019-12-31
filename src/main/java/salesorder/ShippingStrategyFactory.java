package salesorder;

public class ShippingStrategyFactory {
    public static ShippingCostStrategy createShippingCostStrategy(SalesOrder salesOrder) {
        if(salesOrder.isInternational()) return new InternationalShippingCost(salesOrder);
        if(salesOrder.hasOnlyBooks()) return new BooksPromotionShippingCost(salesOrder);
        return new StandardShippingCost(salesOrder);
    }
}
