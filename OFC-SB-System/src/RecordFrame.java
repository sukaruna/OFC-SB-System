/*
 * Author: Alex Zhou
 * Date: 2018.12.13
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RecordFrame extends JFrame implements ActionListener
{
	private ProductDAO dao;
	private JFrame recordFrame;
	private JPanel recordPanel;
	private JScrollPane editPricePane, deleteInventoryPane;
	
	public RecordFrame(ProductDAO theDAO)
	{
		dao = theDAO;
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalTextPosition(DefaultTableCellRenderer.CENTER);
		
		recordFrame = new JFrame("Records");
		recordFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		recordFrame.setPreferredSize(new Dimension(650,500));
		recordFrame.setLayout(new BorderLayout());
		recordFrame.setResizable(false);
		
		recordPanel = new JPanel();
		recordPanel.setLayout(null);
		
		JTable supplyTable = new JTable();
		try
		{
			List<Supply> supplyList = dao.getLowStockSupplies();
			SupplyTableModel supplyModel = new SupplyTableModel(supplyList);
			supplyTable.setModel(supplyModel);
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(this, "Error creating table: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		for(int i = 0; i < supplyTable.getColumnCount(); i++)
		{
			supplyTable.getColumnModel().getColumn(i).setCellRenderer(dtcr);
		}
		
		

		recordFrame.add(recordPanel);
		recordFrame.pack();
		recordFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
