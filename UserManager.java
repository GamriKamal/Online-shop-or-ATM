import java.util.ArrayList;
import java.util.Scanner;
public class UserManager extends Products{
    private String nameOfProduct;
    private int uniqueNumberofProduct, ratingofProduct, quantityOfProduct;
    private double priceofProduct;
    public int choiceManager;
    private ArrayList<User> accountsOfManager = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private static UserManager manager;
    public boolean logToAccountManager(String login, int password) {
        setAccountsOfManager();
        for (User user : accountsOfManager) {
            if (user.login.equals(login) && user.password == password) {
                return true;
            } else {
                System.out.println(user.login + " " + user.password);
                return false;
            }
        }
        return false;
    }

    public void operationsOfManager() {
        System.out.println("What do you want to fill?");
        System.out.println("1. Foodstuff / 2. Technic");
        choiceManager = scanner.nextInt();
        switch (choiceManager) {
            case 1:
                getFoodstuff();
                printFoodstuff();
                System.out.println("Enter the name of product:");
                nameOfProduct = scanner.next();
                System.out.println("Enter the unique number of product:");
                uniqueNumberofProduct = scanner.nextInt();
                System.out.println("Enter the price of product:");
                priceofProduct = scanner.nextDouble();
                System.out.println("Enter the rating of product:");
                ratingofProduct = scanner.nextInt();
                System.out.println("Enter the quantity of product");
                quantityOfProduct = scanner.nextInt();
                fillFoodstuff(nameOfProduct, uniqueNumberofProduct, priceofProduct, ratingofProduct, quantityOfProduct);
                printFoodstuff();
                break;

            case 2:
                System.out.println("Enter the name of product:");
                nameOfProduct = scanner.next();
                System.out.println("Enter the unique number of product:");
                uniqueNumberofProduct = scanner.nextInt();
                System.out.println("Enter the price of product:");
                priceofProduct = scanner.nextDouble();
                System.out.println("Enter the rating of product:");
                ratingofProduct = scanner.nextInt();
                System.out.println("Enter the quantity of product");
                quantityOfProduct = scanner.nextInt();
                fillTechnic(nameOfProduct, uniqueNumberofProduct, priceofProduct, ratingofProduct, quantityOfProduct);
                printTechnic();
                break;

            default:
                System.out.println("Invalid operator! Try again!");
                operationsOfManager();
                break;
        }
        System.out.println("Do you want to add another product? Pick 1.");
        System.out.println("If no, pick any number.");
        choiceManager = scanner.nextInt();
        if (choiceManager == 1) {
            operationsOfManager();
        } else {
            System.out.println("Coming out..." + "\n");
        }
    }

    public void setAccountsOfManager() {
        accountsOfManager.add(new User("Pavel", 741));
        accountsOfManager.add(new User("Phoenix", 1336));
        accountsOfManager.add(new User("Pasha", 9632));
        accountsOfManager.add(new User("Alex", 99663321));
    }

    public void addToFoodstuffandTechnic() {
        getFoodstuff();
        foodstuff.put(1, new PricesandRatingOfProduct("Bread", 1.08, 5.00, 5));
        foodstuff.put(2, new PricesandRatingOfProduct("Milk", 2.36, 4.8, 10));
        foodstuff.put(3, new PricesandRatingOfProduct("Cheese", 4.89, 4.3,2));
        foodstuff.put(4, new PricesandRatingOfProduct("Potato", 1.34, 4.1,20));
        foodstuff.put(5, new PricesandRatingOfProduct("Cake", 8.64, 4.9,1));
        getTechnic();
        technic.put(1, new PricesandRatingOfProduct("Iphone 14 pro", 863.74, 4.5, 10));
        technic.put(2, new PricesandRatingOfProduct("Macbook 16 pro", 2214.23, 5.0, 10));
        technic.put(3, new PricesandRatingOfProduct("PC", 2142.03, 4.87, 3));
        technic.put(4, new PricesandRatingOfProduct("Keyboard HyperX", 123.41, 3.89, 17));
        technic.put(5, new PricesandRatingOfProduct("SteelSeries mouse", 79.63, 4.00,13));
    }
    public static UserManager getManager() {
        if (manager == null) {
            manager = new UserManager();
        }
        return manager;
    }
}