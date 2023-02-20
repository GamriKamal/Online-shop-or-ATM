import java.util.ArrayList;

public class Basket {
    public double sumOfbasket;
    ArrayList<PricesandRatingOfProduct> productInBasket = new ArrayList<PricesandRatingOfProduct>();
    public void setproductInBasket(PricesandRatingOfProduct obj) {
        productInBasket.add(obj);
    }
    public void printBasket() {
        for (int i = 0; i < productInBasket.size(); i++) {
            System.out.println(productInBasket.get(i) + "Num: " + i + "\n");
        }
    }

    public boolean isBasketEmpty(){
        if(productInBasket.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    public void isProductInBasket(PricesandRatingOfProduct obj) {
        if (productInBasket.contains(obj)) {
            System.out.println("Success! Your product is in the Basket!");
        } else {
            System.out.println("Some mistakes have been made and your product has not been added to the basket.");
        }
    }
    public void deleteItem(int uniqueNumber){
        productInBasket.remove(uniqueNumber);
    }
    public void goToPayment(User user) {
        double total;
        System.out.println("Here is your basket: ");
        printBasket();
        for (PricesandRatingOfProduct obj : productInBasket) {
            sumOfbasket += obj.getPrice();
        }
        System.out.println("Total: " + sumOfbasket);
            if (user.getBalance() > sumOfbasket) {
                try {
                    System.out.println("A transaction is going through...");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                total = user.getBalance() - sumOfbasket;
                user.setBalance(total);
                System.out.println("");
                System.out.println("The operation was successful! Thanks for the purchase!");
            } else {
                System.out.println("Your balance is less than the purchase amount, please top up the balance!");
            }
    }
}
