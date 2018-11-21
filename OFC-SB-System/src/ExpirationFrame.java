/*
 * Author: Alex Zhou
 * Date: 2018.11.20
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ExpirationFrame extends JFrame implements ActionListener
{
	private JFrame expirationFrame;
	private JPanel expirationPanel;
	private JScrollPane expirationPane;
	private JButton deleteBtn, okBtn;
	
	public ExpirationFrame()
	{
		expirationFrame = new JFrame("Expirations");
		expirationFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		expirationFrame.setPreferredSize(new Dimension(650,500));
		expirationFrame.setLayout(new BorderLayout());
		expirationFrame.setResizable(false);
		
		expirationPanel = new JPanel();
		expirationPanel.setLayout(null);
		
		expirationPane = new JScrollPane();
		expirationPane.setBounds(10, 10, 500, 400);
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
