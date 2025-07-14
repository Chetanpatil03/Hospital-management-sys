import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Patient {
    private Connection connection;
    private Scanner sc;

    public Patient(Scanner sc, Connection connection) {
        this.sc = sc;
        this.connection = connection;
    }

    public void addPatient(){
        System.out.print("Enter Patient name : ");
        String name = sc.next();
        System.out.print("Enter Patient age : ");
        int age = sc.nextInt();
        System.out.print("Enter Patient gender : ");
        String gender = sc.next();

        try {
            String sql = "insert into patient(name,age,gender) values (?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,gender);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0){
                System.out.println("Data inserted ");
            }
            else {
                System.out.println("Failed to insert data");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
