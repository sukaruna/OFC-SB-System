/*
 * Author: Alex Zhou
 * Date: 2018.11.29
 */

import java.util.List;

import javax.swing.table.AbstractTableModel;

class MenuTableModel extends AbstractTableModel
{
	public static final int OBJECT_COL = -1;
	private static final int NAME_COL = 0;
	private static final int PRICE_COL = 1;
	private String[] columnNames = {"Name", "Price"};
	private List<Menu> menu;
	
	public MenuTableModel(List<Menu> theMenu)
	{
		menu = theMenu;
	}
	
	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}

	@Override
	public int getRowCount()
	{
		return menu.size();
	}

	@Override
	public String getColumnName(int col)
	{
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col)
	{
		Menu tempMenu = menu.get(row);

		switch (col)
		{
		case NAME_COL:
			return tempMenu.getName();
		case PRICE_COL:
			return tempMenu.getPrice();
		default:
			return tempMenu.getName();
		}
	}

	@Override
	public Class getColumnClass(int c)
	{
		return getValueAt(0, c).getClass();
	}
}