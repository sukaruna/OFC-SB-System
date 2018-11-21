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
	private JButton homeBtn, searchBtn, expirationBtn, lowStockBtn, addInventoryBtn, editBtn, addProductBtn, deleteBtn;
	
	//constructor
	public InventoryPanel()
	{
		//setting for inventory panel
		inventoryPanel = new JPanel();
		inventoryPanel.setLayout(null);
		
		//a scroll pane with a list of products
		productPane = new JScrollPane();
		productPane.setBounds(10, 70, 500, 400);
		inventoryPanel.add(productPane);
		
		//search bar to search products
		searchTF = new JTextField();
		searchTF.setBounds(10, 20, 300, 33);
		inventoryPanel.add(searchTF);
		
		homeBtn = new JButton("Home");
		homeBtn.setBounds(550, 20, 50, 50);
		homeBtn.addActionListener(this);
		inventoryPanel.add(homeBtn);
		
		//search button to search
		searchBtn = new JButton("Search");
		searchBtn.setBounds(320, 20, 100, 33);
		searchBtn.addActionListener(this);
		inventoryPanel.add(searchBtn);
		
		expirationBtn = new JButton("Expirations");
		expirationBtn.setBounds(520, 90, 120, 33);
		expirationBtn.addActionListener(this);
		inventoryPanel.add(expirationBtn);
		
		lowStockBtn = new JButton("Low-stocks");
		lowStockBtn.setBounds(520, 160, 120, 33);
		lowStockBtn.addActionListener(this);
		inventoryPanel.add(lowStockBtn);
		
		//create a new frame to add inventory to existing products if this button is clicked
		addInventoryBtn = new JButton("Add Inventory");
		addInventoryBtn.setBounds(520, 230, 120, 33);
		addInventoryBtn.addActionListener(this);
		inventoryPanel.add(addInventoryBtn);
		
		//create a new frame to edit the properties of selected product if this button is clicked
		editBtn = new JButton("Edit Product");
		editBtn.setBounds(520, 300, 120, 33);
		editBtn.addActionListener(this);
		inventoryPanel.add(editBtn);
		
		//create a new frame to add a new type of product if this button is clicked
		addProductBtn = new JButton("Add Product");
		addProductBtn.setBounds(520, 370, 120, 33);
		addProductBtn.addActionListener(this);
		inventoryPanel.add(addProductBtn);
		
		//delete selected product from the list
		deleteBtn = new JButton("Delete Product");
		deleteBtn.setBounds(520, 440, 120, 33);
		deleteBtn.addActionListener(this);
		inventoryPanel.add(deleteBtn);
		
		//add the inventory panel to the main frame and pack
		MainFrame.overallFrame.add(inventoryPanel);
		MainFrame.overallFrame.pack();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == homeBtn)
		{
			MainFrame.overallFrame.getContentPane().removeAll();
			MainFrame.overallFrame.repaint();
			new MainPanel();
		}

		if(e.getSource() == expirationBtn)
		{
			new ExpirationFrame();
		}
		
		if(e.getSource() == lowStockBtn)
		{
			new LowStockFrame();
		}
		
		if(e.getSource() == addInventoryBtn)
		{
			//create a new frame to add inventory
			new AddInventoryFrame();
		}
		
		if(e.getSource() == addProductBtn)
		{
			//create a new frame to add new products
			new AddProductFrame();
		}
		
		
	}
}
