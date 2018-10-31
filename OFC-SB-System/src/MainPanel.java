/*
 * Author: Alex Zhou
 * Date: 2018.10.26
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel implements ActionListener
{
	private JPanel mainMenuPanel;
	private JButton cashButton, inventoryButton;
	private ImageIcon buttonImage;
	
	public MainPanel()
	{
		buttonImage = new ImageIcon("Image/button.png");
		
		mainMenuPanel = new JPanel();
		mainMenuPanel.setPreferredSize(new Dimension(650,500));
		
		cashButton = new JButton("Cash System");
		mainMenuPanel.add(cashButton);
		
		inventoryButton = new JButton("Inventory System");
		inventoryButton.setIcon(buttonImage);
		inventoryButton.setHorizontalTextPosition(JButton.CENTER);
		inventoryButton.setVerticalTextPosition(JButton.CENTER);
		inventoryButton.setOpaque(false);
		inventoryButton.setContentAreaFilled(false);
		inventoryButton.setBorderPainted(false);
		inventoryButton.addActionListener(this);
		mainMenuPanel.add(inventoryButton);
		
		MainFrame.overallFrame.add(mainMenuPanel);
		MainFrame.overallFrame.pack();
		MainFrame.overallFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == inventoryButton)
		{
			MainFrame.overallFrame.getContentPane().removeAll();
			MainFrame.overallFrame.repaint();
			new InventoryPanel();
		}
	}
}
