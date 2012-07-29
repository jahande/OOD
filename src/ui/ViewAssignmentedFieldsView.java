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

import ui.models.SimpleListModel;

/**
 * 
 * @author rj
 * @usecase 38(2)
 */

public class ViewAssignmentedFieldsView extends JFrame {

	private final JList list = new JList();
	private final JLabel label = new JLabel();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ViewAssignmentedFieldsView frame = new ViewAssignmentedFieldsView();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public ViewAssignmentedFieldsView() {
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
		setTitle("مشاهده‌ی حوزه‌های اختصاص داده شده");
		
		getContentPane().add(list);
		ArrayList<String> invFields = new ArrayList<String>();
		invFields.add("ریاضی");
		invFields.add("کامپیوتر");
		invFields.add("فیزیک");
		invFields.add("اقتصاد");
		list.setModel(new SimpleListModel(invFields));
		//list.setModel(null);
		list.setBounds(83, 75, 237, 244);
		
		
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("حوزه‌های اختصاص داده شده به علی علوی:");
		label.setBounds(80, 27, 240, 31);
		getContentPane().add(label);
	}

}
