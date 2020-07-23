package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager{
	
	public static Properties loadPropertiesFile() throws IOException {
		Properties prop = new Properties();	
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
	
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		
		Properties prop= new Properties();
		prop = loadPropertiesFile();
		final String driver = prop.getProperty("driver");
		final String url = prop.getProperty("url");
		final String username = prop.getProperty("username");
		final String password = prop.getProperty("password");
			
					System.out.println(driver);
					System.out.println(url);
					System.out.println(username);
					System.out.println(password);
			
			 Class.forName(driver);
			 Connection con;
			 con=DriverManager.getConnection(url,username,password);
			 
			 return con;
	}
}
