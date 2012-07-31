package invregsystem.ui;

import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
import invregsystem.ui.models.IdLabel;
import invregsystem.ui.models.NeedRefreshData;
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

public class DeleteInventionField extends JFrame implements NeedRefreshData {

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
			DeleteInventionField frame = new DeleteInventionField();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public DeleteInventionField() {
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

		/*
		 * panel.add(label_1); label_1.addMouseListener(new
		 * Label_1MouseListener());
		 * label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		 * label_1.setHorizontalAlignment(SwingConstants.CENTER);
		 * label_1.setForeground(Color.RED); label_1.setPreferredSize(new
		 * Dimension(40, 10)); label_1.setText("حذف");
		 * 
		 * panel.add(label_3); label_3.setPreferredSize(new Dimension(40, 10));
		 * label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		 * label_3.setHorizontalAlignment(SwingConstants.CENTER);
		 * label_3.setForeground(Color.RED); label_3.setText("حذف");
		 * 
		 * panel.add(label_4); label_4.setPreferredSize(new Dimension(40, 10));
		 * label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		 * label_4.setHorizontalAlignment(SwingConstants.CENTER);
		 * label_4.setForeground(Color.RED); label_4.setText("حذف");
		 * 
		 * panel.add(label_5); label_5.setPreferredSize(new Dimension(40, 10));
		 * label_5.setHorizontalTextPosition(SwingConstants.CENTER);
		 * label_5.setHorizontalAlignment(SwingConstants.CENTER);
		 * label_5.setForeground(Color.RED); label_5.setText("حذف");
		 */
	}

	private class Label_1MouseListener extends MouseAdapter {
		private final InventionField inventionField;

		private Label_1MouseListener() {
			inventionField = null;
		}

		public Label_1MouseListener(InventionField inf) {
			this.inventionField = inf;
		}

		public void mouseClicked(MouseEvent e) {
			label_1_mouseClicked(e, this.inventionField);
		}
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}

	protected void label_1_mouseClicked(MouseEvent e, InventionField inf) {
		JLabel mes = new JLabel("آیا شما به حذف حوزه‌ی اختراع مطمئن هستید؟ این عمل برگشت پذیر نیست!");
		int n = JOptionPane.showOptionDialog(this, mes, "اخطار", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
		// pane.set
		if (n == JOptionPane.YES_OPTION) {
			InventionFieldCatalog catalog = null;
			try {
				catalog = InventionFieldCatalog.getInstance();
				catalog.removeItem(inf);
				this.refreshData(new Object[] { catalog.getAllItems() });
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۵");
				return;
			}
		}
	}

	public void refreshData(Object obj) {
		// TODO Auto-generated method stub
		resetInventionFieldsPanel();
		List<InventionField> inventionFields = null;
		try {
			inventionFields = (List<InventionField>) ((Object[]) obj)[0];
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۱");
			return;
		}

		// this.panel = new JPanel();
		for (InventionField inventionField : inventionFields) {
			IdLabel lbl = new IdLabel();

			lbl.setId(inventionField.getId());
			lbl.setPreferredSize(new Dimension(40, 10));
			lbl.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			lbl.setForeground(Color.RED);
			lbl.addMouseListener(new Label_1MouseListener(inventionField));
			lbl.setText("حذف");

			panel.add(lbl);

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
		for (InventionField inventionField2 : inventionFields) {
			invFields.add(inventionField2.getName());

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
