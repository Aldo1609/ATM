package clases;

import java.util.Scanner;

public class withdrawalOperation {
    public static double withdrawalOperation(int accountNumber, double currentBalance) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much money do you want to withdrawal: ");
        double withdrawalAmount = scanner.nextDouble();


        if (withdrawalAmount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return currentBalance;

        } else if (withdrawalAmount > currentBalance) {
            System.out.println("Insufficient funds");
            return currentBalance;
        }

        double newBalance = currentBalance - withdrawalAmount;
        System.out.println("Withdrawal successful.");
        return newBalance;
    }
}
