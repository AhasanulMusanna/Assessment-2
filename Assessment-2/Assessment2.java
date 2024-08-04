/**
 * Assessment 2
 *
 * Ahasanul Kabir Musanna
 * Student ID: 24352976
 */

import java.io.*;
import java.util.Scanner;

class Student {
    String FirstName;
    String LastName;
    String StudentID;
    double A1;
    double A2;
    double A3;
    double TotalMarks;

    Student(String FirstName, String LastName, String StudentID, double A1, double A2, double A3) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.StudentID = StudentID;
        this.A1 = A1;
        this.A2 = A2;
        this.A3 = A3;
        this.TotalMarks = A1 + A2 + A3;
    }
}

public class Assessment2 {
    public static void main(String[] args) {
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

            myScanner.close();

            // Filter and Print
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

            // Sort and Filter Students
            
            scanner = new Scanner(System.in);
            
            while (true) {
            
            System.out.println("Sort and Filter Top 5 or Bottom 5 Students. Write 'Top 5' to view Top 5 Students, 'Bottom 5' to view Bottom 5 Students, 'exit' to quit the program");
            String Sort = scanner.nextLine();
            
            
            Student[] Top5Students = new Student[5];
            Student[] Bottom5Students = new Student[5];

            myScanner = new Scanner(myFile);
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

                    Student student = new Student(FirstName, LastName, StudentID, A1, A2, A3);

                    for (int i = 0; i < 5; i++) {
                        if (Top5Students[i] == null || student.TotalMarks > Top5Students[i].TotalMarks) {
                            for (int j = 4; j > i; j--) {
                                Top5Students[j] = Top5Students[j - 1];
                            }
                            Top5Students[i] = student;
                            break;
                        }
                    }

                    for (int i = 0; i < 5; i++) {
                        if (Bottom5Students[i] == null || student.TotalMarks < Bottom5Students[i].TotalMarks) {
                            for (int j = 4; j > i; j--) {
                                Bottom5Students[j] = Bottom5Students[j - 1];
                            }
                            Bottom5Students[i] = student;
                            break;
                        }
                    }
                }
            }

            myScanner.close();
            
            
            if (Sort.equals("Top 5")) {
            System.out.println("Top 5 Students:");
            for (Student student : Top5Students) {
                if (student != null) {
                    System.out.println("Name: " + student.FirstName + " " + student.LastName + ", Student ID: " + student.StudentID + ", Total Marks: " + student.TotalMarks);
                }
            }
        }
        
        else if (Sort.equals("Bottom 5")) {
            System.out.println("Bottom 5 Students:");
            for (Student student : Bottom5Students) {
                if (student != null) {
                    System.out.println("Name: " + student.FirstName + " " + student.LastName + ", Student ID: " + student.StudentID + ", Total Marks: " + student.TotalMarks);
                }
            }
            
        }
        
        else if (Sort.equals("Exit")) {
            System.out.println("You have successfully exited the program");
            break;
        }
        
        else {
            System.out.println("Invalid Input. Please enter 'Top 5' or 'Bottom 5' in the field");
        }
        
        } 
        
    }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        } 
        
        catch (NumberFormatException e) {
            System.out.println("No record found.");
            e.printStackTrace();
        } 
        
    }
}
