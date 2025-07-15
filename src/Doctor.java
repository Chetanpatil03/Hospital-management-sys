import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
    private Connection connection;

    public Doctor(Connection connection) {
        this.connection = connection;
    }


    public void viewDoctors(){
        String sql = "select * from doctors";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Doctors : \n");
            System.out.println("+-----------------+------------------------------+-----------------------+");
            System.out.println("|    Doctor Id    |          Doctor Name         |     Specialization    |");
            System.out.println("+-----------------+------------------------------+-----------------------+");

            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");

                System.out.printf("|%-18d|%-31s|%-23s|\n",id,name,specialization);

            }
            System.out.println("+-----------------+------------------------------+-----------------------+");

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean getDoctorsByID(int id){
        String sql = "SELECT * FROM doctors WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return true;
            }
            else {
                return false;
            }


        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }
    


}
