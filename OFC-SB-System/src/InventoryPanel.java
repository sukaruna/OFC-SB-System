import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InventoryPanel implements ActionListener
{
	private JPanel inventoryPanel;
	private JButton addInventory;
	
	public InventoryPanel()
	{
		inventoryPanel = new JPanel();
		inventoryPanel.setPreferredSize(new Dimension(2500,1400));
		
		addInventory  = new JButton("Add Inventory");
		addInventory.addActionListener(this);
		inventoryPanel.add(addInventory);
		
		MainFrame.overallFrame.add(inventoryPanel);
		MainFrame.overallFrame.pack();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
