import java.util.LinkedHashMap;
import java.util.Map;

public class Products {
    protected Map<Integer, PricesandRatingOfProduct> foodstuff;
    protected Map<Integer, PricesandRatingOfProduct> technic;

    public Map<Integer, PricesandRatingOfProduct> getFoodstuff() {
        if (foodstuff == null) {
            foodstuff = new LinkedHashMap<>();
        }
        return foodstuff;
    }

    public Map<Integer, PricesandRatingOfProduct> getTechnic() {
        if (technic == null) {
            technic = new LinkedHashMap<>();
        }
        return technic;
    }
    public boolean foodstuffisEmpty() {
        getFoodstuff();
        if (foodstuff.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean technicisEmpty() {
        getTechnic();
        if (technic.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void fillFoodstuff(String name, int uniqueNumber, double price, double rating, int quantity) {
        getFoodstuff();
        foodstuff.put(uniqueNumber, new PricesandRatingOfProduct(name, price, rating, quantity));
    }

    public void fillTechnic(String name, int uniqueNumber, double price, double rating, int quantity) {
        getTechnic();
        technic.put(uniqueNumber, new PricesandRatingOfProduct(name, price, rating, quantity));
    }

    public void printFoodstuff() {
        getFoodstuff();
        foodstuff.entrySet().forEach(entry -> {
            System.out.println("\n" + entry.getValue() + "Unique number: " + entry.getKey() + "\n");
        });
    }

    public void printTechnic() {
        getTechnic();
        technic.entrySet().forEach(entry -> {
            System.out.println("\n" + entry.getValue() + "Unique number: " + entry.getKey() + "\n");
        });
    }
}
