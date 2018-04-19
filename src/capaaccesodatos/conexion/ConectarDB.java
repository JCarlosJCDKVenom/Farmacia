package capaaccesodatos.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class ConectarDB {
	private Connection con;
 Statement  sentSQL;
    ResultSet rst;


	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia?zeroDateTimeBehavior=convertToNull","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
			
		}
		
		return connection;
	}

	public ResultSet Consulta(String sql) throws SQLException{
         
         //executeQuery nos sirve solamente para hacer consultas de la base de datos, solo acepta sentencias como SELECT
         // se necesita forzosamente devolver algo, guardar en una variable el resultado de la consulta
        rst=sentSQL.executeQuery(sql);
        
       return rst;
    }
	public String ejecutar(String sql) throws SQLException
	  {
                //executeUpdate nos sirve para hacer UPDATE, INSERT y ese tipo de sentencias que modifican la base de datos
                // no se necesita devolver algo
                 sentSQL.executeUpdate(sql);
                 
	  return "";
	  }
}