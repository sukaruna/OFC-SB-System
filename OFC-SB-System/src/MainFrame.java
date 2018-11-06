/*
 * Autoher: Alex Zhou
 * Date: 2018.10.26
 */

import java.awt.BorderLayout;
import java.awt.Dimension;

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
		overallFrame.setPreferredSize(new Dimension(1300,1000));
		overallFrame.setLayout(new BorderLayout());
		overallFrame.setResizable(false);
		
		new MainPanel();
	}
}
