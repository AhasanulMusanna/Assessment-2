import java.io.*;
import java.util.Scanner;

public class FilterStudents {

    public static void filterMarks(Scanner scanner, File myFile) throws FileNotFoundException {

           
            System.out.println("Enter the Minimum Mark");
            double MinimumMarks = scanner.nextDouble();
            scanner.nextLine();

            Scanner myScanner = new Scanner(myFile);
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

                    if (columns[3].isEmpty() || columns[4].isEmpty() || columns[5].isEmpty()) {
                        continue;
                    }

                    double A1 = Double.parseDouble(columns[3]); 
                    double A2 = Double.parseDouble(columns[4]);
                    double A3 = Double.parseDouble(columns[5]);
                    double TotalMarks = A1 + A2 + A3;

                    if (TotalMarks < MinimumMarks) {
                        System.out.println("Name: " + FirstName + " " + LastName + " with Student ID: " + StudentID + " Got Total Marks of: " + TotalMarks);
                    }
                }
            }

            myScanner.close();
        } 
        
        }


