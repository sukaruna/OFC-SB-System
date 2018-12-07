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
	
	public void addSupply(Supply theSupply) throws SQLException
	{
		PreparedStatement myPpSt = null;
		
		try
		{
			myPpSt = myConn.prepareStatement("INSERT INTO Supply (name, type, low_stock, amount, expiration_dates) VALUES (?, ?, ?, ?, ?)");
			
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
	
	public void addMenu(Menu theMenu) throws SQLException
	{
		PreparedStatement myPpSt = null;
		
		try
		{
			myPpSt = myConn.prepareStatement("INSERT INTO Menu (name, type, category, material, price, employee_price, sold) VALUES (?, ?, ?, ?, ?, ?, ?)");
			
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
	
	public void addOther(Other theOther) throws SQLException
	{
		PreparedStatement myPpSt = null;
		
		try
		{
			myPpSt = myConn.prepareStatement("INSERT INTO Other (name, type, low_stock, amount) VALUES (?, ?, ?, ?)");
			
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
	
	public void updateSupply(Supply theSupply) throws SQLException
	{
		PreparedStatement myPpSt = null;
		
		try
		{
			myPpSt = myConn.prepareStatement("UPDATE Supply SET name=?, low_stock=?, amount=?, expiration_dates=? WHERE id=?");
			
			myPpSt.setString(1, theSupply.getName());
			myPpSt.setInt(2, theSupply.getLowStock());
			myPpSt.setInt(3, theSupply.getAmount());
			myPpSt.setString(4, theSupply.getExDates());
			myPpSt.setInt(5, theSupply.getID());
			
			myPpSt.executeUpdate();
		}
		finally
		{
			close(myPpSt);
		}
	}
	
	public void updateMenu(Menu theMenu) throws SQLException
	{
		PreparedStatement myPpSt = null;
		
		try
		{
			myPpSt = myConn.prepareStatement("UPDATE Supply SET name=?, category=?, material=?, price=?, employee_price=?, sold=? WHERE id=?");
			
			myPpSt.setString(1, theMenu.getName());
			myPpSt.setString(2, theMenu.getCategory());
			myPpSt.setString(3, theMenu.getMaterial());
			myPpSt.setDouble(4, theMenu.getPrice());
			myPpSt.setDouble(5, theMenu.getEmployeePrice());
			myPpSt.setInt(6, theMenu.getSold());
			myPpSt.setInt(7, theMenu.getID());
			
			myPpSt.executeUpdate();
		}
		finally
		{
			close(myPpSt);
		}
	}
	
	public void updateOther(Other theOther) throws SQLException
	{
		PreparedStatement myPpSt = null;
		
		try
		{
			myPpSt = myConn.prepareStatement("UPDATE Supply SET name=?, low_stock=?, amount=? WHERE id=?");
			
			myPpSt.setString(1, theOther.getName());
			myPpSt.setInt(2, theOther.getLowStock());
			myPpSt.setInt(3, theOther.getAmount());
			myPpSt.setInt(4, theOther.getID());
			
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
			myRs = mySt.executeQuery("SELECT * FROM Supply");
			
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
	
	public List<Menu> getAllMenus() throws SQLException
	{
		List<Menu> list = new ArrayList<>();
		
		Statement mySt = null;
		ResultSet myRs = null;
		
		try
		{
			mySt = myConn.createStatement();
			myRs = mySt.executeQuery("SELECT * FROM Menu");
			
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
	
	public List<Other> getAllOthers() throws SQLException
	{
		List<Other> list = new ArrayList<>();
		
		Statement mySt = null;
		ResultSet myRs = null;
		
		try
		{
			mySt = myConn.createStatement();
			myRs = mySt.executeQuery("SELECT * FROM Other");
			
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
	
	public String[] getSupplyNames() throws SQLException
	{
		List<String> list = new ArrayList<>();
		list.add("");
		
		Statement mySt = null;
		ResultSet myRs = null;
		
		try
		{
			mySt = myConn.createStatement();
			myRs = mySt.executeQuery("SELECT * FROM Supply");
			
			while(myRs.next())
			{
				Other temp = convertRowToOther(myRs);
				list.add(temp.getName());
			}
			
			String[] names = new String[list.size()];
			names = list.toArray(names);
			
			return names;
		}
		finally
		{
			close(mySt, myRs);
		}
	}
	
	public List<Supply> getLowStockSupplies() throws SQLException
	{
		List<Supply> list = new ArrayList<>();
		
		Statement mySt = null;
		ResultSet myRs = null;
		
		try
		{
			mySt = myConn.createStatement();
			myRs = mySt.executeQuery("SELECT * FROM Supply WHERE amount > low_stock");
			
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
	
	public List<Other> getLowStockOthers() throws SQLException
	{
		List<Other> list = new ArrayList<>();
		
		Statement mySt = null;
		ResultSet myRs = null;
		
		try
		{
			mySt = myConn.createStatement();
			myRs = mySt.executeQuery("SELECT * FROM Other WHERE amount > low_stock");
			
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
	
	public List<Supply> searchSupply(String name) throws SQLException
	{
		List<Supply> list = new ArrayList<>();
		PreparedStatement myPpSt = null;
		ResultSet myRs = null;
		
		try
		{
			name += "%";
			
			myPpSt = myConn.prepareStatement("SELECT * FROM Supply WHERE name LIKE ? ORDER BY name");
			
			myPpSt.setString(1, name);
			
			myRs = myPpSt.executeQuery();
			
			while(myRs.next())
			{
				Supply temp = convertRowToSupply(myRs);
				list.add(temp);
			}
			
			return list;
		}
		finally
		{
			close(myPpSt, myRs);
		}
	}
	
	public List<Menu> searchMenu(String name) throws SQLException
	{
		List<Menu> list = new ArrayList<>();
		PreparedStatement myPpSt = null;
		ResultSet myRs = null;
		
		try
		{
			name += "%";
			
			myPpSt = myConn.prepareStatement("SELECT * FROM Menu WHERE name LIKE ? ORDER BY name");
			
			myPpSt.setString(1, name);
			
			myRs = myPpSt.executeQuery();
			
			while(myRs.next())
			{
				Menu temp = convertRowToMenu(myRs);
				list.add(temp);
			}
			
			return list;
		}
		finally
		{
			close(myPpSt, myRs);
		}
	}
	
	public List<Other> searchOther(String name) throws SQLException
	{
		List<Other> list = new ArrayList<>();
		PreparedStatement myPpSt = null;
		ResultSet myRs = null;
		
		try
		{
			name += "%";
			
			myPpSt = myConn.prepareStatement("SELECT * FROM Other WHERE name LIKE ? ORDER BY name");
			
			myPpSt.setString(1, name);
			
			myRs = myPpSt.executeQuery();
			
			while(myRs.next())
			{
				Other temp = convertRowToOther(myRs);
				list.add(temp);
			}
			
			return list;
		}
		finally
		{
			close(myPpSt, myRs);
		}
	}
	
	public void decreaseInventory(Menu theMenu) throws SQLException
	{
		PreparedStatement myPpSt = null;
		String[] materials = theMenu.getMaterial().split("&");
		
		try
		{
			for(int i = 0; i < materials.length; i++)
			{
				List<Supply> temp = searchSupply(materials[i]);
				int id = temp.get(0).getID();
				myPpSt = myConn.prepareStatement("UPDATE Supply SET amount=amount-1 WHERE id=?");
				myPpSt.setInt(1, id);
				myPpSt.executeUpdate();
			}
		}
		finally
		{
			close(myPpSt);
		}
	}
	
	public void deleteProduct(String type, int id) throws SQLException
	{
		PreparedStatement myPpSt = null;
		Statement mySt = null;
		
		try
		{
			myPpSt = myConn.prepareStatement("DELETE FROM " + type + " WHERE id=?");
			myPpSt.setInt(1, id);
			myPpSt.executeUpdate();
			
			mySt = myConn.createStatement();
			mySt.execute("ALTER TABLE " + type + " DROP id");
			mySt.execute("ALTER TABLE " + type + " ADD id INT NOT NULL AUTO_INCREMENT PRIMARY KEY");
		}
		finally
		{
			close(myPpSt);
			close(mySt);
		}
	}
	
	public int getLastID(String type) throws SQLException
	{
		int lastID = 0;
		Statement mySt = null;
		ResultSet myRs = null;
		
		try
		{
			mySt = myConn.createStatement();
			myRs = mySt.executeQuery("SELECT * FROM " + type);
			
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
