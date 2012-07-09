package ui;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListDataListener;

import uimodels.SimpleListModel;


/**
 * 
 * @author rj
 * @usecase 43
 * 
 */
public class ViewInventionFields extends JFrame {

	private final JList list = new JList();
	private final JLabel label = new JLabel();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ViewInventionFields frame = new ViewInventionFields();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public ViewInventionFields() {
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
	}

}
