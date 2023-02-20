public class User {
    protected String login;
    protected int password;
    protected double balance;

    public User(String login, int password, double balance) {
        this.login = login;
        this.password = password;
        this.balance = balance;
    }

    public User(String login, int password) {
        this.login = login;
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "Login: " + login + "\n" + "Password: " + password + "\n" + "Balance: " + balance + "\n";
    }
}
