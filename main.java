import java.util.*;
class Main {
    static class User{
        int pin;
        double balance;
        User(int pin, double balance){
            this.pin = pin;
            this.balance = balance;
        }
    }
    static HashMap<Integer, User> users = new HashMap<>();
    static Integer getAccountByPin(int pin) {
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            if (entry.getValue().pin == pin) {
                return entry.getKey();
            }
        }
        return null;
    }
    public static void main(String[] args) {
        users.put(1001, new User(1234, 1000.00));
        users.put(1002, new User(5678, 500.00));
        ATM.run();
    }
}
