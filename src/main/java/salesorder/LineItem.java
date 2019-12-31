package salesorder;

public class LineItem {

    private int price;
    private double weight;
    private String name;
    private String type;

    public LineItem(int price, double weight, String name, String type) {
        this.price = price;
        this.weight = weight;
        this.name = name;
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
