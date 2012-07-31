package invregsystem.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 * @usecase 29
 * */

public class AcceptOrRejectCreateUserAccount extends JFrame {

	private final JPanel panel = new JPanel();
	private final JLabel label = new JLabel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	private final JLabel label_6 = new JLabel();
	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] {
			"نام کاربری", "نام", "نام خانوادگی", "ایمیل", "تاریخ تولد"
		};
		private final String[][] CELLS = new String[][] {
			{"alialavi", "علوی", "علی", "alialavi@yahoo.com", "۱۳۶۵"},
			{"hforghani", "حسین", "فرقانی", "hforghani@gmail.com", "۱۳۶۹"},
			{"rjahande", "روح الله", "جهنده", "r.jahande@gmail.com", "۱۳۶۸"},
			
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
			AcceptOrRejectCreateUserAccount frame = new AcceptOrRejectCreateUserAccount();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public AcceptOrRejectCreateUserAccount() {
		super();
		setBounds(100, 100, 601, 375);
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
		setTitle("تایید یا رد درخواست ثبت شرکت");
		
		getContentPane().add(scrollPane);
		scrollPane.setBounds(111, 37, 443, 273);
		
		table.hashCode();
		table.setModel(new TableTableModel());
		scrollPane.setViewportView(table);
		
		getContentPane().add(panel);
		panel.setBounds(67, 53, 20, 257);
		
		panel.add(label);
		label.addMouseListener(new LabelMouseListener());
		label.setForeground(Color.RED);
		label.setPreferredSize(new Dimension(10, 10));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("رد");
		
		panel.add(label_5);
		label_5.setPreferredSize(new Dimension(10, 10));
		label_5.setHorizontalTextPosition(SwingConstants.CENTER);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.RED);
		label_5.setText("رد");
		
		panel.add(label_6);
		label_6.setPreferredSize(new Dimension(10, 10));
		label_6.setHorizontalTextPosition(SwingConstants.CENTER);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.RED);
		label_6.setText("رد");
		
		getContentPane().add(panel_1);
		panel_1.setBounds(18, 53, 28, 257);
		
		panel_1.add(label_1);
		label_1.addMouseListener(new Label_1MouseListener());
		label_1.setForeground(new Color(0, 128, 0));
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setPreferredSize(new Dimension(20, 10));
		label_1.setText("تایید");
		
		panel_1.add(label_3);
		label_3.setPreferredSize(new Dimension(20, 10));
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(0, 128, 0));
		label_3.setText("تایید");
		
		panel_1.add(label_4);
		label_4.setPreferredSize(new Dimension(20, 10));
		label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 128, 0));
		label_4.setText("تایید");
	}
	private class LabelMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			label_mouseClicked(e);
		}
	}
	private class Label_1MouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			label_1_mouseClicked(e);
		}
	}
	protected void label_mouseClicked(MouseEvent e) {
		JLabel mes = new JLabel("آیا شما به رد درخواست مطمئن هستید؟ این عمل باعث حذف درخواست می‌شود.!");
		int n = JOptionPane.showOptionDialog(this, mes,"اخطار",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,null,null);
	     //pane.set
	}
	protected void label_1_mouseClicked(MouseEvent e) {
	   JOptionPane.showConfirmDialog(this, "در صورت تایید حساب ایجاد و رمز به ایمیل کاربر فرستاده می‌شود. آیا تایید می‌کنید؟","",JOptionPane.OK_CANCEL_OPTION);
	}

}
