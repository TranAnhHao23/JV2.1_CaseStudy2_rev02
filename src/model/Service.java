package model;

public class Service {
    private String name;
    private double price;
    private int quantity;

    public Service() {
    }

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Service{" +
                "name = " + name +
                ", price = " + price +
//                ", quantity = " + quantity +
                " }";
    }

    public String displayQuantity() {
        return "Service{" +
                "name = " + name +
                ", price = " + price +
                ", quantity = " + quantity +
                " }";

    }
}
