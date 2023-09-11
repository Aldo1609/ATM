package clases;
import java.util.Scanner;

public class depositOperation {
    public static double depositOperation(int accountNumber, double currentBalance) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much money do you want to deposit: ");
        double depositAmount = scanner.nextDouble();

        // Verificar que el monto de depósito sea válido (positivo)
        if (depositAmount <= 0) {
            System.out.println("Invalid deposit amount.");
            return currentBalance;
        }

        // Realizar el depósito y actualizar el saldo
        double newBalance = currentBalance + depositAmount;
        System.out.println("Deposit successful.");
        return newBalance;
    }
}

