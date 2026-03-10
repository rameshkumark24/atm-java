import java.util.*;

class Main {

    // Fully encapsulated User class
    static class User {
        private int pin;
        private long balance;

        User(int pin, long balance) {
            this.pin = pin;
            this.balance = balance;
        }

        public boolean validatePin(int inputPin) {
            return this.pin == inputPin;
        }

        public long getBalance() {
            return balance;
        }

        public boolean withdraw(long amount) {
            if (amount > balance) return false;
            balance -= amount;
            return true;
        }

        public void deposit(long amount) {
            balance += amount;
        }

        public void changePin(int newPin) {
            this.pin = newPin;
        }
    }

    // AccountNumber -> User
    static HashMap<Integer, User> users = new HashMap<>();

    // Login using account number + PIN (better design)
    static User authenticate(int accountNumber, int pin) {
        if (users.containsKey(accountNumber)) {
            User user = users.get(accountNumber);
            if (user.validatePin(pin)) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        users.put(1001, new User(1234, 1000));
        users.put(1002, new User(5678, 500));
        ATM.run();
    }
}