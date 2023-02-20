import java.util.Scanner;
public class ATMOperations{
    UserManager manager = UserManager.getManager();
    UserConsumer consumer = new UserConsumer();
    Scanner scanner = new Scanner(System.in);
    String login;
    int choice, password;
    double balance;
    public void runATM(){
        System.out.println("Hello, you got into Online Magnum!");
        System.out.println("If you have an account, pick 1.");
        System.out.println("If you don't have an account, pick 2.");
        System.out.println("If you want to go, pick 3.");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                break;

            case 2:
                System.out.println("Enter your login:");
                login = scanner.next();
                System.out.println("Enter your password");
                password = scanner.nextInt();
                System.out.println("Enter your balance");
                balance = scanner.nextDouble();
                consumer.setAccountsOfConsumers(login, password, balance);
                consumer.setAccountsOfConsumers();
                break;

            case 3:
                return;

            default:
                System.out.println("Invalid operator! Try again!");
                runATM();
        }

        System.out.println("You're consumer or manager?");
        System.out.println("1. Consumer / 2. Manager");

        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter your login:");
                login = scanner.next();
                System.out.println("Enter your password");
                password = scanner.nextInt();
                if (consumer.logToAccountConsumer(login, password)) {
                    consumer.operationsOfConsumer();
                }
                break;

            case 2:
                System.out.println("Enter your login:");
                login = scanner.next();
                System.out.println("Enter your password");
                password = scanner.nextInt();
                if (manager.logToAccountManager(login, password)) {
                    manager.operationsOfManager();
                    System.out.println("");
                    System.out.println("Before:");
                    manager.printFoodstuff();
                    runATM();
                }
                break;

            default:
                System.out.println("Invalid operator!");
                break;
        }
    }
}