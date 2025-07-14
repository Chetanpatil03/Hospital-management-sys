import java.sql.Connection;
import java.util.Scanner;

public class Patient {
    private Connection connection;
    private Scanner sc;

    public Patient(Scanner sc, Connection connection) {
        this.sc = sc;
        this.connection = connection;
    }

    
}
