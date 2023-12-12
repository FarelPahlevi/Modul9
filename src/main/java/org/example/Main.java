package example;
import java.sql.*;


public class Main {
    public static void main(String[] args) {
        Connection connect = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_java",
                    "root",
                    ""
            );
            System.out.println("Database Connected");

            statement = connect.createStatement();
//                String createTableSQL = "CREATE TABLE users ("
//                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
//                    + "nama VARCHAR(50),"
//                    + "umur INT)";
            String insertSQL = "INSERT INTO users (nama, umur) VALUES (?, ?)";
            preparedStatement = connect.prepareStatement(insertSQL);

//            preparedStatement.setInt(0, 1);
            preparedStatement.setString(1, "PAIJO");
            preparedStatement.setInt(2, 80);

            preparedStatement.executeUpdate();
            System.out.println("Data Ditambahkan");

//            statement.execute(createTableSQL);
            System.out.println("Table Created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}