package invregsystem.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

/**
 * 
 * @author rj
 * @usecase 35
 */

public class AssignInventionField extends JFrame {

	private final JComboBox comboBox = new JComboBox();
	private final JComboBox comboBox_1 = new JComboBox();
	private final JButton button = new JButton();
	private final JLabel label = new JLabel();
	private final JLabel label_1 = new JLabel();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			AssignInventionField frame = new AssignInventionField();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public AssignInventionField() {
		super();
		setBounds(100, 100, 500, 250);
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
		setTitle("اختصاص حوزه‌ی کارشناسی ");
		
		getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"احسان کارشناس زاده", "احسان کارشناس پور"}));
		comboBox.setBounds(89, 102, 132, 31);
		
		getContentPane().add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"ریاضی", "کامپیوتر", "نجوم", "فیزیک"}));
		comboBox_1.setBounds(268, 101, 142, 31);
		
		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("اختصاص حوزه‌ی کارشناسی به کارشناس یا کاربر");
		button.setBounds(119, 163, 255, 26);
		
		getContentPane().add(label);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("نام کارشناس یا کاربر");
		label.setBounds(86, 53, 135, 31);
		
		getContentPane().add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setText("حوزه‌ی کارشناسی");
		label_1.setBounds(265, 53, 142, 31);
	}

	/**
	 * WindowBuilder generated method.<br>
	 * Please don't remove this method or its invocations.<br>
	 * It used by WindowBuilder to associate the {@link javax.swing.JPopupMenu} with parent.
	 */
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger())
					showMenu(e);
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger())
					showMenu(e);
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}
	protected void button_actionPerformed(ActionEvent e) {
		if(Math.random()<0.5)
		JOptionPane.showMessageDialog(this, "کارشناس قبلا در این حوزه کارشناسی می‌کرده.");
	}
	
}
