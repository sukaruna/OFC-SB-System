/*
 * Author: Alex Zhou
 * Date: 2018.11.13
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddProductFrame extends JFrame implements ActionListener
{
	private JFrame addProductFrame;
	private JPanel addProductPanel;
	private JButton addBtn, deleteBtn;
	private JLabel nameLabel, typeLabel, priceLabel, emPriceLabel, lowStockLabel;
	private JTextField nameTF, priceTF, emPriceTF;
	private JComboBox typeCB;
	
	public AddProductFrame()
	{
		addProductFrame = new JFrame("Add Product");
		addProductFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addProductFrame.setPreferredSize(new Dimension(650,500));
		addProductFrame.setLayout(new BorderLayout());
		addProductFrame.setResizable(false);
		
		addProductPanel = new JPanel();
		addProductPanel.setLayout(null);
		
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
		
		addBtn = new JButton("Add");
		addBtn.setBounds(100, 400, 120, 33);
		addBtn.addActionListener(this);
		addProductPanel.add(addBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400, 400, 120, 33);
		deleteBtn.addActionListener(this);
		addProductPanel.add(deleteBtn);
		
		String[] typeList = {"Supply", "Menu", "Other"};
		typeCB = new JComboBox(typeList);
		
		addProductFrame.add(addProductPanel);
		addProductFrame.pack();
		addProductFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
