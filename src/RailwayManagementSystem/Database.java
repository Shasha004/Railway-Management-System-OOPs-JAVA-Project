package RailwayManagementSystem;

import java.sql.*;

public class Database {
    private String user="root";
    private String pass="";
    private String url="jdbc:mysql://localhost:3307/railway management system";
    private Statement statement;
    public Database() throws SQLException {
        Connection connection= DriverManager.getConnection(url,user,pass);
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    public Statement getStatement(){
        return statement;
    }
}
