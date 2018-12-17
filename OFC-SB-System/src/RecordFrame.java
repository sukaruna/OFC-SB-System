/*
 * Author: Alex Zhou
 * Date: 2018.12.13
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
	private JPanel recordPanel, switchPanel;
	private JScrollPane editPricePane, deleteInventoryPane;
	private JButton editPriceBtn, deleteInventoryBtn;
	private String card = "Edit Price";
	
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
		
		switchPanel = new JPanel();
		switchPanel.setLayout(new CardLayout());
		switchPanel.setBounds(10, 70, 500, 350);
		recordPanel.add(switchPanel);
		
		JTable editPriceTable = new JTable();
		try
		{
			List<Record> recordList = dao.getAllEditPriceRecords();
			RecordTableModel recordModel = new RecordTableModel(recordList);
			editPriceTable.setModel(recordModel);
			editPriceTable.removeColumn(editPriceTable.getColumnModel().getColumn(5));
			editPriceTable.removeColumn(editPriceTable.getColumnModel().getColumn(5));
			editPriceTable.removeColumn(editPriceTable.getColumnModel().getColumn(5));
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(this, "Error creating table: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		for(int i = 0; i < editPriceTable.getColumnCount(); i++)
		{
			editPriceTable.getColumnModel().getColumn(i).setCellRenderer(dtcr);
		}
		
		JTable deleteInventoryTable = new JTable();
		try
		{
			List<Record> recordList = dao.getAllDeleteInventoryRecords();
			RecordTableModel recordModel = new RecordTableModel(recordList);
			deleteInventoryTable.setModel(recordModel);
			deleteInventoryTable.removeColumn(deleteInventoryTable.getColumnModel().getColumn(1));
			deleteInventoryTable.removeColumn(deleteInventoryTable.getColumnModel().getColumn(1));
			deleteInventoryTable.removeColumn(deleteInventoryTable.getColumnModel().getColumn(1));
			deleteInventoryTable.removeColumn(deleteInventoryTable.getColumnModel().getColumn(1));
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(this, "Error creating table: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		for(int i = 0; i < deleteInventoryTable.getColumnCount(); i++)
		{
			deleteInventoryTable.getColumnModel().getColumn(i).setCellRenderer(dtcr);
		}
		
		editPricePane = new JScrollPane();
		editPricePane.setViewportView(editPriceTable);
		switchPanel.add(editPricePane, "Edit Price");
		
		deleteInventoryPane = new JScrollPane();
		deleteInventoryPane.setViewportView(deleteInventoryTable);
		switchPanel.add(deleteInventoryPane, "Delete Inventory");
		
		editPriceBtn = new JButton("Edited price");
		editPriceBtn.setBounds(100, 440, 150, 33);
		editPriceBtn.addActionListener(this);
		recordPanel.add(editPriceBtn);
		
		deleteInventoryBtn = new JButton("Deleted inventory");
		deleteInventoryBtn.setBounds(300, 440, 150, 33);
		deleteInventoryBtn.addActionListener(this);
		recordPanel.add(deleteInventoryBtn);
		
		recordFrame.add(recordPanel);
		recordFrame.pack();
		recordFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == editPriceBtn)
		{
			CardLayout cardLayout = (CardLayout) switchPanel.getLayout();
			cardLayout.show(switchPanel, "Edit Price");
			card = "Edit Price";
		}
		
		if(e.getSource() == deleteInventoryBtn)
		{
			CardLayout cardLayout = (CardLayout) switchPanel.getLayout();
			cardLayout.show(switchPanel, "Delete Inventory");
			card = "Delete Inventory";
		}
	}
}
