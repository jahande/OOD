package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

import logic.invention.InventionField;
import logic.member.User;

import controllers.Controller;

import uimodels.BaseFrame;
import uimodels.IdLabel;
import uimodels.NeedRefreshData;
import uimodels.SimpleListModel;

/**
 * 
 * @author rj
 * 
 * @usecase 30 base class for 37
 */

public class SelectUser extends BaseFrame implements NeedRefreshData {

	private  JPanel panel = new JPanel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	// class TableTableModel extends AbstractTableModel {
	// private final String[] COLUMNS = new String[] {
	// "نام انوادگی","نام","نام کاربری"
	// };
	// private final String[][] CELLS = new String[][] {
	// {"علوی", "علی", "alialavi"},
	// {"جهنده", "روح الله", "rjahande"},
	// {"فرقانی", "حسین", "hforghani"},
	//			
	// };
	// public int getRowCount() {
	// return CELLS.length;
	// }
	// public int getColumnCount() {
	// return COLUMNS.length;
	// }
	// public String getColumnName(int column) {
	// return COLUMNS[column];
	// }
	// public Object getValueAt(int row, int column) {
	// return CELLS[row].length > column ? CELLS[row][column] : (column + " - "
	// + row);
	// }
	// }

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
			SelectUser frame = new SelectUser(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public SelectUser(Controller c) {
		super(c);
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
		// table.setModel(new TableTableModel());

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

	public void refreshData(Object obj) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		resetInventionFieldsPanel();
		List<User> users = null;
		try {
			users = (List<User>) ((Object[]) obj)[0];
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۵۱");
			return;
		}

		String[][] strings = new String[users.size()][3];
		for (int i = 0; i < users.size(); i++) {
			strings[i][0] = users.get(i).getUserName();
			strings[i][1] = users.get(i).getFirstName();
			strings[i][2] = users.get(i).getLastName();
		}
		// this.panel = new JPanel();

		table.setModel(new UserTableModel(strings));
	}

	private JPanel resetInventionFieldsPanel() {
		try {
			getContentPane().remove(this.panel);
		} catch (Exception e) {
			// TODO: handle exception
		}

		JPanel p = new JPanel();
		getContentPane().add(p);
		p.setBounds(42, 92, 42, 199);
		this.panel = p;

		// /////////////////////////////////////

		return p;
	}

}

class UserTableModel extends AbstractTableModel {
	private final String[] COLUMNS = new String[] { "نام انوادگی", "نام",
			"نام کاربری" };
	private final String[][] CELLS;// = new String[][] {
	// {"علوی", "علی", "alialavi"},
	// {"جهنده", "روح الله", "rjahande"},
	// {"فرقانی", "حسین", "hforghani"},
	//		
	// };

	private UserTableModel() {
		CELLS = null;
	}

	public UserTableModel(String[][] strings) {
		CELLS = strings;
	}

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
		return CELLS[row].length > column ? CELLS[row][column] : (column
				+ " - " + row);
	}
}