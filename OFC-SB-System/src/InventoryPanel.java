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
	private JButton searchBtn, addInventoryBtn, editBtn, addProductBtn, deleteBtn;
	
	public InventoryPanel()
	{
		inventoryPanel = new JPanel();
		inventoryPanel.setLayout(null);
		
		productPane = new JScrollPane();
		productPane.setBounds(10, 70, 500, 400);
		inventoryPanel.add(productPane);
		
		searchTF = new JTextField();
		searchTF.setBounds(10, 20, 300, 33);
		inventoryPanel.add(searchTF);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(320, 20, 100, 33);
		searchBtn.addActionListener(this);
		inventoryPanel.add(searchBtn);
		
		addInventoryBtn = new JButton("Add Inventory");
		addInventoryBtn.setBounds(520, 150, 120, 33);
		addInventoryBtn.addActionListener(this);
		inventoryPanel.add(addInventoryBtn);
		
		editBtn = new JButton("Edit Product");
		editBtn.setBounds(520, 220, 120, 33);
		editBtn.addActionListener(this);
		inventoryPanel.add(editBtn);
		
		addProductBtn = new JButton("Add Product");
		addProductBtn.setBounds(520, 290, 120, 33);
		addProductBtn.addActionListener(this);
		inventoryPanel.add(addProductBtn);
		
		deleteBtn = new JButton("Delete Product");
		deleteBtn.setBounds(520, 360, 120, 33);
		deleteBtn.addActionListener(this);
		inventoryPanel.add(deleteBtn);
		
		MainFrame.overallFrame.add(inventoryPanel);
		MainFrame.overallFrame.pack();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == addProductBtn)
		{
			new AddProductFrame();
		}
	}
}
