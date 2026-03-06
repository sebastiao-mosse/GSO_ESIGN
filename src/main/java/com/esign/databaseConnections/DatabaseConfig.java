package com.esign.databaseConnections;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig
{
    /* CONEXAO LOCAL*/
    
    public Connection GetConnection () throws IOException, ClassNotFoundException, SQLException 
    {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsodatabase?useTimezone=true&serverTimezone=UTC&useSSL=false","root","root");
        return conn;
    }
    
    
    /*CONEXAO COM O SERVIDOR*/

    /*
public Connection GetConnection () throws IOException, ClassNotFoundException, SQLException 
    {   
        String username="okmUser";
        String password= "rootUser7";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://92.204.134.72:3306/solentedb",username, password);
        return conn;
        
    }
    
    */
    
}
    