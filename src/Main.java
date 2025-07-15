import javax.print.Doc;
import java.sql.*;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    public static final String url = "jdbc:mysql://localhost:3306/hospital_sys";
    public static final String user = "root";
    public static final String pass = "root";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            Patient patient = new Patient(sc,conn);
            Doctor doctor = new Doctor(conn);

            while (true){
                System.out.println("**** HOSPITAL MANAGEMENT SYSTEM ****");
                System.out.println();
                System.out.println("1. Add patient");
                System.out.println("2. View patient");
                System.out.println("3. View Doctor");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");
                System.out.print("Enter any choice : ");
                int ch = sc.nextInt();

                switch (ch){
                    case 1 :
                        patient.addPatient();
                        break;
                    case 2 :
                        //view patient
                        patient.viewPatient();
                        break;
                    case 3 :
                        //view Doctors
                        doctor.viewDoctors();
                        break;
                    case 4 :
                        //book appointment
                        break;
                    case 5 :
                        //exit
                        return;
                    default:
                        System.out.println("Enter valid choice : ");


                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void bookAppointment(Connection conn){
        String sql = "insert into "
    }
}