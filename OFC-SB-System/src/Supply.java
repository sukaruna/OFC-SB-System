/*
 * Author: Alex Zhou
 * Date: 2018.11.06
 */

public class Supply extends Product
{
	private int lowStock, amount;
	private String exDates;
	
	public Supply(int id, String n, String t, int ls, int a, String ed)
	{
		super(id, n, t);
		setLowStock(ls);
		setAmount(a);
		setExDates(ed);
	}
	
	public Supply(int id, String n, String t, int ls)
	{
		this(id, n, t, ls, 0, "");
	}
	
	public void addAmount(int a)
	{
		amount += a;
	}
	
	public void addExDate(int y, int m, int d)
	{
		if(y != 0 && m != 0 && d != 0)
		{
			exDates += y + " " + m + " " + d + "&";
		}
	}
	
	public boolean checkExpiration(int y, int m, int d)
	{
		String[] date = exDates.substring(exDates.indexOf("&")).split("\\s+");
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
		exDates = exDates.substring(exDates.indexOf("&") + 1);
	}
	
	public void setAmount(int a)
	{
		amount = a;
	}
	
	public void setLowStock(int ls)
	{
		lowStock = ls;
	}
	
	public void setExDates(String ed)
	{
		exDates = ed;
	}
	
	public int getAmount()
	{
		return amount;
	}
	
	public int getLowStock()
	{
		return lowStock;
	}
	
	public String getExDates()
	{
		return exDates;
	}
}
