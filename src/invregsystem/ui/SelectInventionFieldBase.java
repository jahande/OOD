package invregsystem.ui;

import invregsystem.AbstractInvention;
import invregsystem.AbstractUser;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
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

public abstract class SelectInventionFieldBase extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2571937414591360868L;
	private JList list = new JList();
	private final JLabel label = new JLabel();
	protected JPanel panel;// s= new JPanel();
	// private final JLabel label_1 = new JLabel();
	// private final JLabel label_3 = new JLabel();
	// private final JLabel label_4 = new JLabel();
	// private final JLabel label_5 = new JLabel();
	private final JButton button = new JButton();
	
	protected List<InventionField> inventionFields;
	
	protected final Color actionListColor;
	protected final String actionListText;
	


	/**
	 * Create the frame
	 */
	public SelectInventionFieldBase(Color color,String str) {
		super();
		this.actionListColor = color;
		this.actionListText = str;
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
			nextActionPerform(e, this.inventionField);
		}
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			returnActionPerform(e);
		}
	}

	

	public void refreshData() {
		resetInventionFieldsPanel();
		// this.panel = new JPanel();
		for (InventionField inventionField : this.inventionFields) {
			ParameterLabel<InventionField> lbl = new ParameterLabel<InventionField>();

			lbl.setParameter(inventionField);
			lbl.setPreferredSize(new Dimension(40, 12));
			lbl.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			lbl.setForeground(this.actionListColor);
			lbl.addMouseListener(new Label_1MouseListener(inventionField));
			lbl.setText(this.actionListText);

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
		for (InventionField inventionField2 : this.inventionFields) {
			invFields.add(inventionField2.getName());

		}
		list = new JList();
		getContentPane().add(list);
		list.setModel(new SimpleListModel(invFields));
		list.setBounds(83, 75, 237, 244);

	}

	protected JPanel resetInventionFieldsPanel() {
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

	protected void returnActionPerform(ActionEvent e) {
		this.setVisible(false);
	}
	protected abstract void nextActionPerform(MouseEvent e, InventionField user) ;


}
