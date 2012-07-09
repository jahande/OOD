package ui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ExpertInvRegReqList extends JFrame {

	private final JButton displayButton = new JButton();
	private final JButton displayButton_1 = new JButton();
	private final JButton displayButton_2 = new JButton();

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] { "عنوان اختراع",
				"مخترعان", "شرکت", "تاریخ ارسال", "حوزه اختراع", "وضعیت" };
		private final String[][] CELLS = new String[][] {
				{ "آپولو", "حسین فرقانی، روح الله جهنده", "-", "90/2/20",
						"هوافضا", "بررسی نشده" },
				{ "تخته نئوپان محکم", "رستم کاربری", "-", "91/1/12", "مواد",
						"تأیید شده" },
				{ "ماهواره نوید علم و صنعت", "جمشید شاهمرادی",
						"دانشگاه علم و صنعت", "90/2/20", "هوافضا", "رد شده" }, };

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

	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTable table = new JTable();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ExpertInvRegReqList frame = new ExpertInvRegReqList();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public ExpertInvRegReqList() {
		super();
		setBounds(100, 100, 625, 182);
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
		setTitle("درخواست های ثبت اختراع");

		getContentPane().add(scrollPane_1);
		scrollPane_1.setBounds(76, 26, 531, 97);

		scrollPane_1.setViewportView(table);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setModel(new TableTableModel());
		table.setRowHeight(20);

		getContentPane().add(displayButton);
		displayButton.addActionListener(new DisplayButtonActionListener());
		displayButton.setForeground(new Color(0, 0, 255));
		displayButton.setContentAreaFilled(false);
		displayButton.setBorderPainted(false);
		displayButton.setText("مشاهده");
		displayButton.setBounds(0, 45, 70, 15);

		getContentPane().add(displayButton_1);
		displayButton_1.addActionListener(new DisplayButtonActionListener());
		displayButton_1.setForeground(new Color(0, 0, 255));
		displayButton_1.setContentAreaFilled(false);
		displayButton_1.setBorderPainted(false);
		displayButton_1.setText("مشاهده");
		displayButton_1.setBounds(0, 66, 70, 15);

		getContentPane().add(displayButton_2);
		displayButton_2.addActionListener(new DisplayButtonActionListener());
		displayButton_2.setForeground(new Color(0, 0, 255));
		displayButton_2.setContentAreaFilled(false);
		displayButton_2.setBorderPainted(false);
		displayButton_2.setText("مشاهده");
		displayButton_2.setBounds(0, 87, 70, 15);
	}

	private class DisplayButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			displayButton_actionPerformed(e);
		}
	}

	protected void displayButton_actionPerformed(ActionEvent e) {
		new ExpertInvRegReq().setVisible(true);
	}

}
