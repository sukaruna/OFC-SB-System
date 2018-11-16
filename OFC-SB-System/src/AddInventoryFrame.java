/*
 * Author: Alex Zhou
 * Date: 2018.11.14
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

public class AddInventoryFrame extends JFrame implements ActionListener
{
	private JFrame addInventoryFrame;
	private JPanel addInventoryPanel;
	private JLabel scaleLabel, amountLabel, exDateLabel;
	private JButton addBtn, cancelBtn;
	
	public AddInventoryFrame()
	{
		addInventoryFrame = new JFrame("Add Product");
		addInventoryFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addInventoryFrame.setPreferredSize(new Dimension(650,500));
		addInventoryFrame.setLayout(new BorderLayout());
		addInventoryFrame.setResizable(false);
		
		addInventoryPanel = new JPanel();
		addInventoryPanel.setLayout(null);
		
		scaleLabel = new JLabel("Large Unit : Small Unit");
		scaleLabel.setBounds(20, 20, 140, 33);
		addInventoryPanel.add(scaleLabel);
		
		amountLabel = new JLabel("Amount");
		amountLabel.setBounds(20, 70, 100, 33);
		addInventoryPanel.add(amountLabel);
		
		exDateLabel = new JLabel("Expiration Date");
		exDateLabel.setBounds(20, 120, 100, 33);
		addInventoryPanel.add(exDateLabel);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(100, 400, 120, 33);
		addBtn.addActionListener(this);
		addInventoryPanel.add(addBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(400, 400, 120, 33);
		cancelBtn.addActionListener(this);
		addInventoryPanel.add(cancelBtn);
		
		addInventoryFrame.add(addInventoryPanel);
		addInventoryFrame.pack();
		addInventoryFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == addBtn)
		{
			
		}
		
		if(e.getSource() == cancelBtn)
		{
			addInventoryFrame.dispose();
		}
	}
}
