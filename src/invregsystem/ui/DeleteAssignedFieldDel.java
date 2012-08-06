package invregsystem.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
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
 * @usecase 37(2)
 */
@Deprecated
public class DeleteAssignedFieldDel extends JFrame {

	private final JLabel label = new JLabel();
	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] {
			"حوزه‌ی اختصاص داده شده"
		};
		private final String[][] CELLS = new String[][] {
			{"فیزیک"},
			{"شیمی"},
			{"نجوم"},
			{"کامپیوتر"},
			{"ریاضی"},
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
	private final JPanel panel = new JPanel();
	private final JLabel xLabel = new JLabel();
	private final JLabel xLabel_1 = new JLabel();
	private final JLabel xLabel_2 = new JLabel();
	private final JLabel xLabel_3 = new JLabel();
	private final JLabel xLabel_4 = new JLabel();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			DeleteAssignedFieldDel frame = new DeleteAssignedFieldDel();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public DeleteAssignedFieldDel() {
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
		setTitle("حذف حوزه‌ی اختصاص داده شده");
		
		getContentPane().add(scrollPane);
		scrollPane.setBounds(134, 62, 329, 209);
		
		table.hashCode();
		table.setModel(new TableTableModel());
		table.setEditingColumn(0);
		table.setEditingRow(0);
		scrollPane.setViewportView(table);
		
		getContentPane().add(panel);
		panel.setBounds(83, 77, 26, 194);
		
		panel.add(xLabel);
		xLabel.addMouseListener(new XLabelMouseListener());
		xLabel.setPreferredSize(new Dimension(20, 10));
		xLabel.setForeground(Color.RED);
		xLabel.setText("حذف");
		
		panel.add(xLabel_1);
		xLabel_1.setPreferredSize(new Dimension(20, 10));
		xLabel_1.setForeground(Color.RED);
		xLabel_1.setText("حذف");
		
		panel.add(xLabel_2);
		xLabel_2.setPreferredSize(new Dimension(20, 10));
		xLabel_2.setForeground(Color.RED);
		xLabel_2.setText("حذف");
		
		panel.add(xLabel_3);
		xLabel_3.setPreferredSize(new Dimension(20, 10));
		xLabel_3.setForeground(Color.RED);
		xLabel_3.setText("حذف");
		
		panel.add(xLabel_4);
		xLabel_4.setPreferredSize(new Dimension(20, 10));
		xLabel_4.setForeground(Color.RED);
		xLabel_4.setText("حذف");
		
		getContentPane().add(label);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("حوزه‌های اختصاص داده شده به کارشناس آقای علی علوی");
		label.setBounds(134, 22, 329, 31);
	}
	private class XLabelMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			xLabel_mouseClicked(e);
		}
	}
	protected void xLabel_mouseClicked(MouseEvent e) {
		JLabel mes = new JLabel("آیا شما به حذف حوزه‌ی اختصاص داده شده مطمئن هستید؟ این عمل برگشت پذیر نیست!");
		int n = JOptionPane.showOptionDialog(this, mes,"اخطار",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,null,null);
	     //pane.set
	     
	}

}
