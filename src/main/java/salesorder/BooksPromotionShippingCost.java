package salesorder;

public class BooksPromotionShippingCost extends ShippingCostStrategy {
    public BooksPromotionShippingCost(SalesOrder salesOrder) {
        super(salesOrder);
    }

    @Override
    public int shippingCost() {
        return booksPromotion();
    }

    int booksPromotion() {
        if (isEligibleForBooksPromo())
            return 0;
        return 5;
    }

    boolean isEligibleForBooksPromo() {
        return salesOrder.itemPrice() > 200;
    }
}
