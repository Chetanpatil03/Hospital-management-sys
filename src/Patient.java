import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                System.out.println("Patient added Successfully...");
            }
            else {
                System.out.println("Failed to add patient...");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewPatient(){
        String sql = "select * from patient";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Patients : \n");
            System.out.println("+----------+------------------+-----------+------------+");
            System.out.println("|    Id    |       Name       |    age    |   Gender   |");
            System.out.println("+----------+------------------+-----------+------------+");

            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");

                System.out.printf("|%-11d|%-19s|%-12d|%-13s|\n",id,name,age,gender);

            }
            System.out.println("+----------+------------------+-----------+------------+");

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
