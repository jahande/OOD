package invregsystem.ui;

import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.member.User;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class ExpertInvApprove extends JFrame {

	private final JLabel label = new JLabel();
	private final JCheckBox checkBox1 = new JCheckBox();
	private final JCheckBox checkBox2 = new JCheckBox();
	private final JCheckBox checkBox3 = new JCheckBox();
	private final JCheckBox checkBox4 = new JCheckBox();
	private final JCheckBox checkBox5 = new JCheckBox();
	private final JPanel panel = new JPanel();
	private final JButton button = new JButton();

	private InventionRegistrationRequest invRegReq;
	private User currentUser;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ExpertInvApprove frame = new ExpertInvApprove(null, null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public ExpertInvApprove(User currentUser, InventionRegistrationRequest selectedInvRegReq) {
		super();
		this.currentUser = currentUser;
		this.invRegReq = selectedInvRegReq;
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
		label.setText("هر گزینه در صورتی که انتخاب شده باشد تأیید، و در غیر این صورت رد می شود:");
		label.setBounds(10, 10, 324, 26);

		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(null);
		panel.setBounds(10, 42, 324, 178);

		checkBox1.setBounds(104, 10, 210, 24);
		panel.add(checkBox1);
		checkBox1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkBox1.setText("اصالت و نوآوری اختراع");

		checkBox2.setBounds(104, 40, 210, 24);
		panel.add(checkBox2);
		checkBox2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkBox2.setText("تکمیل بودن مشخصات کلی اختراع");

		checkBox3.setBounds(74, 70, 240, 24);
		panel.add(checkBox3);
		checkBox3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkBox3.setText("تکمیل بودن مستندات و کافی بودن شرح های اختراع");

		checkBox4.setBounds(74, 100, 240, 24);
		panel.add(checkBox4);
		checkBox4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkBox4.setText("انطباق کلی مفاد ادعانامه با مستندات و شرح داده شده");

		checkBox5.setBounds(104, 133, 210, 24);
		panel.add(checkBox5);
		checkBox5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkBox5.setText("صحت انتساب نماینده به شرکت");

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("ثبت");
		button.setBounds(141, 228, 48, 26);
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}

	protected void button_actionPerformed(ActionEvent e) {
		boolean check1 = checkBox1.isSelected();
		boolean check2 = checkBox2.isSelected();
		boolean check3 = checkBox3.isSelected();
		boolean check4 = checkBox4.isSelected();
		boolean check5 = checkBox5.isSelected();

		if (check1 && check2 && check3 && check4 && check5) {
			invRegReq.acceptAndApplyRequest(currentUser);
			JOptionPane.showMessageDialog(this, "درخواست ثبت اختراع با موفقیت ثبت شد.");
		} else {
			invRegReq.rejectRequest(currentUser);
			JOptionPane.showMessageDialog(this, "درخواست ثبت اختراع با موفقیت رد شد.");
		}
		this.setVisible(false);
	}

}
