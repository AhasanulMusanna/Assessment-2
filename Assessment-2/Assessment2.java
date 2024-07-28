
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
            System.out.println("List of Students and the Obtained Marks:");
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                if (line.contains("Last Name") || line.contains("ID") || line.contains("Unit")) {
                    continue;
                }
                
                String[] columns = line.split(",");
                if (columns.length == 6) {
                    String LastName = columns[0];
                    String FirstName = columns[1];
                    String StudentID = columns[2];
                    
                    if (columns[3].isEmpty()) {
                        continue;
                    }
                        
                    double A1 = Double.parseDouble(columns[3]);
                    
                    if (columns[4].isEmpty()) {
                        continue;
                    }
                    
                    double A2 = Double.parseDouble(columns[4]);
                    
                    if (columns[5].isEmpty()) {
                        continue;
                    }
                    
                    double A3 = Double.parseDouble(columns[5]);
                    
                    double TotalMarks = A1 + A2 + A3;
                    
                
                    System.out.println("Name: " + FirstName + " " + LastName + " with " + "Student ID: " + StudentID + " Got Total Marks of: " + TotalMarks + ", Assessment 1: " + A1 + ", Assessment 2: " + A2 + ", Assessment 3: " + A3 );
                

                }
            }
            
            myScanner.close();
            
            //Filter and Print
            System.out.println("Enter the Minimum Mark");
            double MinimumMarks = scanner.nextDouble();
            
            myScanner = new Scanner(myFile);
            System.out.println("List of Students Below " + MinimumMarks);
            
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                
                if (line.contains("Last Name") || line.contains("ID") || line.contains("Unit")) {
                    continue;
                }
                
                String[] columns = line.split(",");
                if (columns.length == 6) {
                    String LastName = columns[0];
                    String FirstName = columns[1];
                    String StudentID = columns[2];
                    
                    if (columns[3].isEmpty()) {
                        continue;
                    }
                    
                    double A1 = Double.parseDouble(columns[3]);
                    
                    if (columns[4].isEmpty()) {
                        continue;
                    }
                    
                    double A2 = Double.parseDouble(columns[4]);
                    
                    if (columns[5].isEmpty()) {
                        continue;
                    }
                    
                    double A3 = Double.parseDouble(columns[5]);
                    
                    double TotalMarks = A1 + A2 + A3;
                    
                    if (TotalMarks < MinimumMarks) {
                        System.out.println("Name: " + FirstName + " " + LastName + " with Studnet ID: " + StudentID + " Got Total Marks of: " + TotalMarks);
                        
                    }
                }
            
                
                
                
            }

            
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        catch (NumberFormatException e) {
            System.out.println("No record found");
            e.printStackTrace();
        }
        

    }    


}