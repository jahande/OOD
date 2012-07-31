package invregsystem.ui;

import invregsystem.logic.invention.InventionField;
import invregsystem.ui.models.NeedRefreshData;
import invregsystem.ui.models.SimpleListModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;



/**
 * 
 * @author rj
 * @usecase 42
 */

public class ViewInventionFields extends JFrame implements NeedRefreshData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5082707021067791884L;
	private JList list = null;
	private final JLabel label = new JLabel();
	// private final JLabel label_1 = new JLabel();
	// private final JLabel label_3 = new JLabel();
	// private final JLabel label_4 = new JLabel();
	// private final JLabel label_5 = new JLabel();
	private final JButton button = new JButton();

	/**
	 * Create the frame
	 */
	public ViewInventionFields() {
		super();
		setBounds(100, 100, 393, 410);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("مشاهده‌ی حوزه‌های اختراع");

		getContentPane().add(label);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("حوزه‌های اختراع:");
		label.setBounds(80, 27, 240, 31);

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

	public void refreshData(Object obj) {
		// TODO Auto-generated method stub
		List<InventionField> inventionFields = null;
		try {
			inventionFields = (List<InventionField>) ((Object[]) obj)[0];
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۳۳");
			return;
		}

		// /////////////////////////
		try {
			if (this.list != null) {
				getContentPane().remove(this.list);
			}

		} catch (Exception e) {
			// TODO: handle exception
			// JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۳۴");
			// return;
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

	// private JList resetInventionFieldsNamePanel(){
	// try {
	// getContentPane().remove(list);
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// //ArrayList<String> invFields = new ArrayList<String>();
	// /*invFields.add(inven);
	// invFields.add("کامپیوتر");
	// invFields.add("فیزیک");
	// invFields.add("اقتصاد");*/
	// list.setModel(new SimpleListModel(invFields));
	// //list.setModel(null);
	// list.setBounds(83, 75, 237, 244);
	// }

	protected void button_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
