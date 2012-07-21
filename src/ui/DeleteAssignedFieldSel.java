package ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 * @usecase 37(1)
 */

public class DeleteAssignedFieldSel extends SelectUser {

	private final JPanel panel = new JPanel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] { "نام انوادگی", "نام", "نام کاربری" };
		private final String[][] CELLS = new String[][] { { "علوی", "علی", "alialavi" }, { "جهنده", "روح الله", "rjahande" }, { "فرقانی", "حسین", "hforghani" },

		};

		public int getRowCount() {
			return CELLS.length;
		}

		public int getColumnCount() {
			return COLUMNS.length;
		}

		public String getColumnName(int column) {
			return COLUMNS[column];
		}

		public Object getValueAt(int row, int column) {
			return CELLS[row].length > column ? CELLS[row][column] : (column + " - " + row);
		}
	}

	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JLabel label = new JLabel();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			DeleteAssignedFieldSel frame = new DeleteAssignedFieldSel();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public DeleteAssignedFieldSel() {
		super();
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);

		getContentPane().add(scrollPane);
		scrollPane.setBounds(98, 77, 291, 214);

		scrollPane.setViewportView(table);
		table.setModel(new TableTableModel());

		getContentPane().add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setText("لطفا کاربر مورد نظر را انتخاب نمایید");
		label.setBounds(99, 18, 290, 31);

		getContentPane().add(panel);
		panel.setBounds(42, 92, 42, 199);

		panel.add(label_1);
		label_1.setPreferredSize(new Dimension(40, 10));
		label_1.setForeground(Color.BLUE);
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setText("انتخاب");

		panel.add(label_3);
		label_3.setPreferredSize(new Dimension(40, 10));
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLUE);
		label_3.setText("انتخاب");

		panel.add(label_4);
		label_4.setPreferredSize(new Dimension(40, 10));
		label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.BLUE);
		label_4.setText("انتخاب");
	}

}
