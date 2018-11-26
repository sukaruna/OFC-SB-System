/*
 * Author: Alex Zhou
 * Date: 2018.11.25
 */

import java.util.List;

import javax.swing.table.AbstractTableModel;

class SupplyTableModel extends AbstractTableModel
{
	private static final int NAME_COL = 0;
	private static final int AMOUNT_COL = 1;
	private String[] columnNames = {"Name", "Amount"};
	private List<Supply> supply;
	
	public SupplyTableModel(List<Supply> theSupply)
	{
		supply = theSupply;
	}
	
	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}

	@Override
	public int getRowCount()
	{
		return supply.size();
	}

	@Override
	public String getColumnName(int col)
	{
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col)
	{
		Supply tempSupply = supply.get(row);

		switch (col)
		{
		case NAME_COL:
			return tempSupply.getName();
		case AMOUNT_COL:
			return tempSupply.getAmount();
		default:
			return tempSupply.getName();
		}
	}

	@Override
	public Class getColumnClass(int c)
	{
		return getValueAt(0, c).getClass();
	}
}
