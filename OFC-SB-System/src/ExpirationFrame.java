/*
 * Author: Alex Zhou
 * Date: 2018.11.20
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

public class ExpirationFrame extends JFrame implements ActionListener
{
	private ProductDAO dao;
	private JFrame expirationFrame;
	private JPanel expirationPanel;
	private JScrollPane expirationPane;
	private JButton deleteBtn, okBtn;
	
	public ExpirationFrame(ProductDAO theDAO)
	{
		dao = theDAO;
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalTextPosition(DefaultTableCellRenderer.CENTER);
		
		expirationFrame = new JFrame("Expirations");
		expirationFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		expirationFrame.setPreferredSize(new Dimension(650,500));
		expirationFrame.setLayout(new BorderLayout());
		expirationFrame.setResizable(false);
		
		expirationPanel = new JPanel();
		expirationPanel.setLayout(null);
		
		JTable supplyTable = new JTable();
		try
		{
			List<Supply> supplyList = dao.getCloseToExpirationSupplies();
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
		
		expirationPane = new JScrollPane();
		expirationPane.setBounds(10, 10, 500, 400);
		expirationPane.setViewportView(supplyTable);
		expirationPanel.add(expirationPane);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(150, 440, 120, 33);
		deleteBtn.addActionListener(this);
		expirationPanel.add(deleteBtn);
		
		okBtn = new JButton("OK");
		okBtn.setBounds(300, 440, 120, 33);
		okBtn.addActionListener(this);
		expirationPanel.add(okBtn);
		
		expirationFrame.add(expirationPanel);
		expirationFrame.pack();
		expirationFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == deleteBtn)
		{
			
		}
		
		if(e.getSource() == okBtn)
		{
			expirationFrame.dispose();
		}
	}
}
