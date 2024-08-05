import java.io.*;
import java.util.Scanner;

public class ViewMarks {
    public static void showMarks(File myFile) throws FileNotFoundException  {
      
        
        Scanner scanner = new Scanner(myFile);


        System.out.println("List of Students and the Obtained Marks:");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
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

                    System.out.println("Name: " + FirstName + " " + LastName + " with Student ID: " + StudentID + " Got Total Marks of: " + TotalMarks + ", Assessment 1: " + A1 + ", Assessment 2: " + A2 + ", Assessment 3: " + A3);
                }
            }

            scanner.close();
        }

    }

