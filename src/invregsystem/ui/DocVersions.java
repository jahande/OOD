package invregsystem.ui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class DocVersions extends JFrame {

	private final JButton displayButton = new JButton();
	private final JButton displayButton_1 = new JButton();
	private final JButton displayButton_2 = new JButton();
	private final JButton displayButton_3 = new JButton();
	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] {
			"تاریخ",
			"شخص ویرایش کننده",
		};
		private final String[][] CELLS = new String[][] {
			{"1390/2/2", "حسین فرقانی"},
			{"1390/12/4", "حسین فرقانی"},
			{"1391/1/15", "روح الله جهنده"},
			{"1391/1/27", "روح الله جهنده"},
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
			DocVersions frame = new DocVersions();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public DocVersions() {
		super();
		setBounds(100, 100, 489, 183);
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
		setTitle("نسخه های مستندات اختراع");
		
		getContentPane().add(scrollPane);
		scrollPane.setBounds(87, 23, 383, 106);
		
		table.setModel(new TableTableModel());
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setRowHeight(20);
		scrollPane.setViewportView(table);
		
		getContentPane().add(displayButton);
		displayButton.setBorderPainted(false);
		displayButton.setForeground(new Color(0, 0, 255));
		displayButton.setText("مشاهده");
		displayButton.setContentAreaFilled(false);
		displayButton.addActionListener(new DisplayButtonActionListener());
		displayButton.setBounds(10, 43, 71, 15);
		
		getContentPane().add(displayButton_1);
		displayButton_1.setForeground(new Color(0, 0, 255));
		displayButton_1.setText("مشاهده");
		displayButton_1.setContentAreaFilled(false);
		displayButton_1.setBorderPainted(false);
		displayButton_1.addActionListener(new DisplayButtonActionListener());
		displayButton_1.setBounds(10, 63, 71, 15);
		
		getContentPane().add(displayButton_2);
		displayButton_2.setText("مشاهده");
		displayButton_2.setForeground(new Color(0, 0, 255));
		displayButton_2.setContentAreaFilled(false);
		displayButton_2.setBorderPainted(false);
		displayButton_2.addActionListener(new DisplayButtonActionListener());
		displayButton_2.setBounds(10, 83, 71, 15);
		
		getContentPane().add(displayButton_3);
		displayButton_3.setForeground(new Color(0, 0, 255));
		displayButton_3.setText("مشاهده");
		displayButton_3.setContentAreaFilled(false);
		displayButton_3.setBorderPainted(false);
		displayButton_3.addActionListener(new DisplayButtonActionListener());
		displayButton_3.setBounds(10, 103, 71, 15);
	}
	private class DisplayButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			displayButton_actionPerformed(e);
		}
	}
	protected void displayButton_actionPerformed(ActionEvent e) {
		new DocVersionPage().setVisible(true);
	}

}
