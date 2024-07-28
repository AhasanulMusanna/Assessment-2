
/**
 * Assessment 2
 *
 * Ahasanul Kabir Musanna
 * Student ID: 24352976
 */

import java.io.*;
import java.util.Scanner;

public class Assessment2
{
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Your File Name");
        String FileName = scanner.nextLine();
        
        try {
            File myFile = new File(FileName);
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                System.out.println(line);
            }
            myScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }


}
