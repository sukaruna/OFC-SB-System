/*
 * Author: Alex Zhou
 * Date: 2018.10.26
 */

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class InventoryPanel implements ActionListener
{
	private ProductDAO dao;
	private JScrollPane supplyPane, menuPane, otherPane;
	private JTable supplyTable;
	private JTextField searchTF;
	private JPanel inventoryPanel, switchPanel;
	private JButton homeBtn, searchBtn, expirationBtn, lowStockBtn, addInventoryBtn, editBtn, addProductBtn, deleteBtn, supplyBtn, menuBtn, otherBtn;
	
	//constructor
	public InventoryPanel() throws Exception
	{
		try
		{
			dao = new ProductDAO();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
		//setting for inventory panel
		inventoryPanel = new JPanel();
		inventoryPanel.setLayout(null);
		
		switchPanel = new JPanel();
		switchPanel.setLayout(new CardLayout());
		switchPanel.setBounds(10, 70, 500, 350);
		inventoryPanel.add(switchPanel);
		
		supplyTable = new JTable();
		try
		{
			List<Supply> supplyList = dao.getAllSupplies();
			SupplyTableModel supplyModel = new SupplyTableModel(supplyList);
			supplyTable.setModel(supplyModel);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalTextPosition(DefaultTableCellRenderer.CENTER);
		for(int i = 0; i < supplyTable.getColumnCount(); i++)
		{
			supplyTable.getColumnModel().getColumn(i).setCellRenderer(dtcr);
		}
		
		//a scroll pane with a list of supplies
		supplyPane = new JScrollPane();
		supplyPane.setViewportView(supplyTable);
		switchPanel.add(supplyPane, "Supply");
		
		menuPane = new JScrollPane();
		switchPanel.add(menuPane, "Menu");
		
		otherPane = new JScrollPane();
		switchPanel.add(otherPane, "Other");
		
		//search bar to search products
		searchTF = new JTextField();
		searchTF.setBounds(10, 20, 300, 33);
		inventoryPanel.add(searchTF);
		
		supplyBtn = new JButton("Supply");
		supplyBtn.setBounds(100, 430, 100, 33);
		supplyBtn.addActionListener(this);
		inventoryPanel.add(supplyBtn);
		
		menuBtn = new JButton("Menu");
		menuBtn.setBounds(200, 430, 100, 33);
		menuBtn.addActionListener(this);
		inventoryPanel.add(menuBtn);
		
		otherBtn = new JButton("Other");
		otherBtn.setBounds(300, 430, 100, 33);
		otherBtn.addActionListener(this);
		inventoryPanel.add(otherBtn);
		
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
		if(e.getSource() == supplyBtn)
		{
			CardLayout cardLayout = (CardLayout) switchPanel.getLayout();
			cardLayout.show(switchPanel, "Supply");
		}
		
		if(e.getSource() == menuBtn)
		{
			CardLayout cardLayout = (CardLayout) switchPanel.getLayout();
			cardLayout.show(switchPanel, "Menu");
		}
		
		if(e.getSource() == otherBtn)
		{
			CardLayout cardLayout = (CardLayout) switchPanel.getLayout();
			cardLayout.show(switchPanel, "Other");
		}
		
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
