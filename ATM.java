import java.util.*;
class ATM{
    public static void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your PIN:");
        int pin = sc.nextInt();
        if(main.user.containsKey(pin)){
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
                        pin = changepin(pin); // update session PIN
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
        }
    }
    public static void get_balance(int pin){
        if(!main.user.containsKey(pin)){
            System.out.println("Invalid PIN. Unable to check balance.");
            return;
        }
        System.out.println("Your balance is: " + main.user.get(pin));
    }
    public static void withdraw(int pin){
        if(!main.user.containsKey(pin)){
            System.out.println("Invalid PIN. Cannot withdraw.");
            return;
        }
        double balance = main.user.get(pin);
        System.out.println("Enter the amount to withdraw:");
        Scanner sc = new Scanner(System.in);
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
            main.user.put(pin, balance);
            System.out.println("Amount Withdrawn Successfully.");
        }
    }
    public static int changepin(int pin){
        System.out.println("Enter the new PIN:");
        Scanner sc = new Scanner(System.in);
        int newpin = sc.nextInt();
        if(main.user.containsKey(newpin)){
            System.out.println("This PIN is already in use. Change aborted.");
            return pin;
        }
        double balance = main.user.get(pin);
        main.user.put(newpin, balance);
        main.user.remove(pin);
        System.out.println("PIN Changed Successfully.");
        return newpin; // return updated PIN for the running session
    }
    public static void deposit(int pin){
        if(!main.user.containsKey(pin)){
            System.out.println("Invalid PIN. Cannot deposit.");
            return;
        }
        System.out.println("Enter the amount to deposit:");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        if(amount <= 0){
            System.out.println("Invalid Amount.");
            return;
        }
        if(amount % 100 != 0 && amount % 200 != 0 && amount % 500 != 0){
            System.out.println("Amount should be in multiples of 100, 200, or 500.");
            return;
        }
        double balance = main.user.get(pin);
        balance += amount;
        main.user.put(pin, balance);
        System.out.println("Amount Deposited Successfully.");
    }
}