/*
 * Author: Alex Zhou
 * Date: 2018.11.06
 */

import java.util.ArrayList;

public class Supply extends Product
{
	private int lowStock, amount;
	private ArrayList<String> ExDates = new ArrayList<String>();
	
	public Supply(String n, String t, int ls, int a, int y, int m, int d)
	{
		super(n, t);
		setLowStock(ls);
		addExDate(y, m, d);
	}
	
	public Supply(String n, String t, int ls)
	{
		this(n, t, ls, 0, 0, 0, 0);
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
	
	public void setLowStock(int ls)
	{
		lowStock = ls;
	}
	
	public int getLowStock()
	{
		return lowStock;
	}
}