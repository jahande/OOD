package invregsystem.ui;

import interfaces.AbstractInvention;
import interfaces.AbstractUser;
import invregsystem.logic.Request;
import invregsystem.logic.invention.Invention;
import invregsystem.logic.invention.InventionCatalog;
import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.invention.Share;
import invregsystem.logic.invention.operation.InvestigationLogCatalog;
import invregsystem.ui.models.NeedRefreshData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class RequestReportOfUserInventionsView extends JFrame implements NeedRefreshData {

	private ButtonGroup buttonGroup = new ButtonGroup();
	private final JButton button = new JButton();
	private final JLabel label = new JLabel();
	private final JPanel panel = new JPanel();
	private final JComboBox<String> stateCbx = new JComboBox<String>();
	private final JComboBox<String> numCbx = new JComboBox<String>();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_2 = new JLabel();
	private AbstractUser user;

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] { "نام کاربری", "نام",
				"نام خانوادگی", "حوزه اختراع", "وضعیت", "علل ردشدن درخواست",
				"تعداد دفعات ردشدن درخواست" };
		private final String[][] CELLS ;

		public TableTableModel(String[][] cells){
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

	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();

	/**
	 * Create the frame
	 */
	public RequestReportOfUserInventionsView(AbstractUser user) {
		super();
		this.user=user;
		setBounds(100, 100, 393, 410);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("اخذ گزارش کل کاربران");

		getContentPane().add(scrollPane);
		scrollPane.setActionMap(null);
		scrollPane.setBounds(10, 93, 639, 238);

		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
	}

	

	@Override
	public void refreshData() {
		List<AbstractInvention> invs = InventionCatalog.getInstance().getInventionsByInventor(this.user);
		int printItems = 6;
		String[][] invTableStrs = new String[invs.size()][printItems];
		int j = 0;
		for (AbstractInvention inv : invs) {
			invTableStrs[j] = new String[printItems];
			invTableStrs[j][0] = inv.getTitle();
			invTableStrs[j][1] = inv.getInventionField().getName();
			invTableStrs[j][2] =inv.getInventionRegistrationRequest().getStateName();
			invTableStrs[j][3] =inv.getIdeaDescription();
			invTableStrs[j][4] = inv.getSummary();
			invTableStrs[j][5] = Long.toString(inv.getPrice());
			j++;
		}
		this.table.setModel(new TableTableModel(invTableStrs));
		
	}

}
