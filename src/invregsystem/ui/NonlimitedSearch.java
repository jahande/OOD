package invregsystem.ui;

import invregsystem.AbstractInvention;
import invregsystem.logic.invention.InventionCatalog;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;

import utilities.StringUtilities;

public class NonlimitedSearch extends JFrame {

	private final JPanel panel_1 = new JPanel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	private final JLabel label_6 = new JLabel();
	private final JLabel label_7 = new JLabel();
	private final JLabel label_8 = new JLabel();
	private final JTextField inventorTextField = new JTextField();
	private final JTextField invTitleTextField = new JTextField();
	private final JTextField descTextField = new JTextField();
	private final JTextField ideaDescTextField = new JTextField();
	private final JTextField ideaHistoryTextField = new JTextField();
	private final JTextField assertTextField = new JTextField();
	private final JTextField absTextField = new JTextField();
	private final JTextField invDescTextField = new JTextField();
	private final JButton searchButton = new JButton();

	private String[] COLUMNS = new String[] { "عنوان اختراع", "مخترعان", "تعداد مخترعان", "تاریخ ثبت", "قیمت", };
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTable table = new JTable();

	private InventionCatalog inventionCatalog;

	class TableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] { "عنوان اختراع", "مخترعان", "شرکت", "تاریخ ثبت", "قیمت", };
		private List<AbstractInvention> inventions;

		public TableModel(List<AbstractInvention> inventions) {
			this.inventions = inventions;
		}

		public int getRowCount() {
			return inventions.size();
		}

		public int getColumnCount() {
			return COLUMNS.length;
		}

		public String getColumnName(int column) {
			return COLUMNS[column];
		}

		public Object getValueAt(int row, int column) {
			String colName = COLUMNS[column];
			AbstractInvention invention = null;
			try {
				invention = inventions.get(row);
			} catch (IndexOutOfBoundsException e) {
				return "Error";
			}
			if (colName.equals("عنوان اختراع")) {
				return invention.getTitle();
			} else if (colName.equals("مخترعان")) {
				return StringUtilities.getCommaSeparated(inventionCatalog.getInventorNames(invention));
			} else if (colName.equals("شرکت")) {
				if (invention.getCompany() != null) {
					return invention.getCompany().getName();
				} else {
					return "---";
				}
			} else if (colName.equals("تاریخ ثبت")) {
				Date acceptDate = invention.getInventionRegistrationRequest().getAcceptDate();
				if (acceptDate != null) {
					return invention.getInventionRegistrationRequest().getAcceptDate();
				} else {
					return "---";
				}
			} else if (colName.equals("قیمت")) {
				return invention.getPrice();
			} else {
				return "Error";
			}
		}
	}

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			NonlimitedSearch frame = new NonlimitedSearch();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public NonlimitedSearch() {
		super();
		inventionCatalog = InventionCatalog.getInstance();
		setBounds(100, 100, 420, 333);
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
		setTitle("جستجو در اختراعات");

		getContentPane().add(panel_1);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 10, 392, 143);

		panel_1.add(label_1);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setText("نام مخترع");
		label_1.setBounds(314, 12, 66, 16);

		panel_1.add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("عنوان اختراع");
		label_2.setBounds(314, 34, 66, 16);

		panel_1.add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("مشخصات کلی");
		label_3.setBounds(314, 56, 66, 16);

		panel_1.add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("شرح ایده");
		label_4.setBounds(314, 78, 66, 16);

		panel_1.add(label_5);
		label_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_5.setText("سابقه ایده");
		label_5.setBounds(119, 12, 66, 16);

		panel_1.add(label_6);
		label_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_6.setText("ادعانامه");
		label_6.setBounds(119, 34, 66, 16);

		panel_1.add(label_7);
		label_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_7.setText("چکیده");
		label_7.setBounds(119, 56, 66, 16);

		panel_1.add(inventorTextField);
		inventorTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		inventorTextField.setBounds(204, 12, 117, 20);

		panel_1.add(invTitleTextField);
		invTitleTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		invTitleTextField.setBounds(204, 34, 117, 20);

		panel_1.add(descTextField);
		descTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		descTextField.setBounds(204, 56, 117, 20);

		panel_1.add(ideaDescTextField);
		ideaDescTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaDescTextField.setBounds(204, 78, 117, 20);

		panel_1.add(ideaHistoryTextField);
		ideaHistoryTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaHistoryTextField.setBounds(10, 10, 117, 20);

		panel_1.add(assertTextField);
		assertTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		assertTextField.setBounds(10, 32, 117, 20);

		panel_1.add(absTextField);
		absTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		absTextField.setBounds(10, 54, 117, 20);

		panel_1.add(searchButton);
		searchButton.addActionListener(new SearchButtonActionListener());
		searchButton.setText("جستجو");
		searchButton.setBounds(142, 107, 106, 26);

		panel_1.add(label_8);
		label_8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_8.setText("شرح اختراع");
		label_8.setBounds(119, 80, 66, 16);

		panel_1.add(invDescTextField);
		invDescTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		invDescTextField.setBounds(10, 78, 117, 20);

		getContentPane().add(scrollPane_1);
		scrollPane_1.setBounds(10, 159, 392, 129);

		scrollPane_1.setViewportView(table);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}

	private class SearchButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			searchButton_actionPerformed(e);
		}
	}

	protected void searchButton_actionPerformed(ActionEvent e) {
		String inventor = inventorTextField.getText();
		String title = invTitleTextField.getText();
		String totalSpec = descTextField.getText();
		String ideaDescription = ideaDescTextField.getText();
		String ideaHistory = ideaHistoryTextField.getText();
		String claim = assertTextField.getText();
		String summary = absTextField.getText();
		String explanation = invDescTextField.getText();

		Map<String, Object> parametersMap = new HashMap<String, Object>();
		if (!inventor.equals("")) {
			parametersMap.put("inventor", inventor);
		}
		if (!title.equals("")) {
			parametersMap.put("title", title);
		}
		if (!totalSpec.equals("")) {
			parametersMap.put("totalSpec", totalSpec);
		}
		if (!ideaDescription.equals("")) {
			parametersMap.put("ideaDescription", ideaDescription);
		}
		if (!ideaHistory.equals("")) {
			parametersMap.put("ideaHistory", ideaHistory);
		}
		if (!claim.equals("")) {
			parametersMap.put("claim", claim);
		}
		if (!summary.equals("")) {
			parametersMap.put("summary", summary);
		}
		if (!explanation.equals("")) {
			parametersMap.put("explanation", explanation);
		}
		List<AbstractInvention> searchResult = inventionCatalog.getInventionsByParameters(parametersMap);

		scrollPane_1.setViewportView(table);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setModel(new TableModel(searchResult));
	}

}
