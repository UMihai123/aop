package dbConnection;

import java.sql.*;
public class DbConnection {
    static final String connectionString = "jdbc:mysql://localhost:3306/pao";
    static final String username = "root";
    static final String password = "parola123";
    private Connection conn;

    public DbConnection(){
        openConnection();
    }

    public void openConnection(){
        try{
            conn = DriverManager.getConnection(connectionString, username, password);
        }
        catch(SQLException error){
            error.printStackTrace();
            conn = null;
        }
    }

    public boolean isNull(){
        return conn == null;
    }

    public ResultSet executeStatement(String query){
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(query);
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void executeInsert(String query){
        try{
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
