package salesorder;

import java.util.ArrayList;
import java.util.List;

public class LineItems {

    private List<LineItem> lineItems;

    public LineItems() {
        this.lineItems = new ArrayList<LineItem>();
    }

    void addItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    public int totalPrice() {
        int totPrice=0;
        for(LineItem items:lineItems) {
            totPrice+=items.getPrice();
        }
        return totPrice;
    }

    public float totalWeight() {
        float totWeight=0;
        for(LineItem items:lineItems) {
            totWeight+=items.getWeight();
        }
        return totWeight;
    }

    public boolean hasOnlyBooks() {
        if(lineItems.isEmpty()) return false;
        for(LineItem item:lineItems) {
            if(item.getType()!="book")
                return false;
        }
        return true;
    }
}
