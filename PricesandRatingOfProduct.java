public class PricesandRatingOfProduct {
    protected String name;
    protected double price;
    protected double rating;
    protected int quantity;
    public PricesandRatingOfProduct(String name, double price, double rating, int quantity) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Name of product: " + name + "\n" + "Price of product: " + price + "\n" + "Rating of product: " + rating + "\n" + "Quantity of product: " + quantity + "\n";
    }
}
