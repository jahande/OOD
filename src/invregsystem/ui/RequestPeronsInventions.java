package invregsystem.ui;

import invregsystem.AbstractInvention;
import invregsystem.AbstractUser;
import invregsystem.logic.Request;
import invregsystem.logic.invention.Invention;
import invregsystem.logic.invention.InventionCatalog;
import invregsystem.logic.invention.Share;
import invregsystem.logic.member.UserCatalog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 * @usecase 39
 */

public class RequestPeronsInventions extends JFrame {

	private final static String[] COLS = new String[] { "نام",
			"وضعیت مخترع بودن", "تعداد اختراع", };

	// private final static int COLUMS_NUMBER = 3;
	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = RequestPeronsInventions.COLS;
		private final String[][] CELLS;

		public TableTableModel(String[][] cells) {
			this.CELLS = cells;
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

	private final JButton button = new JButton();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();

	/**
	 * Launch the application
	 * 
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
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}

	protected void button_actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();

		// Show open dialog; this method does not return until the dialog is
		// closed
		fc.showOpenDialog(this);
		File selFile = fc.getSelectedFile();
		ArrayList<String> fullNames = new ArrayList<String>();
		try {
			Scanner sc = new Scanner(new InputStreamReader(new FileInputStream(
					selFile), "unicode"));
			while (sc.hasNext()) {
				fullNames.add(sc.nextLine());
				System.out.println(fullNames.get(fullNames.size() - 1));
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e2) {

		}

		ArrayList<String[]> tableStrs = new ArrayList<String[]>();
		// List<AbstractUser> users =
		int i = 0;
		for (Object obj : UserCatalog.getInstance().getAllItems()) {
			AbstractUser user = (AbstractUser) obj;
			int indexOf = fullNames.lastIndexOf(user.getFullName());
			if (indexOf >= 0) {
				fullNames.remove(indexOf);
				tableStrs.add(new String[RequestPeronsInventions.COLS.length]);

				tableStrs.get(i)[0] = user.getFullName();

				int shares = 0;
				// //compute sum of shares
				for (AbstractInvention inv : InventionCatalog.getInstance()
						.getInventionsByInventor(user)) {
					if (inv.getInventionRegistrationRequest().getState() == Request.ACCEPTED) {
						shares += InventionCatalog.getInstance()
								.getShareByParameters(user, inv)
								.getShareValue();
					}

				}
				// /end of compute sum of shares
				if (shares > 0) {
					tableStrs.get(i)[1] = "هست";
				} else {
					tableStrs.get(i)[1] = "نیست";
				}
				tableStrs.get(i)[2] = Integer.toString(shares);
				i++;
			}

		}
		int j = i;
		for (String fullname : fullNames) {
			tableStrs.add(new String[RequestPeronsInventions.COLS.length]);
			tableStrs.get(j)[0] = fullname;
			tableStrs.get(j)[1] = "نیست";
			tableStrs.get(j)[2] = "0";
			System.out.println(fullname);
			j++;
		}
		this.table.setModel(new TableTableModel(tableStrs
				.toArray(new String[tableStrs.size()][])));
	}

}
