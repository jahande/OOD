package invregsystem.ui;

import java.awt.ComponentOrientation;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Messages extends JFrame {

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] { "تاریخ", "عنوان", "متن" };
		private final String[][] CELLS = new String[][] {
				{
						"1390/12/14",
						"تأیید درخواست ثبت اختراع",
						"درخواست ثبت اختراع با عنوان «آپولو» توسط کارشناس تأیید شد. جهت اخذ مدرک مالکیت اختراع به سازمان ثبت اختراع مراجعه نمایید." },
				{
						"1390/7/30",
						"رد شدن درخواست ثبت اختراع",
						"درخواست ثبت اختراع با عنوان «آپولو» توسط کارشناس رد شده است. لطفا نسبت به اصلاح و ارسال دوباره اقدام نمایید." }, };

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
			Messages frame = new Messages();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public Messages() {
		super();
		setBounds(100, 100, 500, 191);
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
		setTitle("پیغام ها");

		getContentPane().add(scrollPane);
		scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setBounds(23, 10, 443, 133);

		scrollPane.setViewportView(table);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setModel(new TableTableModel());
	}

}
