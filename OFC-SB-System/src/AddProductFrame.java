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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddProductFrame extends JFrame implements ActionListener
{
	private int count = 0;
	@SuppressWarnings("rawtypes")
	private JComboBox[] materialCB = new JComboBox[9];
	private JFrame addProductFrame;
	private JPanel addProductPanel, comboPanel;
	private JButton addCBBtn, addBtn, cancelBtn;
	private JLabel nameLabel, typeLabel, priceLabel, emPriceLabel, lowStockLabel, materialLabel;
	private JTextField nameTF, priceTF, emPriceTF, lowStockTF;
	private JComboBox<String> typeCB;
	
	public AddProductFrame()
	{
		String[] supplyList = {"a", "b", "c", "d", "e"};//supplies in the database
		
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
		typeLabel.setBounds(20, 70, 100, 33);
		addProductPanel.add(typeLabel);
		
		priceLabel = new JLabel("Price:");
		priceLabel.setBounds(20, 120, 100, 33);
		addProductPanel.add(priceLabel);
		
		emPriceLabel = new JLabel("Employee Price:");
		emPriceLabel.setBounds(20, 170, 100, 33);
		addProductPanel.add(emPriceLabel);
		
		lowStockLabel = new JLabel("Low-Stock:");
		lowStockLabel.setBounds(20, 220, 100, 33);
		addProductPanel.add(lowStockLabel);
		
		materialLabel = new JLabel("Materials:");
		materialLabel.setBounds(20, 270, 100, 33);
		addProductPanel.add(materialLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(150, 20, 150, 33);
		addProductPanel.add(nameTF);
		
		priceTF = new JTextField();
		priceTF.setBounds(150, 120, 150, 33);
		addProductPanel.add(priceTF);
		
		emPriceTF = new JTextField();
		emPriceTF.setBounds(150, 170, 150, 33);
		addProductPanel.add(emPriceTF);
		
		lowStockTF = new JTextField();
		lowStockTF.setBounds(150, 220, 150, 33);
		addProductPanel.add(lowStockTF);
		
		String[] typeList = {"", "Supply", "Menu", "Other"};
		typeCB = new JComboBox<String>(typeList);
		typeCB.setSelectedIndex(0);
		typeCB.setBounds(150, 70, 150, 33);
		typeCB.addActionListener(new ActionListener()
				{
					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent e)
					{
						JComboBox<String> combo = (JComboBox<String>) e.getSource();
				        String type = (String) combo.getSelectedItem();
				        
				        switch (type)
				        {
				        case "":
				        	break;
				        case "Supply":
				        	setDisabled(priceTF);
				        	setDisabled(emPriceTF);
				        	setEnabled(lowStockTF);
				        	break;
				        case "Menu":
				        	setEnabled(priceTF);
				        	setEnabled(emPriceTF);
				        	setDisabled(lowStockTF);
				        	break;
				        case "Other":
				        	setDisabled(priceTF);
				        	setDisabled(emPriceTF);
				        	setEnabled(lowStockTF);
				        	break;
				        }
					}
				});
		addProductPanel.add(typeCB);
		
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
	
	@SuppressWarnings("unchecked")
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
			JComboBox<String> combo = (JComboBox<String>) e.getSource();
	        String type = (String) combo.getSelectedItem();
	        
			if(type.compareTo("Supply") == 0 || type.compareTo("Other") == 0)
			{
				
			}
			else if(type.compareTo("Menu") == 0)
			{
				
			}
			else
			{
				
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
