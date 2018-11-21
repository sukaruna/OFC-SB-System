/*
 * Author: Alex Zhou
 * Date: 2018.11.20
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LowStockFrame extends JFrame implements ActionListener
{
	private JFrame lowStockFrame;
	private JPanel lowStockPanel;
	private JScrollPane lowStockPane;
	private JButton okBtn;
	
	public LowStockFrame()
	{
		lowStockFrame = new JFrame("Low-stocks");
		lowStockFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		lowStockFrame.setPreferredSize(new Dimension(650,500));
		lowStockFrame.setLayout(new BorderLayout());
		lowStockFrame.setResizable(false);
		
		lowStockPanel = new JPanel();
		lowStockPanel.setLayout(null);
		
		lowStockPane = new JScrollPane();
		lowStockPane.setBounds(10, 10, 500, 400);
		lowStockPanel.add(lowStockPane);
		
		okBtn = new JButton("OK");
		okBtn.setBounds(250, 440, 120, 33);
		okBtn.addActionListener(this);
		lowStockPanel.add(okBtn);

		lowStockFrame.add(lowStockPanel);
		lowStockFrame.pack();
		lowStockFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == okBtn)
		{
			lowStockFrame.dispose();
		}
	}
}