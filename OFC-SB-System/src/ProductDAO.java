/*
 * Author: Alex Zhou
 * Date: 2018.11.07
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ProductDAO
{
	private Connection myConn;
	
	public ProductDAO() throws Exception
	{
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		
		String dbUrl = props.getProperty("dbUrl");
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		
		myConn = DriverManager.getConnection(dbUrl, user, password);
	}
}
