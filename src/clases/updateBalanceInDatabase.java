package clases;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Nota: No se utiliza 'public' aquí
public class updateBalanceInDatabase {
    public static void updateBalanceInDatabase(int accountNumber, double newBalance) {
        try {
            File databaseFile = new File("C:\\Users\\user\\IdeaProjects\\ATM\\src\\database.txt");
            Scanner fileScanner = new Scanner(databaseFile);
            StringBuilder newContents = new StringBuilder();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                int storedAccountNumber = Integer.parseInt(parts[0]);

                if (accountNumber == storedAccountNumber) {
                    // Actualizar el saldo en esta línea
                    parts[2] = String.valueOf(newBalance);
                }

                newContents.append(String.join(",", parts)).append("\n");
            }

            fileScanner.close();

            // Escribir el nuevo contenido en el archivo
            FileWriter fileWriter = new FileWriter(databaseFile);
            fileWriter.write(newContents.toString());
            fileWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
