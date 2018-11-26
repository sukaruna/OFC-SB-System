/*
 * Author: Alex Zhou
 * Date: 2018.11.07
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDAO
{
	private Connection myConn;
	
	//constructor
	public ProductDAO() throws Exception
	{
		//read properties from the properties file
		Properties props = new Properties();
		props.load(new FileInputStream("config.properties"));
		
		String dbUrl = props.getProperty("dbUrl");
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		//create connection
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
				list.add(temp);
			}
			
			return list;
		}
		finally
		{
			close(mySt, myRs);
		}
	}
	
	private Supply convertRowToSupply(ResultSet myRs) throws SQLException
	{
		int id = myRs.getInt("id");
		String name = myRs.getString("name");
		String type = myRs.getString("type");
		int lowStock = myRs.getInt("low_stock");
		int amount = myRs.getInt("amount");
		String exDates = myRs.getString("expiration_dates");
		
		Supply tempSupply = new Supply(id, name, type, lowStock, amount, exDates);
		return tempSupply;
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException
	{
		if (myRs != null)
		{
			myRs.close();
		}

		if (myStmt != null)
		{
		}
		
		if (myConn != null)
		{
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException
	{
		close(null, myStmt, myRs);		
	}	
}
