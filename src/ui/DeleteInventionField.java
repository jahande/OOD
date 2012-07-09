package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListDataListener;

import uimodels.SimpleListModel;

/**
 * 
 * @author rj
 * @usecase 42
 */

public class DeleteInventionField extends JFrame {

	private final JList list = new JList();
	private final JLabel label = new JLabel();
	private final JPanel panel = new JPanel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	/**
	 * Launch the application
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
		setBounds(100, 100, 393, 379);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		getContentPane().add(list);
		ArrayList<String> invFields = new ArrayList<String>();
		invFields.add("ریاضی");
		invFields.add("کامپیوتر");
		invFields.add("فیزیک");
		invFields.add("اقتصاد");
		list.setModel(new SimpleListModel(invFields));
		//list.setModel(null);
		list.setBounds(83, 75, 237, 244);
		
		getContentPane().add(label);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("حوزه‌های اختراع:");
		label.setBounds(80, 27, 240, 31);
		
		getContentPane().add(panel);
		panel.setBounds(13, 76, 52, 222);
		
		panel.add(label_1);
		label_1.addMouseListener(new Label_1MouseListener());
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setPreferredSize(new Dimension(40, 10));
		label_1.setText("حذف");
		
		panel.add(label_3);
		label_3.setPreferredSize(new Dimension(40, 10));
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.RED);
		label_3.setText("حذف");
		
		panel.add(label_4);
		label_4.setPreferredSize(new Dimension(40, 10));
		label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.RED);
		label_4.setText("حذف");
		
		panel.add(label_5);
		label_5.setPreferredSize(new Dimension(40, 10));
		label_5.setHorizontalTextPosition(SwingConstants.CENTER);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.RED);
		label_5.setText("حذف");
	}
	private class Label_1MouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			label_1_mouseClicked(e);
		}
	}
	protected void label_1_mouseClicked(MouseEvent e) {
		JLabel mes = new JLabel("آیا شما به حذف حوزه‌ی اختراع مطمئن هستید؟ این عمل برگشت پذیر نیست!");
		int n = JOptionPane.showOptionDialog(this, mes,"اخطار",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,null,null);
	     //pane.set
	}

}
