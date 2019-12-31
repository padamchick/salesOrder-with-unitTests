import common.Country;
import org.junit.Assert;
import salesorder.LineItem;
import salesorder.SalesOrder;
import salesorder.ShippingStrategyFactory;

public class InternationalOrderTest {
    @org.junit.Test
    public void testIsInternational() {
        SalesOrder koszyk = new SalesOrder();
        koszyk.setDeliveryCountry(Country.POLAND);
        Assert.assertFalse(koszyk.isInternational());
        koszyk.setDeliveryCountry(Country.SWEDEN);
        Assert.assertTrue(koszyk.isInternational());
    }

    @org.junit.Test
    public void testShippingCost() {
        SalesOrder koszyk = new SalesOrder();
        koszyk.setDeliveryCountry(Country.SWEDEN);
        LineItem item1 = new LineItem(10, 1.5, "c", "book");
        koszyk.addItem(item1);
        Assert.assertEquals(50, ShippingStrategyFactory.createShippingCostStrategy(koszyk).shippingCost());
        LineItem item2 = new LineItem(10, 8.5, "c", "book");
        koszyk.addItem(item2);
        Assert.assertEquals(50, ShippingStrategyFactory.createShippingCostStrategy(koszyk).shippingCost());
        LineItem item3 = new LineItem(41,0.01,"d","book");
        koszyk.addItem(item3);
        Assert.assertEquals(70, ShippingStrategyFactory.createShippingCostStrategy(koszyk).shippingCost());
    }
}

