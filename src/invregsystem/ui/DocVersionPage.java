package invregsystem.ui;

import interfaces.AbstractInvention;
import invregsystem.logic.invention.operation.InventionLog;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;

public class DocVersionPage extends JFrame {

	private final JButton retrieveButton = new JButton();
	private final JPanel panel = new JPanel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	private final JLabel label_6 = new JLabel();
	private final JLabel label_7 = new JLabel();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JTextPane descTextPane = new JTextPane();
	private final JScrollPane scrollPane_3 = new JScrollPane();
	private final JTextPane abstractTextPane = new JTextPane();
	private final JScrollPane scrollPane_4 = new JScrollPane();
	private final JTextPane ideaDescTextPane = new JTextPane();
	private final JScrollPane scrollPane_5 = new JScrollPane();
	private final JTextPane ideaHistoryTextPane = new JTextPane();
	private final JScrollPane scrollPane_6 = new JScrollPane();
	private final JTextPane assertTextPane = new JTextPane();
	private final JLabel label_8 = new JLabel();
	private final JScrollPane scrollPane_7 = new JScrollPane();
	private final JTextPane fullDescTextPane = new JTextPane();
	private final JTextField fileTextField1 = new JTextField();
	private final JTextField fileTextField2 = new JTextField();
	private final JTextField fileTextField3 = new JTextField();
	private final JPanel panel_2 = new JPanel();
	private final JLabel label_9 = new JLabel();
	private final JScrollPane scrollPane_8 = new JScrollPane();
	private final JTextArea textArea_1 = new JTextArea();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTable table_1 = new JTable();

	private InventionLog invLog;

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] { "تاریخ", "شخص ویرایش کننده", };
		private InventionLog invLog;

		public TableTableModel(InventionLog invLog) {
			this.invLog = invLog;
		}

		public int getRowCount() {
			return 1;
		}

		public int getColumnCount() {
			return COLUMNS.length;
		}

		public String getColumnName(int column) {
			return COLUMNS[column];
		}

		public Object getValueAt(int row, int column) {
			if (row == 0) {
				if (column == 0) {
					return invLog.getChangeDate().toString();
				} else if (column == 1) {
					if (invLog.getEditorUser() != null) {
						return invLog.getEditorUser().getFullName();
					} else {
						return "(نسخه اولیه)";
					}
				}
			}
			return "ERROR";
		}
	}

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			DocVersionPage frame = new DocVersionPage(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public DocVersionPage(InventionLog invLog) {
		super();
		this.invLog = invLog;
		setBounds(100, 100, 624, 680);
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
		setTitle("نسخه مستندات");

		AbstractInvention invention = invLog.getInventionVersion();

		getContentPane().add(scrollPane_1);
		scrollPane_1.setBounds(389, 23, 219, 43);

		scrollPane_1.setViewportView(table_1);
		table_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table_1.setModel(new TableTableModel(invLog));
		table_1.setRowHeight(20);

		getContentPane().add(retrieveButton);
		retrieveButton.addActionListener(new RetrieveButtonActionListener());
		retrieveButton.setText("بازیابی نسخه");
		retrieveButton.setBounds(439, 271, 106, 26);

		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(null);
		panel.setBounds(10, 23, 373, 600);

		panel.add(label_1);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setText("مشخصات کلی");
		label_1.setBounds(34, 10, 0, 0);

		panel.add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("مشخصات کلی");
		label_2.setBounds(297, 10, 66, 16);

		panel.add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("چکیده");
		label_3.setBounds(297, 88, 66, 16);

		panel.add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("شرح ایده");
		label_4.setBounds(297, 166, 66, 16);

		panel.add(label_5);
		label_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_5.setText("سابقه ایده");
		label_5.setBounds(297, 246, 66, 16);

		panel.add(label_6);
		label_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_6.setText("ادعانامه");
		label_6.setBounds(297, 324, 66, 16);

		panel.add(label_7);
		label_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_7.setText("شرح کامل");
		label_7.setBounds(297, 402, 66, 16);

		panel.add(scrollPane_2);
		scrollPane_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_2.setBounds(10, 32, 353, 50);

		scrollPane_2.setViewportView(descTextPane);
		descTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		descTextPane.setText(invention.getTotalSpec());
		descTextPane.setEditable(false);

		panel.add(scrollPane_3);
		scrollPane_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_3.setBounds(10, 110, 353, 50);

		scrollPane_3.setViewportView(abstractTextPane);
		abstractTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		abstractTextPane.setText(invention.getSummary());
		abstractTextPane.setEditable(false);

		panel.add(scrollPane_4);
		scrollPane_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_4.setBounds(10, 188, 353, 50);

		scrollPane_4.setViewportView(ideaDescTextPane);
		ideaDescTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaDescTextPane.setText(invention.getIdeaDescription());
		ideaDescTextPane.setEditable(false);

		panel.add(scrollPane_5);
		scrollPane_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_5.setBounds(10, 268, 353, 50);

		scrollPane_5.setViewportView(ideaHistoryTextPane);
		ideaHistoryTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaHistoryTextPane.setText(invention.getIdeaHistory());
		ideaHistoryTextPane.setEditable(false);

		panel.add(scrollPane_6);
		scrollPane_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_6.setBounds(10, 346, 353, 50);

		scrollPane_6.setViewportView(assertTextPane);
		assertTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		assertTextPane.setText(invention.getClaim());
		assertTextPane.setEditable(false);

		panel.add(label_8);
		label_8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_8.setText("فایل های پیوست");
		label_8.setBounds(297, 480, 66, 16);

		panel.add(scrollPane_7);
		scrollPane_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_7.setBounds(10, 424, 353, 50);

		scrollPane_7.setViewportView(fullDescTextPane);
		fullDescTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		fullDescTextPane.setText(invention.getExplanation());
		fullDescTextPane.setEditable(false);

		panel.add(fileTextField1);
		if (invention.getFile1() != null) {
			fileTextField1.setText(invention.getFile1());
		}
		fileTextField1.setEditable(false);
		fileTextField1.setBounds(10, 497, 353, 20);

		panel.add(fileTextField2);
		if (invention.getFile2() != null) {
			fileTextField2.setText(invention.getFile2());
		}
		fileTextField2.setEditable(false);
		fileTextField2.setBounds(10, 527, 353, 20);

		panel.add(fileTextField3);
		if (invention.getFile3() != null) {
			fileTextField3.setText(invention.getFile3());
		}
		fileTextField3.setEditable(false);
		fileTextField3.setBounds(10, 557, 353, 20);

		getContentPane().add(panel_2);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel_2.setLayout(null);
		panel_2.setBounds(389, 81, 219, 172);

		panel_2.add(label_9);
		label_9.setText("توضیح برای ویرایش:");
		label_9.setBounds(114, 6, 95, 16);

		panel_2.add(scrollPane_8);
		scrollPane_8.setBounds(10, 28, 199, 134);

		scrollPane_8.setViewportView(textArea_1);
		textArea_1.setText(invLog.getComment());
		textArea_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textArea_1.setEditable(false);
	}

	private class RetrieveButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			retrieveButton_actionPerformed(e);
		}
	}

	protected void retrieveButton_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
