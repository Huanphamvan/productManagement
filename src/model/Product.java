package model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private int type;

    public Product(int id, String name, int quantity, double price, int type) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
    public String getData() {
        return id + "," + name + "," + quantity +"," +  price + "," + type;
    }

}
