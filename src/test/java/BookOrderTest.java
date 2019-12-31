import common.Country;
import org.junit.Assert;
import salesorder.LineItem;
import salesorder.SalesOrder;
import salesorder.ShippingStrategyFactory;

public class BookOrderTest {
    @org.junit.Test
    public void testHasOnlyBooks() {
        SalesOrder koszyk = new SalesOrder();
        koszyk.setDeliveryCountry(Country.POLAND);
        LineItem item1 = new LineItem(1, 1.5, "c", "book");
        LineItem item2 = new LineItem(2, 2.5, "b", "book");
        LineItem item3 = new LineItem(3, 4, "c", "book");
        koszyk.addItem(item1);
        koszyk.addItem(item2);
        koszyk.addItem(item3);
        Assert.assertTrue(koszyk.hasOnlyBooks());
        LineItem item4 = new LineItem(4,5,"d","notbook");
        koszyk.addItem(item4);
        Assert.assertFalse(koszyk.hasOnlyBooks());
    }

    @org.junit.Test
    public void testShippingCost() {
        SalesOrder koszyk = new SalesOrder();
        koszyk.setDeliveryCountry(Country.POLAND);
        LineItem item1 = new LineItem(10, 1.5, "c", "book");
        LineItem item2 = new LineItem(50, 2.5, "b", "book");
        LineItem item3 = new LineItem(100, 4, "c", "book");
        koszyk.addItem(item1);
        koszyk.addItem(item2);
        koszyk.addItem(item3);
        Assert.assertEquals(5, ShippingStrategyFactory.createShippingCostStrategy(koszyk).shippingCost());
        LineItem item4 = new LineItem(41,5,"d","book");
        koszyk.addItem(item4);
        Assert.assertEquals(0, ShippingStrategyFactory.createShippingCostStrategy(koszyk).shippingCost());
    }
}
