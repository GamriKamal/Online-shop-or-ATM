import java.util.ArrayList;
import java.util.Scanner;

public class UserConsumer extends Basket{
    protected static ArrayList<User> accountsOfConsumers = new ArrayList<>();
    public int choiceConsumer;
    private int passwordUser;
    private String loginUser;
    Scanner scanner = new Scanner(System.in);
    UserManager manager = UserManager.getManager();
    public boolean logToAccountConsumer(String login, int password) {
        passwordUser = password;
        loginUser = login;
        setAccountsOfConsumers();
        for (User accountsOfConsumer : accountsOfConsumers) {
            if (accountsOfConsumer.login.equals(login) && accountsOfConsumer.password == password) {
                return true;
            } else {
                System.out.println(accountsOfConsumer.login + " " + accountsOfConsumer.password);
                return false;
            }
        }
        return false;
    }

    public void operationsOfConsumer() {
        int choice, uniqueNumber, quantity;
        System.out.println("What do you want to buy?");
        System.out.println("1. Foodstuff / 2. Technic");
        choiceConsumer = scanner.nextInt();
        switch (choiceConsumer) {
            case 1:
                manager.addToFoodstuffandTechnic();
                if (manager.foodstuffisEmpty()) {
                    System.out.println("There are no foodstuff in stock now. Come back later");
                } else {
                    manager.printFoodstuff();
                    System.out.println("Do you want to put the product in the cart? Pick 1");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter the unique number of you product:");
                            uniqueNumber = scanner.nextInt();
                            System.out.println("Enter the quantity of you product:");
                            quantity = scanner.nextInt();
                            if (quantity <= manager.foodstuff.get(uniqueNumber).quantity) {
                                for (int i = quantity; i > 0; i--) {
                                    setproductInBasket(manager.foodstuff.get(uniqueNumber));
                                    manager.foodstuff.get(uniqueNumber).quantity--;
                                    isProductInBasket(manager.foodstuff.get(uniqueNumber));
                                }
                            } else {
                                System.out.println("Now the store has" + manager.foodstuff.get(uniqueNumber).name + " in quantity: " + manager.foodstuff.get(uniqueNumber).quantity);
                            }
                        }
                    }
                    continueAction();
                }
                break;

            case 2:
                manager.addToFoodstuffandTechnic();
                if (manager.technicisEmpty()) {
                    System.out.println("There are no technic in stock now. Come back later");
                } else {
                    manager.printTechnic();
                    System.out.println("Do you want to put the product in the cart? Pick 1");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter the unique number of you product:");
                            uniqueNumber = scanner.nextInt();
                            System.out.println("Enter the quantity of you product:");
                            quantity = scanner.nextInt();
                            if (quantity <= manager.foodstuff.get(uniqueNumber).quantity) {
                                for (int i = quantity; i > 0; i--) {
                                    setproductInBasket(manager.technic.get(uniqueNumber));
                                    manager.technic.get(uniqueNumber).quantity--;
                                    isProductInBasket(manager.technic.get(uniqueNumber));
                                }
                            } else {
                                System.out.println("Now the store has" + manager.technic.get(uniqueNumber).name + " in quantity: " + manager.technic.get(uniqueNumber).quantity);
                            }
                        }
                    }
                    continueAction();
                }
                break;

            default:
                System.out.println("Invalid operator! Try again");
                operationsOfConsumer();
                break;
        }
    }
    public void continueAction(){
        int index;
        System.out.println("1. Do you want to take another product? / 2. Do you want to delete product from basket? / 3. Do you want to proceed to payment?");
        System.out.println("Pick 1, 2 or 3");
        choiceConsumer = scanner.nextInt();
        switch (choiceConsumer) {
            case 1:
                operationsOfConsumer();
                break;

            case 2:
                printBasket();
                System.out.println("What do you want to delete?");
                System.out.println("Enter the position number of the product:");
                index = scanner.nextInt();
                deleteItem(index);
                printBasket();
                continueAction();
                break;

            case 3:
                if (isBasketEmpty()) {
                    System.out.println("Your basket is empty");
                    System.out.println("Coming out..." + "\n");
                } else {
                    System.out.println("Enter your login again:");
                    loginUser = scanner.next();
                    for (User accountsOfConsumers : accountsOfConsumers) {
                        if(accountsOfConsumers.login.equals(loginUser)) {
                            User user = new User(accountsOfConsumers.login, accountsOfConsumers.password, accountsOfConsumers.balance);
                            goToPayment(user);
                        }
                    }

                }
                break;

            default:
                System.out.println("Invalid operator!");
                continueAction();
        }
    }
    public void setAccountsOfConsumers() {
        accountsOfConsumers.add(new User("Sasha", 1111, 250000));
        accountsOfConsumers.add(new User("Pavel", 2345, 13450));
        accountsOfConsumers.add(new User("Anton", 1337, 35897));

    }

    public void setAccountsOfConsumers(String login, int password, double balance) {
        accountsOfConsumers.add(new User(login, password, balance));
    }

}
