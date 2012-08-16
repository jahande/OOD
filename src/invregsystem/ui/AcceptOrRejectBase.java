package invregsystem.ui;

import invregsystem.AbstractUser;
import invregsystem.logic.Request;
import invregsystem.logic.RequestCatalog;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
import invregsystem.logic.invention.InventionFieldRegistrationRequestCatalog;
import invregsystem.logic.member.Message;
import invregsystem.logic.member.MessageCatalog;
import invregsystem.logic.member.UserCatalog;
import invregsystem.ui.models.ListMouseAdapter;
import invregsystem.ui.models.ListMouseListenner;
import invregsystem.ui.models.NeedRefreshData;
import invregsystem.ui.models.ParameterLabel;
import invregsystem.ui.models.SimpleListModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 * @author rj
 * @usecase 42
 */

public abstract class AcceptOrRejectBase extends JFrame implements
		NeedRefreshData, ListMouseListenner {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2571937414591360868L;
	private JList<String> list = new JList<String>();
	private final JLabel label = new JLabel();
	private JPanel rejectPanel;// s= new JPanel();
	private JPanel acceptPanel;
	// private final JLabel label_1 = new JLabel();
	// private final JLabel label_3 = new JLabel();
	// private final JLabel label_4 = new JLabel();
	// private final JLabel label_5 = new JLabel();
	private final JButton button = new JButton();
	protected List<?> requests;
	protected RequestCatalog catalogInstance;
	protected boolean removeRequest = false;

	/**
	 * Create the frame
	 */
	public AcceptOrRejectBase() {
		super();
		setBounds(100, 100, 511, 410);
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
		setTitle("مشاهده‌ی حوزه‌های اختراع");

		getContentPane().add(label);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("حوزه‌های اختراع:");
		label.setBounds(106, 10, 240, 31);

		resetPanels();

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("بازگشت");
		button.setBounds(156, 340, 106, 26);
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
			this.rejectActionPerform(e, (Request) (obj));
		} else if (type.equals("accept")) {
			this.acceptActionPerform(e, (Request) (obj));
		}
		// JOptionPane.showMessageDialog(this, ((AbstractUser)obj).getId());
	}

	public void refreshData() {
		// TODO Auto-generated method stub
		resetPanels();

		// this.panel = new JPanel();
		for (Object obj : this.requests) {
			Request request = (Request) obj;
			if (request.getState() == Request.NOT_INVESTIGATED) {
				ParameterLabel<Request> rejectLbl = new ParameterLabel<Request>();

				rejectLbl.setParameter(request);
				rejectLbl.setPreferredSize(new Dimension(40, 10));
				rejectLbl.setHorizontalTextPosition(SwingConstants.CENTER);
				rejectLbl.setHorizontalAlignment(SwingConstants.CENTER);
				rejectLbl.setForeground(Color.RED);
				rejectLbl.addMouseListener(new ListMouseAdapter<Request>(
						request, this, "reject"));
				rejectLbl.setText("رد");

				ParameterLabel<Request> acceptLbl = new ParameterLabel<Request>();
				acceptLbl.setParameter(request);
				acceptLbl.setPreferredSize(new Dimension(40, 10));
				acceptLbl.setHorizontalTextPosition(SwingConstants.CENTER);
				acceptLbl.setHorizontalAlignment(SwingConstants.CENTER);
				acceptLbl.setForeground(Color.GREEN);
				acceptLbl.addMouseListener(new ListMouseAdapter<Request>(
						request, this, "accept"));
				acceptLbl.setText("تایید");

				this.acceptPanel.add(acceptLbl);
				this.rejectPanel.add(rejectLbl);
			}

		}
		// /////////////////////////
		try {
			getContentPane().remove(list);

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۲");
			return;
		}
		ArrayList<String> names = new ArrayList<String>();
		for (Object obj : this.requests) {
			Request req = (Request) obj;
			if (req.getState() == Request.NOT_INVESTIGATED) {
				names.add(req.toString());
			}

		}
		list = new JList<String>();
		getContentPane().add(list);
		list.setModel(new SimpleListModel(names));
		list.setBounds(189, 76, 237, 244);

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
		p.setBounds(99, 76, 70, 244);
		this.rejectPanel = p;

		JPanel p2 = new JPanel();
		getContentPane().add(p2);
		p2.setBounds(10, 76, 64, 244);
		this.acceptPanel = p2;

		// /////////////////////////////////////

		return new JPanel[] { p, p2 };
	}

	protected void returnActionPerform(ActionEvent e) {
		this.setVisible(false);
		this.dispose();
	}

	protected void acceptActionPerform(MouseEvent e, Request request) {

		JLabel mes = new JLabel("آیا شما به تایید درخواست مطمئن هستید؟ !");
		int n = JOptionPane.showOptionDialog(this, mes, "تایید",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, null, null);
		// pane.set
		if (n == JOptionPane.YES_OPTION) {
			request.setState(Request.ACCEPTED);
			this.catalogInstance.updateItem(request);
			acceptActionSpecial(request);
			if (this.removeRequest) {
				this.catalogInstance.removeItem(request);
			}
			Message m = this.getAcceptMessage(request);
			if (m != null) {
				MessageCatalog.getInstance().addItem(
						this.getAcceptMessage(request));
			}
			this.refreshData();
		}
	}

	protected void acceptActionSpecial(Request request) {
		
	}

	protected void rejectActionPerform(MouseEvent e, Request request) {
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
			Message m = this.getRejectMessage(request);
			if (m != null) {
				MessageCatalog.getInstance().addItem(
						this.getRejectMessage(request));
			}
			this.refreshData();
		}
	}

	protected  Message getAcceptMessage(Request request){
		return null;
	}

	protected  Message getRejectMessage(Request request){
		return null;
	}

}
