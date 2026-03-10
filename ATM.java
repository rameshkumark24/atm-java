import java.util.*;

class ATM {

    static Scanner sc = new Scanner(System.in);

    public static void run() {

        int attempts = 0;

        while (attempts < 3) {

            System.out.println("Enter Account Number:");
            int accountNumber = sc.nextInt();

            System.out.println("Enter PIN:");
            int pin = sc.nextInt();

            Main.User user = Main.authenticate(accountNumber, pin);

            if (user != null) {
                showMenu(user);
                return;
            } else {
                System.out.println("Invalid Account Number or PIN.");
                attempts++;
            }
        }

        System.out.println("Too many failed attempts. Exiting.");
    }

    private static void showMenu(Main.User user) {

        while (true) {

            System.out.println("\n1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance(user);
                    break;
                case 2:
                    withdraw(user);
                    break;
                case 3:
                    deposit(user);
                    break;
                case 4:
                    changePin(user);
                    break;
                case 5:
                    System.out.println("Thank you for using ATM.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void checkBalance(Main.User user) {
        System.out.println("Your balance is: " + user.getBalance());
    }

    private static void withdraw(Main.User user) {

        System.out.println("Enter amount to withdraw:");
        long amount = sc.nextLong();

        if (amount <= 0 || amount % 100 != 0) {
            System.out.println("Invalid amount. Must be multiple of 100.");
            return;
        }

        if (user.withdraw(amount)) {
            System.out.println("Amount Withdrawn Successfully.");
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    private static void deposit(Main.User user) {

        System.out.println("Enter amount to deposit:");
        long amount = sc.nextLong();

        if (amount <= 0 || amount % 100 != 0) {
            System.out.println("Invalid amount. Must be multiple of 100.");
            return;
        }

        user.deposit(amount);
        System.out.println("Amount Deposited Successfully.");
    }

    private static void changePin(Main.User user) {

        System.out.println("Enter new PIN:");
        int newPin = sc.nextInt();

        user.changePin(newPin);
        System.out.println("PIN Changed Successfully.");
    }
}