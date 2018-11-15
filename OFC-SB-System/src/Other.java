/*
 * Author: Alex Zhou
 * Date: 2018.10.30
 */

public class Other extends Product
{
	private int lowStock, amount;
	
	public Other(int id, String n, String t, int ls, int a)
	{
		super(id, n, t);
		setLowStock(ls);
		setAmount(a);
	}
	
	public Other(int id, String n, String t, int ls)
	{
		this(id, n, t, ls, 0);
	}
	
	public void setLowStock(int ls)
	{
		lowStock = ls;
	}
	
	public void setAmount(int a)
	{
		amount = a;
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
