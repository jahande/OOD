package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

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

import logic.invention.InventionField;

import uimodels.IdLabel;
import uimodels.NeedRefreshData;
import uimodels.SimpleListModel;

/**
 * 
 * @author rj
 * @usecase 42
 */

public class DeleteInventionField extends JFrame implements NeedRefreshData{

	private  JList list = new JList();
	private final JLabel label = new JLabel();
	private JPanel panel ;//s= new JPanel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	private ArrayList<JLabel> delLbls = new ArrayList<JLabel>();
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
		
		/*panel.add(label_1);
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
		label_5.setText("حذف");*/
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

	public void refreshData(Object obj) {
		// TODO Auto-generated method stub
		resetInventionFieldsPanel();
		ArrayList<InventionField> inventionFields = (ArrayList<InventionField>)((Object[])obj)[0];
		this.panel = new JPanel();
		for (InventionField inventionField : inventionFields) {
			IdLabel lbl = new IdLabel();
			
			lbl.setId(inventionField.getId());
			lbl.setPreferredSize(new Dimension(40, 10));
			lbl.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			lbl.setForeground(Color.RED);
			lbl.setText("حذف");
			
			
			panel.add(lbl);
			
			
		}
		///////////////////////////
		try {
			getContentPane().remove(list);
			
		} catch (Exception e) {
			// TODO: handle exception
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
//	private JList resetInventionFieldsNamePanel(){
//		try {
//			getContentPane().remove(list);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		//ArrayList<String> invFields = new ArrayList<String>();
//		/*invFields.add(inven);
//		invFields.add("کامپیوتر");
//		invFields.add("فیزیک");
//		invFields.add("اقتصاد");*/
//		list.setModel(new SimpleListModel(invFields));
//		//list.setModel(null);
//		list.setBounds(83, 75, 237, 244);
//	}
	private JPanel resetInventionFieldsPanel(){
		try {
			getContentPane().remove(this.panel);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		JPanel p = new JPanel();
		getContentPane().add(p);
		p.setBounds(13, 76, 52, 222);
		this.panel = p;
		
		///////////////////////////////////////
		
		return p;
	}

}
