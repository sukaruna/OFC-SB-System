/*
 * Author: Alex Zhou
 * Date: 2018.10.29
 */

public class Product
{
	private String name, type;
	private int lowStock, amount;
	
	public Product(String n, String t, int ls, int a)
	{
		name = n;
		type = t;
		lowStock = ls;
		amount = a;
	}
	
	public Product(String n, String t, int ls)
	{
		this(n, t, ls, 0);
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setType(String t)
	{
		type = t;
	}
	
	public void setLowStock(int ls)
	{
		lowStock = ls;
	}
	
	public void setAmount(int a)
	{
		amount = a;
	}
	
	public void addAmount(int aa)
	{
		amount = amount + aa;
	}
	
	public void reduceAmount(int ra)
	{
		amount = amount - ra;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public int getLowStock()
	{
		return lowStock;
	}
	
	public int getAmount()
	{
		return amount;
	}
}
