package ui.models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class JTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = new String[] { "مشاهده",
			"وضعیت", "حوزه اختراع", "تاریخ ارسال", "شرکت", "مخترعان",
			"عنوان اختراع" };
	private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {
			JButton.class, String.class, String.class, String.class,
			String.class, String.class, String.class };

	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	public int getRowCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return COLUMN_NAMES[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return COLUMN_TYPES[columnIndex];
	}

	public Object getValueAt(final int rowIndex, final int columnIndex) {
		if (COLUMN_TYPES[columnIndex].equals(JButton.class)) {
			final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(JOptionPane
							.getFrameForComponent(button),
							"Button clicked for row " + rowIndex);
				}
			});
			return button;
		} else {
			return "";
			// return CELLS[rowIndex].length > columnIndex ?
			// CELLS[rowIndex][columnIndex]
			// : (columnIndex + " - " + rowIndex);
		}
	}
}
