/*
 * Author: Alex Zhou
 * Date: 2018.10.26
 */

import java.awt.Font;
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
		Font buttonFont = new Font("Arial", Font.PLAIN, 23);
		
		mainMenuPanel = new JPanel();
		mainMenuPanel.setLayout(null);
		
		cashButton = new JButton("Cash System");
		cashButton.setBounds(225, 220, 200, 65);
		cashButton.setFont(buttonFont);
		cashButton.setIcon(buttonImage);
		cashButton.setHorizontalTextPosition(JButton.CENTER);
		cashButton.setVerticalTextPosition(JButton.CENTER);
		cashButton.setContentAreaFilled(false);
		cashButton.setBorderPainted(false);
		cashButton.addActionListener(this);
		mainMenuPanel.add(cashButton);
		
		inventoryButton = new JButton("Inventory System");
		inventoryButton.setBounds(225, 300, 200, 65);
		inventoryButton.setFont(buttonFont);
		inventoryButton.setIcon(buttonImage);
		inventoryButton.setHorizontalTextPosition(JButton.CENTER);
		inventoryButton.setVerticalTextPosition(JButton.CENTER);
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
