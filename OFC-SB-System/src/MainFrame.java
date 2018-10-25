/*
 * Autoher: Alex Zhou
 * Date: 2018.10.26
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame
{
	public static JFrame overallFrame;
	
	public static void main(String[] args)
	{
		new MainFrame();
	}
	
	public MainFrame()
	{
		overallFrame = new JFrame("Ottawa Family Cinema Snack Bar System");
		overallFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		overallFrame.setLayout(new BorderLayout());
		
		new MainPanel();
	}
}
