package invregsystem.ui;

import invregsystem.logic.Request;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
import invregsystem.logic.invention.InventionFieldRegistrationRequest;
import invregsystem.logic.invention.InventionFieldRegistrationRequestCatalog;
import invregsystem.ui.models.NeedRefreshData;
import invregsystem.ui.models.ParameterLabel;
import invregsystem.ui.models.SimpleListModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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

public class AcceptOrRejectAddNewFieldRequest extends JFrame implements
		NeedRefreshData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2571937414591360868L;
	private JList list = new JList();
	private final JLabel label = new JLabel();
	private JPanel panel;// s= new JPanel();
	// private final JLabel label_1 = new JLabel();
	// private final JLabel label_3 = new JLabel();
	// private final JLabel label_4 = new JLabel();
	// private final JLabel label_5 = new JLabel();
	private final JButton button = new JButton();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			AcceptOrRejectAddNewFieldRequest frame = new AcceptOrRejectAddNewFieldRequest();
			frame.refreshData();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public AcceptOrRejectAddNewFieldRequest() {
		super();
		setBounds(100, 100, 393, 410);
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
		label.setBounds(80, 27, 240, 31);

		resetInventionFieldsPanel();

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("بازگشت");
		button.setBounds(156, 340, 106, 26);
	}

	private class Label_1MouseListener extends MouseAdapter {
		private final InventionFieldRegistrationRequest inventionFieldRegistrationRequest;

		private Label_1MouseListener() {
			this.inventionFieldRegistrationRequest = null;
		}

		public Label_1MouseListener(InventionFieldRegistrationRequest infrr) {
			this.inventionFieldRegistrationRequest = infrr;
		}

		public void mouseClicked(MouseEvent e) {
			label_1_mouseClicked(e, this.inventionFieldRegistrationRequest);
		}
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}

	protected void label_1_mouseClicked(MouseEvent e,
			InventionFieldRegistrationRequest infrr) {
		JLabel mes = new JLabel(
				"آیا شما به رد درخواست مطمئن هستید؟ این عمل برگشت پذیر نیست!");
		int n = JOptionPane.showOptionDialog(this, mes, "اخطار",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
				null, null, null);
		// pane.set
		if (n == JOptionPane.YES_OPTION) {
			InventionFieldRegistrationRequestCatalog catalog = null;
			try {
				infrr.setState(Request.REJECTED);
				catalog = InventionFieldRegistrationRequestCatalog
						.getInstance();
				catalog.updateItem(infrr);
				boolean removeRequest = false;
				if (removeRequest) {
					catalog.removeItem(infrr);
				}
				this.refreshData();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۵");
				return;
			}
		}
	}

	public void refreshData() {
		// TODO Auto-generated method stub
		resetInventionFieldsPanel();
		// List<InventionField> inventionFields = null;
		List<InventionFieldRegistrationRequest> inventionFieldRegistrationRequests = null;
		try {
			inventionFieldRegistrationRequests = (List<InventionFieldRegistrationRequest>) (InventionFieldRegistrationRequestCatalog
					.getInstance().getAllItems());
			// inventionFields = (List<InventionField>)
			// (InventionFieldCatalog.getInstance().getAllItems());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۸۶");
			return;
		}

		// this.panel = new JPanel();
		for (InventionFieldRegistrationRequest inventionFieldRegistrationRequest : inventionFieldRegistrationRequests) {
			if ( inventionFieldRegistrationRequest.getState() == Request.NOT_INVESTIGATED) {
				inventionFieldRegistrationRequest.getFieldName();
				ParameterLabel<InventionFieldRegistrationRequest> lbl = new ParameterLabel<InventionFieldRegistrationRequest>();

				lbl.setParameter(inventionFieldRegistrationRequest);
				lbl.setPreferredSize(new Dimension(40, 10));
				lbl.setHorizontalTextPosition(SwingConstants.CENTER);
				lbl.setHorizontalAlignment(SwingConstants.CENTER);
				lbl.setForeground(Color.RED);
				lbl.addMouseListener(new Label_1MouseListener(inventionFieldRegistrationRequest));
				lbl.setText("حذف");

				panel.add(lbl);
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
		ArrayList<String> invFields = new ArrayList<String>();
		for (InventionFieldRegistrationRequest inventionFieldRegistrationRequest2 : inventionFieldRegistrationRequests) {
			invFields.add(inventionFieldRegistrationRequest2.getFieldName());

		}
		list = new JList();
		getContentPane().add(list);
		list.setModel(new SimpleListModel(invFields));
		list.setBounds(83, 75, 237, 244);

	}

	private JPanel resetInventionFieldsPanel() {
		try {
			getContentPane().remove(this.panel);
		} catch (Exception e) {
			// TODO: handle exception
		}

		JPanel p = new JPanel();
		getContentPane().add(p);
		p.setBounds(13, 76, 52, 222);
		this.panel = p;

		// /////////////////////////////////////

		return p;
	}

	protected void button_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
