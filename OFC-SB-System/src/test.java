import java.util.ArrayList;

public class test
{
	public static void main(String[] args)
	{
		ProductDAO dao = null;
		try {
			dao = new ProductDAO();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int a = 0;
		try {
			a = dao.getLastID("Supply");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a);
	}
}
