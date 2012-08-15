package invregsystem.ui;

import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
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

public class DeleteInventionField extends SelectInventionFieldBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2571937414591360868L;
	private JList list = new JList();
	private final JLabel label = new JLabel();
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
		super(Color.RED,"حذف");
		setBounds(100, 100, 393, 410);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			inventionFields = (List<InventionField>) (InventionFieldCatalog.getInstance().getAllItems());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۱");
			return;
		}
		//
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("حذف حوزه‌های اختراع");

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

	

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}


	
	

	protected void button_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

	@Override
	protected void nextActionPerform(MouseEvent e, InventionField inf) {
		// TODO Auto-generated method stub
		JLabel mes = new JLabel("آیا شما به حذف حوزه‌ی اختراع مطمئن هستید؟ این عمل برگشت پذیر نیست!");
		int n = JOptionPane.showOptionDialog(this, mes, "اخطار", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
		// pane.set
		if (n == JOptionPane.YES_OPTION) {
			InventionFieldCatalog catalog = null;
			try {
				catalog = InventionFieldCatalog.getInstance();
				catalog.removeItem(inf);
				this.setVisible(false);
				this.dispose();
				//this.refreshData();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۵");
				return;
			}
		}
		
	}


}
