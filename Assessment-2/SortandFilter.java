import java.io.*;
import java.util.Scanner;

public class SortandFilter {
    public static void sortMarks(File myFile, String Sort) throws FileNotFoundException {
        
            Scanner myScanner = new Scanner(myFile);
            
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
        
 
    }
}