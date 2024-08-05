public class Student {
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
