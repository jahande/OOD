package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class InvHistory extends JFrame {

	private final JButton displayButton = new JButton();
	private final JButton displayButton_1 = new JButton();
	private final JButton displayButton_2 = new JButton();

	class TableTableModel extends AbstractTableModel {
		private String[] COLUMNS = new String[] { "عنوان اختراع", "مخترعان",
				"تاریخ ارسال درخواست", "تاریخ ثبت" };
		private String[][] CELLS = new String[][] {
				{ "آپولو", "حسین فرقانی، روح الله جهنده", "1390/8/23", "-" },
				{ "تایر بدون عاج", "حسین فرقانی", "1390/12/27", "1391/2/3" },
				{ "تخته نئوپان محکم", "حسین فرقانی - مراد قفقازی", "1391/2/12",
						"-" }, };

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

	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvHistory frame = new InvHistory();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvHistory() {
		super();
		setBounds(100, 100, 500, 168);
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
		setTitle("سوابق اختراعات");

		getContentPane().add(scrollPane);
		scrollPane.setBounds(85, 25, 393, 82);

		scrollPane.setViewportView(table);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setModel(new TableTableModel());

		getContentPane().add(displayButton);
		displayButton.addActionListener(new DisplayButtonActionListener());
		displayButton.setForeground(new Color(0, 0, 255));
		displayButton.setContentAreaFilled(false);
		displayButton.setBorderPainted(false);
		displayButton.setText("مشاهده");
		displayButton.setBounds(10, 42, 70, 15);

		getContentPane().add(displayButton_1);
		displayButton_1.addActionListener(new DisplayButton_1ActionListener());
		displayButton_1.setForeground(new Color(0, 0, 255));
		displayButton_1.setContentAreaFilled(false);
		displayButton_1.setBorderPainted(false);
		displayButton_1.setText("مشاهده");
		displayButton_1.setBounds(10, 57, 70, 15);

		getContentPane().add(displayButton_2);
		displayButton_2.addActionListener(new DisplayButton_2ActionListener());
		displayButton_2.setForeground(new Color(0, 0, 255));
		displayButton_2.setContentAreaFilled(false);
		displayButton_2.setBorderPainted(false);
		displayButton_2.setText("مشاهده");
		displayButton_2.setBounds(10, 74, 70, 15);
	}

	private class DisplayButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			displayButton_actionPerformed(e);
		}
	}

	private class DisplayButton_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			displayButton_1_actionPerformed(e);
		}
	}

	private class DisplayButton_2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			displayButton_2_actionPerformed(e);
		}
	}

	protected void displayButton_actionPerformed(ActionEvent e) {
		new InvPage().setVisible(true);
	}

	protected void displayButton_1_actionPerformed(ActionEvent e) {
		new InvPage().setVisible(true);
	}

	protected void displayButton_2_actionPerformed(ActionEvent e) {
		new InvPage().setVisible(true);
	}

}
