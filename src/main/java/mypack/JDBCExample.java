
package mypack;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class JDBCExample {
	
	public static String getData(int id) throws Exception{
		String name = null;
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
		try {

			DriverManager.registerDriver(new org.postgresql.Driver());
           	Connection connection = null;
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/testdb", "testuser","");
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from company");
			if(rs.next()){

			String val = rs.getString("name");
			System.out.println("some value"+val);


			}		
		

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}

		
		
		return name;
	}
		
		
	}