/*
 * Author: Alex Zhou
 * Date: 2018.10.30
 */

public class Other extends Product
{
	private int purchaseUnit, sellingUnit;
	
	public Other(String n, String t, int ls, int a, int pu, int su)
	{
		super(n, t, ls, a);
		setPurchaseUnit(pu);
		setSellingUnit(su);
	}
	
	public Other(String n, String t, int ls, int pu, int su)
	{
		this(n, t, ls, 0, pu, su);
	}
	
	public void setPurchaseUnit(int pu)
	{
		purchaseUnit = pu;
	}
	
	public void setSellingUnit(int su)
	{
		sellingUnit = su;
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
