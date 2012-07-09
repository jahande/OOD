package ui;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class ExpertInvApprove extends JFrame {

	private final JLabel label = new JLabel();
	private final JCheckBox checkBox = new JCheckBox();
	private final JCheckBox checkBox_2 = new JCheckBox();
	private final JCheckBox checkBox_3 = new JCheckBox();
	private final JCheckBox checkBox_4 = new JCheckBox();
	private final JCheckBox checkBox_5 = new JCheckBox();
	private final JPanel panel = new JPanel();
	private final JButton button = new JButton();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ExpertInvApprove frame = new ExpertInvApprove();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public ExpertInvApprove() {
		super();
		setBounds(100, 100, 351, 302);
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
		setTitle("تأیید یا رد درخواست ثبت اختراع");

		getContentPane().add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label
				.setText("هر گزینه در صورتی که انتخاب شده باشد تأیید، و در غیر این صورت رد می شود:");
		label.setBounds(10, 10, 324, 26);

		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(null);
		panel.setBounds(10, 42, 324, 178);

		checkBox.setBounds(104, 10, 210, 24);
		panel.add(checkBox);
		checkBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkBox.setText("اصالت و نوآوری اختراع");

		checkBox_2.setBounds(104, 40, 210, 24);
		panel.add(checkBox_2);
		checkBox_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkBox_2.setText("تکمیل بودن مشخصات کلی اختراع");

		checkBox_3.setBounds(74, 70, 240, 24);
		panel.add(checkBox_3);
		checkBox_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkBox_3.setText("تکمیل بودن مستندات و کافی بودن شرح های اختراع");

		checkBox_4.setBounds(74, 100, 240, 24);
		panel.add(checkBox_4);
		checkBox_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkBox_4
				.setText("انطباق کلی مفاد ادعانامه با مستندات و شرح داده شده");

		checkBox_5.setBounds(104, 133, 210, 24);
		panel.add(checkBox_5);
		checkBox_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkBox_5.addActionListener(new CheckBox_5ActionListener());
		checkBox_5.setText("صحت انتساب نماینده به شرکت");

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("ثبت");
		button.setBounds(141, 228, 48, 26);
	}

	private class CheckBox_5ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			checkBox_5_actionPerformed(e);
		}
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}

	protected void checkBox_5_actionPerformed(ActionEvent e) {
	}

	protected void button_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
