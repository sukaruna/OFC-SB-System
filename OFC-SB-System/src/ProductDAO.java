/*
 * Author: Alex Zhou
 * Date: 2018.11.07
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	public void addSupply(Supply theSupply) throws Exception
	{
		PreparedStatement myPpSt = null;
		
		try
		{
			myPpSt = myConn.prepareStatement("insert into Supply"
					+ " (name, type, low_stock, amount, expiration_dates)"
					+ " values (?, ?, ?, ?, ?)");
			
			myPpSt.setString(1, theSupply.getName());
			myPpSt.setString(2, theSupply.getType());
			myPpSt.setInt(3, theSupply.getLowStock());
			myPpSt.setInt(4, theSupply.getAmount());
			myPpSt.setString(5, theSupply.getExDates());
			
			myPpSt.executeUpdate();
		}
		finally
		{
			close(myPpSt);
		}
	}
	
	public void addMenu(Menu theMenu) throws Exception
	{
		PreparedStatement myPpSt = null;
		
		try
		{
			myPpSt = myConn.prepareStatement("insert into Menu"
					+ " (name, type, category, material, price, employee_price, sold)"
					+ " values (?, ?, ?, ?, ?, ?, ?)");
			
			myPpSt.setString(1, theMenu.getName());
			myPpSt.setString(2, theMenu.getType());
			myPpSt.setString(3, theMenu.getCategory());
			myPpSt.setString(4, theMenu.getMaterial());
			myPpSt.setDouble(5, theMenu.getPrice());
			myPpSt.setDouble(6, theMenu.getEmployeePrice());
			myPpSt.setInt(7, theMenu.getSold());
			
			myPpSt.executeUpdate();
		}
		finally
		{
			close(myPpSt);
		}
	}
	
	public void addOther(Other theOther) throws Exception
	{
		PreparedStatement myPpSt = null;
		
		try
		{
			myPpSt = myConn.prepareStatement("insert into Other"
					+ " (name, type, low_stock, amount)"
					+ " values (?, ?, ?, ?)");
			
			myPpSt.setString(1, theOther.getName());
			myPpSt.setString(2, theOther.getType());
			myPpSt.setInt(3, theOther.getLowStock());
			myPpSt.setInt(4, theOther.getAmount());
			
			myPpSt.executeUpdate();
		}
		finally
		{
			close(myPpSt);
		}
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
	
	public List<Menu> getAllMenus() throws Exception
	{
		List<Menu> list = new ArrayList<>();
		
		Statement mySt = null;
		ResultSet myRs = null;
		
		try
		{
			mySt = myConn.createStatement();
			myRs = mySt.executeQuery("select * from Menu");
			
			while(myRs.next())
			{
				Menu temp = convertRowToMenu(myRs);
				list.add(temp);
			}
			
			return list;
		}
		finally
		{
			close(mySt, myRs);
		}
	}
	
	public List<Other> getAllOthers() throws Exception
	{
		List<Other> list = new ArrayList<>();
		
		Statement mySt = null;
		ResultSet myRs = null;
		
		try
		{
			mySt = myConn.createStatement();
			myRs = mySt.executeQuery("select * from Other");
			
			while(myRs.next())
			{
				Other temp = convertRowToOther(myRs);
				list.add(temp);
			}
			
			return list;
		}
		finally
		{
			close(mySt, myRs);
		}
	}
	
	public void deleteProduct(String type, int id) throws SQLException
	{
		PreparedStatement myPpSt = null;
		
		try
		{
			myPpSt = myConn.prepareStatement("delete from " + type + " where id=?");
			myPpSt.setInt(1, id);
			myPpSt.executeUpdate();
		}
		finally
		{
			close(myPpSt);
		}
	}
	
	public int getLastID(String type) throws Exception
	{
		int lastID = 0;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try
		{
			mySt = myConn.createStatement();
			myRs = mySt.executeQuery("select * from " + type);
			
			while(myRs.next())
			{
				lastID++;
			}
			
			return lastID;
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
	
	private Menu convertRowToMenu(ResultSet myRs) throws SQLException
	{
		int id = myRs.getInt("id");
		String name = myRs.getString("name");
		String type = myRs.getString("type");
		String category = myRs.getString("category");
		String material = myRs.getString("material");
		double price = myRs.getDouble("price");
		double emPrice = myRs.getDouble("employee_price");
		int sold = myRs.getInt("sold");
		
		Menu tempMenu = new Menu(id, name, type, category, material, price, emPrice, sold);
		return tempMenu;
	}
	
	private Other convertRowToOther(ResultSet myRs) throws SQLException
	{
		int id = myRs.getInt("id");
		String name = myRs.getString("name");
		String type = myRs.getString("type");
		int lowStock = myRs.getInt("low_stock");
		int amount = myRs.getInt("amount");
		
		Other tempOther = new Other(id, name, type, lowStock, amount);
		return tempOther;
	}
	
	private void close(Connection myConn, Statement mySt, ResultSet myRs) throws SQLException
	{
		if (myRs != null)
		{
			myRs.close();
		}

		if (mySt != null)
		{
			mySt.close();
		}
		
		if (myConn != null)
		{
			myConn.close();
		}
	}

	private void close(Statement mySt, ResultSet myRs) throws SQLException
	{
		close(null, mySt, myRs);		
	}
	
	private void close(Statement mySt) throws SQLException
	{
		close(null, mySt, null);
	}
}
