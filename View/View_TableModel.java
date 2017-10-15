package View;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class View_TableModel extends AbstractTableModel {

	private String[] title;
	private Object[][] data;
	private DefaultTableModel model;
	private JTable table;
	
	public View_TableModel(Object[][] data, String[] title) {
		this.data = data;
		this.title = title;
		
		this.model = new DefaultTableModel();
		
		for(String column : title) {
			model.addColumn(column);
		}
		
		for(Object[] row : data) {
			model.addRow(row);
		}
		
		this.table = new JTable(this);
	}
	

	public int getColumnCount() {
		return this.title.length;
	}
	

	public int getRowCount() {
		return this.data.length;
	}
	

	public Object getValueAt(int row, int col) {
		return this.data[row][col];
	}

	
	@SuppressWarnings({
		"unchecked",
		"rawtypes"
	})
	public Class getColumnClass(int col) {
		return this.data[0][col].getClass();
	}
	
	public void addRow(Object[] lineData) {
		model.addRow(lineData);
	}


	public JTable getTable() {
		return table;
	}
}