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
                        System.out.println();
                        break;
                    case 2 :
                        //view patient
                        patient.viewPatient();
                        System.out.println();
                        break;
                    case 3 :
                        //view Doctors
                        doctor.viewDoctors();
                        System.out.println();
                        break;
                    case 4 :
                        //book appointment
                        bookAppointment(conn,sc,patient,doctor);
                        System.out.println();
                        break;
                    case 5 :
                        //exit
                        System.out.println("Thank you for using Hospital Management System");
                        return;
                    default:
                        System.out.println("Enter valid choice : ");


                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void bookAppointment(Connection conn,Scanner sc,Patient patient,Doctor doctor){
        System.out.print("Enter Patient id : ");
        int patientId = sc.nextInt();

        System.out.print("Enter Doctor id : ");
        int doctorId = sc.nextInt();

        System.out.println("Enter appointment date [yyyy-mm-dd] : ");
        String appointmentDate = sc.next();
        try{

            if (patient.getPatientByID(patientId) && doctor.getDoctorsByID(doctorId)){
                if (checkDoctorAvailability(doctorId,appointmentDate,conn)){
                    String appointmentQuery = "insert into appointments(patient_id,doctor_id,appointment_date) values(?,?,?)";

                    PreparedStatement preparedStatement = conn.prepareStatement(appointmentQuery);
                    preparedStatement.setInt(1,patientId);
                    preparedStatement.setInt(2,doctorId);
                    preparedStatement.setString(3,appointmentDate);

                    int affectedRows = preparedStatement.executeUpdate();
                    if(affectedRows > 0){
                        System.out.println("Appointment Booked");
                    }
                    else {
                        System.out.println("Failed to book Appointment");
                    }
                }
                else {
                    System.out.println("Doctor not available on this date ");
                }
            }
            else {
                System.out.println("Either Doctor or Patient Doesn't Exist : ");
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static boolean checkDoctorAvailability(int doctorId,String appointmentDate,Connection conn){
        String query = "select count(*) from appointments where doctor_id = ? and appointment_date = ?";
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,doctorId);
            preparedStatement.setString(2,appointmentDate);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
               int count = resultSet.getInt(1);
               if (count == 0){
                   return true;
               }
               else {
                   return false;
               }
            }

        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }

        return false;
    }
}