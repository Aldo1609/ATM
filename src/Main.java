import java.util.Scanner;
import static clases.checkAccount.checkAccount;
import static clases.depositOperation.depositOperation;
import static clases.getBalance.getBalance;
import static clases.updateBalanceInDatabase.updateBalanceInDatabase;
import static clases.withdrawalOperation.withdrawalOperation;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean accountExists = false;
        double balance = 0.0;
        int account_number = 0;
        int option = 0;

        while (!accountExists) {
            System.out.println("Enter your account number: ");

            if (scanner.hasNextInt()) {
                account_number = scanner.nextInt();
                System.out.println("Enter your PIN: ");

                if (scanner.hasNextInt()) {
                    int pin = scanner.nextInt();
                    accountExists = checkAccount(account_number, pin);

                    if (!accountExists) {
                        System.out.println("Account not found or PIN incorrect. Please try again.");
                    } else {
                        balance = getBalance(account_number, pin);
                        System.out.println("Welcome to ATM Bank");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid PIN.");
                    scanner.next();
                }
            } else {
                System.out.println("Invalid input. Please enter a valid account number.");
                scanner.next();
            }
        }

        do {
            System.out.println("============================\n");
            System.out.println("\tWelcome to ATM Bank");
            System.out.println("\nSelect the operation you want");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Check funds");
            System.out.println("4. Exit");
            System.out.println("\n============================\n");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        balance = depositOperation(account_number, balance);
                        updateBalanceInDatabase(account_number, balance);
                        System.out.println("New balance: " + balance);
                        break;
                    case 2:
                        balance = withdrawalOperation(account_number, balance);
                        updateBalanceInDatabase(account_number, balance);
                        System.out.println("New balance: " + balance);
                        break;
                    case 3:
                        System.out.println("Your balance is: " + balance);
                        break;
                    case 4:
                        System.out.println("Exiting ATM. Thank you!");
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid option (integer).");
                scanner.next();
            }

        } while (option != 4);
    }
}
