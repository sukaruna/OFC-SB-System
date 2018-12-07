import java.sql.SQLException;
import java.util.Arrays;

public class test
{
	public static void main(String[] args)
	{
		Menu temp = new Menu(0, "me", "Menu", "Hotdog", "Hotdogs&Buns&Box", 0);
		ProductDAO dao;
		try {
			dao = new ProductDAO();
			dao.decreaseInventory(temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
