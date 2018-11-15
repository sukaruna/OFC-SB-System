/*
 * Author: Alex Zhou
 * Date: 2018.11.14
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddInventoryFrame extends JFrame implements ActionListener
{
	private JFrame addInventoryFrame;
	private JPanel addInventoryPanel;
	private JLabel scaleLabel, amountLabel, exDateLabel;
	
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
		
		addInventoryFrame.add(addInventoryPanel);
		addInventoryFrame.pack();
		addInventoryFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
