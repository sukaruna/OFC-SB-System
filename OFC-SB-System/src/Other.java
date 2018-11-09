/*
 * Author: Alex Zhou
 * Date: 2018.10.30
 */

public class Other extends Product
{
	private int lowStock, amount, purchaseUnit, sellingUnit;
	
	public Other(String n, String t, int ls, int a, int pu, int su)
	{
		super(n, t);
	}
	
	public Other(String n, String t, int ls, int pu, int su)
	{
		this(n, t, ls, 0, pu, su);
	}
	
	public void setLowStock(int ls)
	{
		lowStock = ls;
	}
	
	public void setAmoutn(int a)
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
