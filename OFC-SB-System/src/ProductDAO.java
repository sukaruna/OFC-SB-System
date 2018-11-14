/*
 * Author: Alex Zhou
 * Date: 2018.11.07
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
	
	public List<Supply> getAllSupplies() throws Exception
	{
		List<Supply> list = new ArrayList<>();
		
		Statement mySt = null;
		ResultSet myRs = null;
		
		try
		{
			mySt = myConn.createStatement();
			myRs = mySt.executeQuery("select * from Supply");
			
			while(myRs.next())
			{
				Supply temp = convertRowToSupply(myRs);
			}
			
			return list;
		}
		finally
		{
			
		}
	}
	
	private Supply convertRowToSupply(ResultSet myRs) throws Exception
	{
		
	}
}
