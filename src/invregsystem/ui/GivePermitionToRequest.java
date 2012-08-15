package invregsystem.ui;

import invregsystem.logic.Request;
import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.invention.InventionRegistrationRequestCatalog;
import invregsystem.logic.member.Message;
import invregsystem.logic.member.MessageCatalog;
import invregsystem.ui.models.ListMouseAdapter;
import invregsystem.ui.models.ListMouseListenner;
import invregsystem.ui.models.NeedRefreshData;
import invregsystem.ui.models.ParameterLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 * @usecase 42
 */

public class GivePermitionToRequest extends JFrame implements NeedRefreshData,
		ListMouseListenner {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2571937414591360868L;
	private JPanel rejectPanel;// s= new JPanel();
	private JPanel acceptPanel;
	private final JButton button = new JButton();
	protected List<InventionRegistrationRequest> requests;
	protected InventionRegistrationRequestCatalog catalogInstance;
	protected boolean removeRequest = false;

	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();

	private final static String[] COLS = new String[] { "نام", "عنوان اختراع" };

	/**
	 * Create the frame
	 */
	public GivePermitionToRequest() {
		super();
		setBounds(100, 100, 653, 410);
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
		setTitle("صدور اجازه‌ی بررسی درخواست ثبت اختراع");

		resetPanels();

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("بازگشت");
		button.setBounds(156, 340, 106, 26);

		getContentPane().add(scrollPane);
		scrollPane.setBounds(185, 76, 411, 244);

		scrollPane.setViewportView(table);

	}

	private class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = GivePermitionToRequest.COLS;
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

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			returnActionPerform(e);
		}
	}

	@Override
	public void listMouseListennerActionPerform(MouseEvent e, Object obj,
			String type) {
		if (type.equals("reject")) {
			this.rejectActionPerform(e, (InventionRegistrationRequest) (obj));
		} else if (type.equals("accept")) {
			this.acceptActionPerform(e, (InventionRegistrationRequest) (obj));
		}
		// JOptionPane.showMessageDialog(this, ((AbstractUser)obj).getId());
	}

	public void refreshData() {
		// TODO Auto-generated method stub
		this.catalogInstance = InventionRegistrationRequestCatalog
				.getInstance();
		this.requests = this.catalogInstance.getInvRegReqsByPermitted(false);
		resetPanels();

		// this.panel = new JPanel();
		for (InventionRegistrationRequest request : this.requests) {
			if (request.getState() == Request.NOT_INVESTIGATED) {
				ParameterLabel<InventionRegistrationRequest> rejectLbl = new ParameterLabel<InventionRegistrationRequest>();

				System.out.println(request);
				rejectLbl.setParameter(request);
				rejectLbl.setPreferredSize(new Dimension(40, 10));
				rejectLbl.setHorizontalTextPosition(SwingConstants.CENTER);
				rejectLbl.setHorizontalAlignment(SwingConstants.CENTER);
				rejectLbl.setForeground(Color.RED);
				rejectLbl
						.addMouseListener(new ListMouseAdapter<InventionRegistrationRequest>(
								request, this, "reject"));
				rejectLbl.setText("رد");

				ParameterLabel<InventionRegistrationRequest> acceptLbl = new ParameterLabel<InventionRegistrationRequest>();
				acceptLbl.setParameter(request);
				acceptLbl.setPreferredSize(new Dimension(40, 10));
				acceptLbl.setHorizontalTextPosition(SwingConstants.CENTER);
				acceptLbl.setHorizontalAlignment(SwingConstants.CENTER);
				acceptLbl.setForeground(Color.GREEN);
				acceptLbl
						.addMouseListener(new ListMouseAdapter<InventionRegistrationRequest>(
								request, this, "accept"));
				acceptLbl.setText("تایید");

				this.acceptPanel.add(acceptLbl);
				this.rejectPanel.add(rejectLbl);
			}

		}
		// /////////////////////////
		// ArrayList<String[]> tableStrs = new ArrayList<String[]>();
		String[][] tableStrs = new String[this.requests.size()][GivePermitionToRequest.COLS.length];

		int i = 0;
		for (InventionRegistrationRequest invReq : this.requests) {
			if (invReq.getState() == Request.NOT_INVESTIGATED) {
				tableStrs[i][0] = invReq.getRequester().getFullName();
				tableStrs[i][1] = invReq.getInvention().getTitle();

				i++;
			}
		}

		this.table.setModel(new TableTableModel(tableStrs));
	}

	private JPanel[] resetPanels() {
		try {
			getContentPane().remove(this.rejectPanel);
			getContentPane().remove(this.acceptPanel);

		} catch (Exception e) {
			// TODO: handle exception
		}

		JPanel p = new JPanel();
		getContentPane().add(p);
		p.setBounds(98, 90, 70, 244);
		this.rejectPanel = p;

		JPanel p2 = new JPanel();
		getContentPane().add(p2);
		p2.setBounds(10, 90, 64, 244);
		this.acceptPanel = p2;

		// /////////////////////////////////////

		return new JPanel[] { p, p2 };
	}

	protected void returnActionPerform(ActionEvent e) {
		this.setVisible(false);
		this.dispose();
	}

	protected void acceptActionPerform(MouseEvent e,
			InventionRegistrationRequest request) {

		JLabel mes = new JLabel("آیا شما به صدور اجازه مطمئن هستید؟ !");
		int n = JOptionPane.showOptionDialog(this, mes, "تایید",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, null, null);
		// pane.set
		if (n == JOptionPane.YES_OPTION) {
			request.setPermitted(true);
			this.catalogInstance.updateItem(request);
			if (this.removeRequest) {
				this.catalogInstance.removeItem(request);
			}
			MessageCatalog
					.getInstance()
					.addItem(
							new Message(
									"تایید درخواست",
									"با موافقت مدیر سامانه، شما اکنون می‌توانید درخواست ثبت اختراع "
									+request.getInvention().getTitle()+
									" را ارسال کنید.",
									request.getRequester()));
			this.refreshData();
		}
	}

	protected void rejectActionPerform(MouseEvent e,
			InventionRegistrationRequest request) {
		JLabel mes = new JLabel(
				"آیا شما به رد درخواست مطمئن هستید؟ این عمل برگشت پذیر نیست!");
		int n = JOptionPane.showOptionDialog(this, mes, "اخطار",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
				null, null, null);
		// pane.set
		if (n == JOptionPane.YES_OPTION) {
			request.setState(Request.REJECTED);
			this.catalogInstance.updateItem(request);
			if (this.removeRequest) {
				this.catalogInstance.removeItem(request);
			}
			MessageCatalog
			.getInstance()
			.addItem(
					new Message(
							"رد درخواست",
							"با مخالفت مدیر سامانه، شما نمی‌توانید درخواست ثبت اختراع "+
							request.getInvention().getTitle()+
							" را تا زمانی که حداقل یکی دیگر از اختراعاتتان تایید یا رد شود، ارسال کنید.",
							request.getRequester()));

			this.refreshData();
		}
	}

}
