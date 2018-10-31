/*
 * Author: Alex Zhou
 * Date: 2018.10.30
 */

import java.util.ArrayList;

public class Food extends Product
{
	private double price, emPrice;
	private int purchaseUnit, sellingUnit;
	private ArrayList<String> ExDates = new ArrayList<String>();
	
	public Food(String n, String t, int ls, int a, double p, double emp, int pu, int su, int y, int m, int d)
	{
		super(n, t, ls, a);
		setPrice(p);
		setEmployeePrice(emp);
		setPurchaseUnit(pu);
		setSellingUnit(su);
		addExDate(y, m, d);
	}
	
	public Food(String n, String t, int ls, double p, int pu, int su)
	{
		this(n, t, ls, 0, p, 0, pu, su, 0, 0, 0);
	}
	
	public void addExDate(int y, int m, int d)
	{
		if(y != 0 && m != 0 && d != 0)
		{
			ExDates.add(y + " " + m + " " + d);
		}
	}
	
	public boolean checkExpiration(int y, int m, int d)
	{
		String[] date = ExDates.get(0).split("\\s+");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		
		if(y == year)
		{
			if(m == month)
			{
				if(d > day)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else if(m < month)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else if(y < year)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void deleteClosestExDate()
	{
		ExDates.remove(0);
	}
	
	public void setPrice(double p)
	{
		price = p;
	}
	
	public void setEmployeePrice(double emp)
	{
		emPrice = emp;
	}
	
	public void setPurchaseUnit(int pu)
	{
		purchaseUnit = pu;
	}
	
	public void setSellingUnit(int su)
	{
		sellingUnit = su;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public double getEmployeePrice()
	{
		return emPrice;
	}
	
	public int getPurchaseUnit()
	{
		return purchaseUnit;
	}
	
	public int getSellingUnit()
	{
		return sellingUnit;
	}
}
