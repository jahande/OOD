package invregsystem.ui;

import invregsystem.ui.models.SimpleListModel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListDataListener;


/**
 * 
 * @author rj
 * @usecase 41
 * 
 * also base class for 36
 */

public class SelectInventionField extends JFrame {

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
			SelectInventionField frame = new SelectInventionField();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public SelectInventionField() {
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
		panel.setBounds(15, 76, 52, 227);
		
		panel.add(label_1);
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLUE);
		label_1.setPreferredSize(new Dimension(40, 10));
		label_1.setText("انتخاب");
		
		panel.add(label_3);
		label_3.setPreferredSize(new Dimension(40, 10));
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLUE);
		label_3.setText("انتخاب");
		
		panel.add(label_4);
		label_4.setPreferredSize(new Dimension(40, 10));
		label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.BLUE);
		label_4.setText("انتخاب");
		
		panel.add(label_5);
		label_5.setPreferredSize(new Dimension(40, 10));
		label_5.setHorizontalTextPosition(SwingConstants.CENTER);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.BLUE);
		label_5.setText("انتخاب");
	}

}
