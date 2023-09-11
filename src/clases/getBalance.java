package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class getBalance {
    public static double getBalance(int accountNumber, int pin) {
        try {
            File databaseFile = new File("C:\\Users\\user\\IdeaProjects\\ATM\\src\\database.txt");
            Scanner fileScanner = new Scanner(databaseFile);

            // Omitir la primera línea (encabezado)
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine(); // Leer y descartar la primera línea
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                int storedAccountNumber = Integer.parseInt(parts[0]);
                int storedPin = Integer.parseInt(parts[1]);
                double balance = Double.parseDouble(parts[2]);

                if (accountNumber == storedAccountNumber && pin == storedPin) {
                    fileScanner.close();
                    return balance;
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return -1.0; // Valor predeterminado si no se encuentra la cuenta o el PIN es incorrecto
    }
}
