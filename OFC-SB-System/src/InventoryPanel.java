/*
 * Author: Alex Zhou
 * Date: 2018.10.26
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class InventoryPanel implements ActionListener
{
	private JScrollPane productPane;
	private JTextField searchTF;
	private JPanel inventoryPanel;
	private JButton searchBtn, addInventoryBtn;
	
	public InventoryPanel()
	{
		inventoryPanel = new JPanel();
		inventoryPanel.setLayout(null);
		
		productPane = new JScrollPane();
		productPane.setBounds(20, 70, 400, 400);
		inventoryPanel.add(productPane);
		
		searchTF = new JTextField();
		searchTF.setBounds(20, 20, 300, 33);
		inventoryPanel.add(searchTF);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(350, 20, 100, 33);
		searchBtn.addActionListener(this);
		inventoryPanel.add(searchBtn);
		
		addInventoryBtn = new JButton("Add Inventory");
		addInventoryBtn.setBounds(500, 200, 100, 33);
		addInventoryBtn.addActionListener(this);
		inventoryPanel.add(addInventoryBtn);
		
		MainFrame.overallFrame.add(inventoryPanel);
		MainFrame.overallFrame.pack();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
