/*
 * Author: Alex Zhou
 * Date: 2018.11.13
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddProductFrame extends JFrame implements ActionListener
{
	private ProductDAO dao;
	private InventoryPanel inventoryPanel;
	private String type = "";
	private int count = 0;
	@SuppressWarnings("rawtypes")
	private JComboBox[] materialCB = new JComboBox[9];
	private JFrame addProductFrame;
	private JPanel addProductPanel, comboPanel;
	private JButton addCBBtn, addBtn, cancelBtn;
	private JLabel nameLabel, typeLabel, categoryLabel, priceLabel, emPriceLabel, lowStockLabel, materialLabel;
	private JTextField nameTF, priceTF, emPriceTF, lowStockTF;
	private JComboBox<String> typeCB, categoryCB;
	
	public AddProductFrame(InventoryPanel thePanel, ProductDAO theDAO)
	{
		inventoryPanel = thePanel;
		dao = theDAO;
		
		int supplyNum = 0;
		try
		{
			supplyNum = dao.getLastID("Supply");
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
		String[] supplyList = new String[supplyNum];
		try
		{
			supplyList = dao.getSupplyNames();
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
		addProductFrame = new JFrame("Add Product");
		addProductFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addProductFrame.setPreferredSize(new Dimension(650,500));
		addProductFrame.setLayout(new BorderLayout());
		addProductFrame.setResizable(false);
		
		addProductPanel = new JPanel();
		addProductPanel.setLayout(null);
		
		comboPanel = new JPanel();
		comboPanel.setLayout(new GridLayout(3, 3, 5, 5));
		comboPanel.setBounds(150, 270, 450, 150);
		for(int i = 0; i < materialCB.length; i++)
		{
			materialCB[i] = new JComboBox<String>(supplyList);
			materialCB[i].setVisible(false);
			comboPanel.add(materialCB[i]);
		}
		addProductPanel.add(comboPanel);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(20, 20, 100, 33);
		addProductPanel.add(nameLabel);
		
		typeLabel = new JLabel("Type:");
		typeLabel.setBounds(20, 60, 100, 33);
		addProductPanel.add(typeLabel);
		
		categoryLabel = new JLabel("Category:");
		categoryLabel.setBounds(20, 100, 100, 33);
		addProductPanel.add(categoryLabel);
		
		priceLabel = new JLabel("Price:");
		priceLabel.setBounds(20, 140, 100, 33);
		addProductPanel.add(priceLabel);
		
		emPriceLabel = new JLabel("Employee Price:");
		emPriceLabel.setBounds(20, 180, 100, 33);
		addProductPanel.add(emPriceLabel);
		
		lowStockLabel = new JLabel("Low-Stock:");
		lowStockLabel.setBounds(20, 220, 100, 33);
		addProductPanel.add(lowStockLabel);
		
		materialLabel = new JLabel("Materials:");
		materialLabel.setBounds(20, 260, 100, 33);
		addProductPanel.add(materialLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(150, 20, 150, 33);
		addProductPanel.add(nameTF);
		
		priceTF = new JTextField("0");
		priceTF.setBounds(150, 140, 150, 33);
		addProductPanel.add(priceTF);
		
		emPriceTF = new JTextField("0");
		emPriceTF.setBounds(150, 180, 150, 33);
		addProductPanel.add(emPriceTF);
		
		lowStockTF = new JTextField("0");
		lowStockTF.setBounds(150, 220, 150, 33);
		addProductPanel.add(lowStockTF);
		
		String[] typeList = {"", "Supply", "Menu", "Other"};
		typeCB = new JComboBox<String>(typeList);
		typeCB.setSelectedIndex(0);
		typeCB.setBounds(150, 60, 150, 33);
		typeCB.addActionListener(new ActionListener()
				{
					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent e)
					{
						JComboBox<String> combo = (JComboBox<String>) e.getSource();
				        type = (String) combo.getSelectedItem();
				        
				        switch (type)
				        {
				        case "":
				        	break;
				        case "Supply":
				        	type = "Supply";
				        	setDisabled(priceTF);
				        	setDisabled(emPriceTF);
				        	setDisabled(addCBBtn);
//				        	setDisabled(comboPanel);
				        	setEnabled(lowStockTF);
				        	break;
				        case "Menu":
				        	type = "Menu";
				        	setEnabled(priceTF);
				        	setEnabled(emPriceTF);
				        	setEnabled(addCBBtn);
//				        	setEnabled(comboPanel);
				        	setDisabled(lowStockTF);
				        	break;
				        case "Other":
				        	type = "Other";
				        	setDisabled(priceTF);
				        	setDisabled(emPriceTF);
				        	setDisabled(addCBBtn);
//				        	setDisabled(comboPanel);
				        	setEnabled(lowStockTF);
				        	break;
				        }
					}
				});
		addProductPanel.add(typeCB);
		
		String[] categoryList = {"", "Candy", "Popcorn", "Small drink", "Large drink", "Hotdog"};
		categoryCB = new JComboBox<String>(categoryList);
		categoryCB.setSelectedIndex(0);
		categoryCB.setBounds(150, 100, 150, 33);
		addProductPanel.add(categoryCB);
		
		addCBBtn = new JButton();
		addCBBtn.setBounds(110, 270, 33, 33);
		addCBBtn.addActionListener(this);
		addProductPanel.add(addCBBtn);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(100, 420, 120, 33);
		addBtn.addActionListener(this);
		addProductPanel.add(addBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(400, 420, 120, 33);
		cancelBtn.addActionListener(this);
		addProductPanel.add(cancelBtn);
		
		addProductFrame.add(addProductPanel);
		addProductFrame.pack();
		addProductFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == addCBBtn)
		{
			materialCB[count].setVisible(true);
			count++;
			if(count == 9)
			{
				addCBBtn.setVisible(false);
			}
		}
		
		if(e.getSource() == addBtn)
		{
			if(type.compareTo("Supply") == 0 || type.compareTo("Other") == 0)
			{
				String name = nameTF.getText();
				int lowStock = Integer.parseInt(lowStockTF.getText());
				
				if(type.compareTo("Supply") == 0)
				{
					Supply temp = new Supply(name, type, lowStock);
					try
					{
						dao.addSupply(temp);
						addProductFrame.dispose();
						inventoryPanel.refreshProductView();
					}
					catch (Exception e1)
					{
						JOptionPane.showMessageDialog(this, "Error adding product: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					Other temp = new Other(name, type, lowStock);
					try
					{
						dao.addOther(temp);
						inventoryPanel.refreshProductView();
						addProductFrame.dispose();
					}
					catch (Exception e1)
					{
						JOptionPane.showMessageDialog(this, "Error adding product: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else if(type.compareTo("Menu") == 0)
			{
				String name = nameTF.getText();
				String category = (String) categoryCB.getSelectedItem();
				String material = "";
				for(int i = 0; i < count; i++)
				{
					String temp = (String) materialCB[i].getSelectedItem();
					if(temp.compareTo("") != 0)
					{
						material = material + temp + "&";
					}
				}
				double price = Double.parseDouble(priceTF.getText());
				double emPrice = Double.parseDouble(emPriceTF.getText());
				Menu temp = new Menu(name, type, category, material, price, emPrice);
				try
				{
					dao.addMenu(temp);
					inventoryPanel.refreshProductView();
					addProductFrame.dispose();
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(this, "Error adding product: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please choose the type for the product.", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		if(e.getSource() == cancelBtn)
		{
			addProductFrame.dispose();
		}
	}
	
	private void setDisabled(JComponent jc)
	{
		jc.setEnabled(false);
		jc.setBackground(Color.LIGHT_GRAY);
	}
	
	private void setEnabled(JComponent jc)
	{
		jc.setEnabled(true);
		jc.setBackground(Color.WHITE);
	}
}
