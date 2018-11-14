/*
 * Description: the Menu porttion
 * Author: Suveatha 
 * Date: Nov. 6 2018
 */

public class Menu extends Product
{
	private double price, employeePrice;
	private int sold;
	
	public Menu(int id, String n, String t, double d, double e, int s) 
	{
		super(id, n, t);
		setPrice(d);
		setEmployeePrice(e);
		setSold(s);
	}
	
	public Menu(int id, String n, String t, double p, int s) 
	{
		this(id, n, t, p, 0, s);
	}

	private void setEmployeePrice(double ep) 
	{
		employeePrice = ep;
	}

	private void setPrice(double p) 
	{
		price = p;
	}
	
	private void setSold(int s)
	{
		sold = s;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public double getEmployeePrice()
	{
		return employeePrice;
	}
	
	public int getSold()
	{
		return sold;
	}
}