
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    protected Connection conexion;
    //JDBC dirver npmbre y base de datos URL
    private static final String JDBC_DRIVER = "com.mysql.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ejemplo";
    
    //credenciales de la Base de datos
    private static final String USER = "root";
    private static final String PASS = "";

    public void conectar() throws Exception{
        try {
            conexion = DriverManager.getConnection(DB_URL,USER,PASS);
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void cerrar() throws SQLException{
        if(conexion != null){
            if(!conexion.isClosed() ){
                conexion.close();
            }
        } 
    }
    
    
}
