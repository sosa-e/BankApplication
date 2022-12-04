import java.util.Scanner;
public class Account {
    static int balance;
    int previousTransaction;
    String customerName, customerID, customerPassword;

    Account(String cName, String cID, String cPass) {
        customerName = cName;
        customerID = cID;
        customerPassword = cPass;
    }
    //Function for depositing money
    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    //Function for withdrawing money
    void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
            if (previousTransaction == -amount) {
                System.out.println("Insufficient funds. Program closing");
                System.exit(0);
            }
        }
    }
    //Function showing the previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0 ) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }
    //Function calculating interest of current funds after a number of years
    void calculateInterest(int years) {
        double interestRate = .01;
        double newBalance = (balance + interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");
        // System.out.println();
        // System.out.println("Please choose a letter");
        do {
            System.out.println();
            System.out.println("Please choose a letter: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("===========================");
                    System.out.println("Balance = $" + balance);
                    if (balance == -balance) {
                        System.out.println("Negative entries are not allowed");
                    }
                    System.out.println("===========================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("===========================");
                    getPreviousTransaction();
                    System.out.println("===========================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("===========================");
                    break;
                default:
                    System.out.println("Error: Invalid option. Please enter A, B, C, D, E, or F.");
                    break;
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with sosaBank!");
        System.exit(0);
    }
}
