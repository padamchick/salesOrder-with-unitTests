package salesorder;
import common.Country;

public class Main {
    public static void main(String[] args) {
        LineItem but = new LineItem(10, 1.5, "Air Max", "book");
        LineItem but2 = new LineItem(15, 2.5, "Air Janoski", "book");
        LineItem but3 = new LineItem(100, 4,"chuj wie", "book");

        SalesOrder koszyk = new SalesOrder();
        koszyk.setDeliveryCountry(Country.POLAND);
        koszyk.addItem(but);
        koszyk.addItem(but2);
        koszyk.addItem(but3);
        System.out.println("Total price: "+koszyk.totalPrice()+" zl");
        System.out.println("Total weight: "+koszyk.totalWeight()+" kg");
    }
}
