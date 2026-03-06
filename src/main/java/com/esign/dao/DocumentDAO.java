package com.esign.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.esign.databaseConnections.DatabaseConfig;

public class DocumentDAO {
    
    public DatabaseConfig connection = new DatabaseConfig();

    public void updateDocumento(String status, String aggrementID)throws IOException, ClassNotFoundException, SQLException 
    {
       /*
        
        String sql = "update solentedb set STATUS = ?  WHERE AGREEMENT_ID = ?";
        try {
            PreparedStatement preparedStmt = connection.GetConnection().prepareStatement(sql);
            preparedStmt.setString(1, status);
            preparedStmt.setString(1, aggrementID);
            preparedStmt.execute(); 
            System.out.println("PREPARED STATEMENT DO DOCUMWENTO" +preparedStmt);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            connection.GetConnection().clearWarnings();
            connection.GetConnection().close();
        }
        */
    }   

}