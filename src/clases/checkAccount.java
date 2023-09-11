package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class checkAccount {
    public static boolean checkAccount(int accountNumber, int pin){
        try{
            File databaseFile = new File("C:\\Users\\user\\IdeaProjects\\ATM\\src\\database.txt");
            Scanner fileScanner = new Scanner(databaseFile);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                int storedAccountNumber = Integer.parseInt(parts[0]);
                int storedPin = Integer.parseInt(parts[1]);

                if (accountNumber == storedAccountNumber && pin == storedPin) {
                    fileScanner.close();
                    return true;
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }




}

