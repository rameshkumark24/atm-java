import java.util.*;
class ATM{
    static Scanner sc = new Scanner(System.in);
    public static void run(){
        int count = 0;
        while(count < 3){
            System.out.println("Enter your PIN:");
            int pin = sc.nextInt();
            Integer account = Main.getAccountByPin(pin);
            if(account != null){
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
                            get_balance(account);
                            break;
                        case 2:
                            withdraw(account);
                            break;
                        case 3:
                            deposit(account);
                            break;
                        case 4:
                            changepin(account);
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
    }
    private static void get_balance(int account){
        System.out.println("Your balance is: " + Main.users.get(account).balance);
    }
    private static void withdraw(int account){
        double balance = Main.users.get(account).balance;
        System.out.println("Enter the amount to withdraw:");
        double amount = sc.nextDouble();
        if(amount <= 0){
            System.out.println("Invalid Amount.");
            return;
        }
        if(amount % 100 != 0){
            System.out.println("Amount should be in multiples of 100, 200, or 500.");
            return;
        }
        if(amount > balance){
            System.out.println("Insufficient Balance.");
        }
        else{
            balance -= amount;
            Main.users.get(account).balance = balance;
            System.out.println("Amount Withdrawn Successfully.");
        }
    }
    private static void changepin(int account){
        System.out.println("Enter the new PIN:");
        int newpin = sc.nextInt();
        Main.users.get(account).pin = newpin;
        System.out.println("PIN Changed Successfully.");
    }
    private static void deposit(int account){
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
        double balance = Main.users.get(account).balance;
        balance += amount;
        Main.users.get(account).balance = balance;
        System.out.println("Amount Deposited Successfully.");
    }
}