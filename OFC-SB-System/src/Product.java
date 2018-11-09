/*
 * Author: Alex Zhou
 * Date: 2018.10.29
 */

public class Product
{
	private String name, type;
	
	public Product(String n, String t)
	{
		name = n;
		type = t;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setType(String t)
	{
		type = t;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
}
