import common.Country;
import org.junit.Assert;
import salesorder.LineItem;
import salesorder.SalesOrder;
import salesorder.ShippingStrategyFactory;
import salesorder.StandardShippingCost;

public class StandardOrderTest {
    @org.junit.Test
    public void testIsStandard() {
        boolean isStandard;
        SalesOrder koszyk = new SalesOrder();
        koszyk.setDeliveryCountry(Country.POLAND);
        LineItem item1 = new LineItem(1, 1.5, "c", "book");
        koszyk.addItem(item1);
        Assert.assertFalse(isStandardShippingCost(koszyk)); //falsz bo tylko buty w zamowieniu
        LineItem item2 = new LineItem(1, 1.5, "c", "shoes");
        koszyk.addItem(item2);
        Assert.assertTrue(isStandardShippingCost(koszyk));
        LineItem item3 = new LineItem(1000, 15, "c", "shoes");
        koszyk.addItem(item3);
        Assert.assertTrue(isStandardShippingCost(koszyk));
        koszyk.setDeliveryCountry(Country.RUSSIA);
        Assert.assertFalse(isStandardShippingCost(koszyk)); //falsz bo zamowienie poza Polske
    }

    private boolean isStandardShippingCost(SalesOrder koszyk) {
        return ShippingStrategyFactory.createShippingCostStrategy(koszyk) instanceof StandardShippingCost;
    }

}
