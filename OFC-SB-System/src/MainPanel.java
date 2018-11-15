/*
 * Author: Alex Zhou
 * Date: 2018.10.26
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel implements ActionListener
{
	private JLabel titleLabel;
	private JPanel mainMenuPanel;
	private JButton cashBtn, inventoryBtn;
	private ImageIcon buttonImage;
	
	public MainPanel()
	{
		buttonImage = new ImageIcon("Image/button.png");
		Font buttonFont = new Font("Arial", Font.PLAIN, 23);
		
		mainMenuPanel = new JPanel();
		mainMenuPanel.setLayout(null);
		
		titleLabel = new JLabel("Ottawa Family Cinema Snack Bar");
		titleLabel.setOpaque(true);
		titleLabel.setBounds(0, 0, 650, 100);
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 43));
		titleLabel.setBackground(Color.CYAN);
		mainMenuPanel.add(titleLabel);
		
		cashBtn = new JButton("Cash System");
		cashBtn.setBounds(225, 220, 200, 65);
		cashBtn.setFont(buttonFont);
		cashBtn.setIcon(buttonImage);
		cashBtn.setHorizontalTextPosition(JButton.CENTER);
		cashBtn.setVerticalTextPosition(JButton.CENTER);
		cashBtn.setContentAreaFilled(false);
		cashBtn.setBorderPainted(false);
		cashBtn.addActionListener(this);
		mainMenuPanel.add(cashBtn);
		
		inventoryBtn = new JButton("Inventory System");
		inventoryBtn.setBounds(225, 300, 200, 65);
		inventoryBtn.setFont(buttonFont);
		inventoryBtn.setIcon(buttonImage);
		inventoryBtn.setHorizontalTextPosition(JButton.CENTER);
		inventoryBtn.setVerticalTextPosition(JButton.CENTER);
		inventoryBtn.setContentAreaFilled(false);
		inventoryBtn.setBorderPainted(false);
		inventoryBtn.addActionListener(this);
		mainMenuPanel.add(inventoryBtn);
		
		MainFrame.overallFrame.add(mainMenuPanel);
		MainFrame.overallFrame.pack();
		MainFrame.overallFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == inventoryBtn)
		{
			MainFrame.overallFrame.getContentPane().removeAll();
			MainFrame.overallFrame.repaint();
			new InventoryPanel();
		}
		
		if(e.getSource() == cashBtn)
		{
			
		}
	}
}
