/**
 * Assessment 2
 *
 * Ahasanul Kabir Musanna
 * Student ID: 24352976
 */

import java.io.*;
import java.util.Scanner;


public class Assessment2 {
    public static void main(String[] args) {
      
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Your File Name");
        String FileName = scanner.nextLine();
        File myFile = new File(FileName);

        try {
            while (true) {
                System.out.println("1. View Marks\n2. Filter Students by Minimum Mark\n3. View Top 5 Students\n4. View Bottom 5 Students\n5. Exit the Program");
                System.out.println("Enter Your Choice:");
                int menu = scanner.nextInt();
                scanner.nextLine();
                
                switch (menu) {
                    case 1:
                        ViewMarks.showMarks(myFile);
                        break;
                    case 2:
                        FilterStudents.filterMarks(scanner, myFile);
                        break;
                    case 3:
                        SortandFilter.sortMarks(myFile, "Top 5");
                        break;
                    case 4:
                        SortandFilter.sortMarks(myFile, "Bottom 5");
                        break;
                    case 5:
                        System.out.println("You have successfully exited the program");
                        return;
                    default:
                    System.out.println("Invalid Choice. Please Enter a Valid Choice");
                    break;
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
        catch (NumberFormatException e) {
            System.out.println("Error in File Format");
            e.printStackTrace();
        }
        scanner.close();
        }
        }


