package ui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 *
 * @usecase 45
 */

public class RequestAllUsersReport extends JFrame {

	private ButtonGroup buttonGroup = new ButtonGroup();
	private final JButton button = new JButton();
	private final JLabel label = new JLabel();
	private final JPanel panel = new JPanel();
	private final JRadioButton radioButton = new JRadioButton();
	private final JRadioButton radioButton_1 = new JRadioButton();
	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] {
			"نام کاربری","نام","نام خانوادگی", "حوزه اختراع", "وضعیت","علل ردشدن درخواست","تعداد دفعات ردشدن درخواست"
		};
		private final String[][] CELLS = new String[][] {
			{"rjahande", "روح الله","جهنده", "ریاضی", "درحال بررسی", "", "۰"},
			{"hforghani", "حسین","فرقانی", "کامپیوتر", "تایید شده", "", "۰"},
			{"alialavi", "علی","علوی", "فیزیک", "درحال بررسی", "کامل نبودن مدارک- تکراری بودن ایده", "۲"},
			
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
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			RequestAllUsersReport frame = new RequestAllUsersReport();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public RequestAllUsersReport() {
		super();
		setBounds(100, 100, 667, 436);
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
		setTitle("اخذ گزارش کل کاربران");
		
		getContentPane().add(scrollPane);
		scrollPane.setActionMap(null);
		scrollPane.setBounds(10, 93, 639, 238);
		
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionModel(new ListSelectionModel(){

			public void addListSelectionListener(ListSelectionListener x) {
				// TODO Auto-generated method stub
				
			}

			public void addSelectionInterval(int index0, int index1) {
				// TODO Auto-generated method stub
				
			}

			public void clearSelection() {
				// TODO Auto-generated method stub
				
			}

			public int getAnchorSelectionIndex() {
				// TODO Auto-generated method stub
				return 0;
			}

			public int getLeadSelectionIndex() {
				// TODO Auto-generated method stub
				return 0;
			}

			public int getMaxSelectionIndex() {
				// TODO Auto-generated method stub
				return 0;
			}

			public int getMinSelectionIndex() {
				// TODO Auto-generated method stub
				return 0;
			}

			public int getSelectionMode() {
				// TODO Auto-generated method stub
				return 0;
			}

			public boolean getValueIsAdjusting() {
				// TODO Auto-generated method stub
				return false;
			}

			public void insertIndexInterval(int index, int length,
					boolean before) {
				// TODO Auto-generated method stub
				
			}

			public boolean isSelectedIndex(int index) {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean isSelectionEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			public void removeIndexInterval(int index0, int index1) {
				// TODO Auto-generated method stub
				
			}

			public void removeListSelectionListener(ListSelectionListener x) {
				// TODO Auto-generated method stub
				
			}

			public void removeSelectionInterval(int index0, int index1) {
				// TODO Auto-generated method stub
				
			}

			public void setAnchorSelectionIndex(int index) {
				// TODO Auto-generated method stub
				
			}

			public void setLeadSelectionIndex(int index) {
				// TODO Auto-generated method stub
				
			}

			public void setSelectionInterval(int index0, int index1) {
				// TODO Auto-generated method stub
				
			}

			public void setSelectionMode(int selectionMode) {
				// TODO Auto-generated method stub
				
			}

			public void setValueIsAdjusting(boolean valueIsAdjusting) {
				// TODO Auto-generated method stub
				
			}
			
		});
		table.setModel(new TableTableModel());
		
		getContentPane().add(button);
		button.setText("اخذ گزارش");
		button.setBounds(191, 354, 106, 26);
		
		getContentPane().add(label);
		label.setText("تفکیک براساس:");
		label.setBounds(358, 17, 106, 26);
		
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBounds(21, 20, 331, 47);
		
		panel.add(radioButton);
		radioButton.setSelected(true);
		buttonGroup.add(radioButton);
		radioButton.setText("وضعیت");
		radioButton.setBounds(218, 10, 113, 23);
		
		panel.add(radioButton_1);
		radioButton_1.setSelected(true);
		buttonGroup.add(radioButton_1);
		radioButton_1.setText("حوزه اختراع");
		radioButton_1.setBounds(99, 10, 113, 23);
	}

}
