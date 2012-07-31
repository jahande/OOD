package invregsystem.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 * @usecase 39
 */

public class RequestPeronsInventions extends JFrame {

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] {
			"نام", "نام کاربری", "مخترع", "تعداد اختراع"
		};
		private final String[][] CELLS = new String[][] {
			{"روح الله", "جهنده", "هست", "۰.۵"},
			{"حسین", "فرقانی", "هست", "۱"},
			{"علی", "علوی", "نیست", "۰"},
			{"احسان", "کارشناس زاده", "نیست", "۰"},
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

	private final JButton button = new JButton();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			RequestPeronsInventions frame = new RequestPeronsInventions();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public RequestPeronsInventions() {
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
		setTitle("استعلام اطلاعات پرسنل شرکت یا سازمان");
		
		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("انتخاب فایل حاوی لیست افراد سازمان");
		button.setBounds(65, 44, 197, 26);
		
		getContentPane().add(scrollPane);
		scrollPane.setBounds(34, 162, 411, 151);
		
		scrollPane.setViewportView(table);
		table.setModel(new TableTableModel());
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}
	protected void button_actionPerformed(ActionEvent e) {
		final JFileChooser fc = new JFileChooser();
		int returnVal2 = fc.showOpenDialog(this);
//		if (e.getSource() == this.button) {
//	        int returnVal = fc.showOpenDialog(RequestPeronsInventions.this);
//
//	        if (returnVal == JFileChooser.APPROVE_OPTION) {
//	            File file = fc.getSelectedFile();
//	            //This is where a real application would open the file.
//	            //log.append("Opening: " + file.getName() + "." + newline);
//	        } else {
//	            //log.append("Open command cancelled by user." + newline);
//	        }
//	   }
	}

}
