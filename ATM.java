import java.util.*;
class ATM{
    static Scanner sc = new Scanner(System.in);
    public static void run(){
        System.out.println("Enter your PIN:");
        int pin = sc.nextInt();
        int count =0;
        if(Main.user.containsKey(pin)){
            while(true){
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Change PIN");
                System.out.println("5. Exit");
                System.out.println("Choose an option:");
                int choice = sc.nextInt();
                switch(choice){
                    case 1:
                        get_balance(pin);
                        break;
                    case 2:
                        withdraw(pin);
                        break;
                    case 3:
                        deposit(pin);
                        break;
                    case 4:
                        pin = changepin(pin);
                        break;
                    case 5:
                        System.out.println("Thank you for using ATM.");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        }
        else{
            System.out.println("Invalid PIN");
            count++;
            if(count >= 3){
                System.out.println("Too many failed attempts. Exiting.");
                return;
            }
        }
    }
    public static void get_balance(int pin){
        System.out.println("Your balance is: " + Main.user.get(pin));
    }
    public static void withdraw(int pin){
        double balance = Main.user.get(pin);
        System.out.println("Enter the amount to withdraw:");
        double amount = sc.nextDouble();
        if(amount <= 0){
            System.out.println("Invalid Amount.");
            return;
        }
        if(amount % 100 != 0 && amount % 200 != 0 && amount % 500 != 0){
            System.out.println("Amount should be in multiples of 100, 200, or 500.");
            return;
        }
        if(amount > balance){
            System.out.println("Insufficient Balance.");
        }
        else{
            balance -= amount;
            Main.user.put(pin, balance);
            System.out.println("Amount Withdrawn Successfully.");
        }
    }
    public static int changepin(int pin){
        System.out.println("Enter the new PIN:");
        int newpin = sc.nextInt();
        if(Main.user.containsKey(newpin)){
            System.out.println("This PIN is already in use. Change aborted.");
            return pin;
        }
        double balance = Main.user.get(pin);
        Main.user.put(newpin, balance);
        Main.user.remove(pin);
        System.out.println("PIN Changed Successfully.");
        return newpin;
    }
    public static void deposit(int pin){
        System.out.println("Enter the amount to deposit:");
        double amount = sc.nextDouble();
        if(amount <= 0){
            System.out.println("Invalid Amount.");
            return;
        }
        if(amount % 100 != 0){
            System.out.println("Amount should be in multiples of 100, 200, or 500.");
            return;
        }
        double balance = Main.user.get(pin);
        balance += amount;
        Main.user.put(pin, balance);
        System.out.println("Amount Deposited Successfully.");
    }
}