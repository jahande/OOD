package invregsystem.ui;

import invregsystem.logic.member.Manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Management extends JFrame {

	private final JButton button_3 = new JButton();
	private final JPanel panel = new JPanel();
	private final JLabel label = new JLabel();
	private final JButton button_2 = new JButton();
	private final JButton button_4 = new JButton();
	private final JButton button_5 = new JButton();
	private final JPanel panel_2 = new JPanel();
	private final JLabel label_2 = new JLabel();
	private final JButton button_7 = new JButton();
	private final JButton button_8 = new JButton();
	private final JButton button_9 = new JButton();
	private final JPanel panel_3 = new JPanel();
	private final JLabel label_3 = new JLabel();
	private final JButton button_10 = new JButton();
	private final JButton button_11 = new JButton();
	private final JButton button_12 = new JButton();
	private final JPanel panel_4 = new JPanel();
	private final JLabel label_4 = new JLabel();
	private final JButton button_13 = new JButton();
	private final JButton button_14 = new JButton();
	private final JButton button_15 = new JButton();
	private final JPanel panel_5 = new JPanel();
	private final JLabel label_5 = new JLabel();
	private final JButton button_16 = new JButton();
	private final JButton button_17 = new JButton();
	private final JButton button = new JButton();
	private final JButton button_1 = new JButton();

	private Manager currentManager;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Management frame = new Management(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public Management(Manager currentManager) {
		super();
		this.currentManager = currentManager;
		setBounds(100, 100, 767, 580);
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
		setTitle("مدیریت سامانه");

		getContentPane().add(button_3);
		button_3.addActionListener(new Button_3ActionListener());
		button_3.setText("استعلام اطلاعات شرکت یا سازمان");
		button_3.setBounds(508, 349, 205, 40);

		getContentPane().add(panel);
		panel.setBackground(new Color(152, 251, 152));
		panel.setLayout(null);
		panel.setBounds(482, 22, 205, 232);

		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setText("مدیریت حوزه‌های کارشناسی");
		label.setBounds(33, 0, 125, 29);

		button_2.setBounds(33, 48, 136, 35);
		button_2.addActionListener(new Button_2ActionListener());
		panel.add(button_2);
		button_2.setText("اختصاص حوزه کارشناسی");

		panel.add(button_4);
		button_4.addActionListener(new Button_4ActionListener());
		button_4.setHorizontalTextPosition(SwingConstants.CENTER);
		button_4.setText("حذف حوزه‌ی اختصاص داده شده");
		button_4.setBounds(24, 106, 169, 40);

		panel.add(button_5);
		button_5.addActionListener(new Button_5ActionListener());
		button_5.setHorizontalTextPosition(SwingConstants.CENTER);
		button_5.setText("مشاهده‌ی حوزه‌ی اختصاص داده شده");
		button_5.setBounds(8, 160, 185, 40);

		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(152, 251, 152));
		panel_2.setBounds(10, 22, 189, 232);

		panel_2.add(label_2);
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setText("مدیریت حوزه‌های اختراع");
		label_2.setBounds(22, 0, 125, 29);

		panel_2.add(button_7);
		button_7.addActionListener(new Button_7ActionListener());
		button_7.setText("افزودن حوزه‌ی اختراع");
		button_7.setBounds(22, 49, 136, 40);

		panel_2.add(button_8);
		button_8.addActionListener(new Button_8ActionListener());
		button_8.setText("حذف حوزه‌ی اختراع");
		button_8.setBounds(8, 110, 169, 40);

		panel_2.add(button_9);
		button_9.addActionListener(new Button_9ActionListener());
		button_9.setText("مشاهده‌ی حوزه‌ی اختراع");
		button_9.setBounds(8, 161, 171, 40);

		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(152, 251, 152));
		panel_3.setBounds(211, 22, 246, 232);

		panel_3.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setText("مدیریت درخواست‌ها");
		label_3.setBounds(61, 0, 125, 29);

		panel_3.add(button_10);
		button_10.addActionListener(new Button_10ActionListener());
		button_10.setHorizontalTextPosition(SwingConstants.CENTER);
		button_10.setText("تایید یا رد درخواست افزودن حوزه اختراع جدید");
		button_10.setBounds(10, 49, 226, 40);

		panel_3.add(button_11);
		button_11.addActionListener(new Button_11ActionListener());
		button_11.setHorizontalTextPosition(SwingConstants.CENTER);
		button_11.setText("تایید یا رد درخواست ایجاد حساب کاربری");
		button_11.setBounds(27, 107, 192, 40);

		panel_3.add(button_12);
		button_12.addActionListener(new Button_12ActionListener());
		button_12.setText("تایید یا رد درخواست ثبت شرکت");
		button_12.setBounds(36, 162, 171, 40);

		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(152, 251, 152));
		panel_4.setBounds(10, 290, 272, 232);

		panel_4.add(label_4);
		label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setText("اخذ گزارش مدیریتی");
		label_4.setBounds(73, 0, 125, 29);

		panel_4.add(button_13);
		button_13.addActionListener(new Button_13ActionListener());
		button_13.setText("اخذ گزارش کل کاربران");
		button_13.setBounds(61, 61, 136, 40);

		panel_4.add(button_14);
		button_14.addActionListener(new Button_14ActionListener());
		button_14.setHorizontalTextPosition(SwingConstants.CENTER);
		button_14.setText("اخذ گزارش درخواست‌‌های مورد بررسی کارشناسان");
		button_14.setBounds(10, 115, 249, 40);

		panel_4.add(button_15);
		button_15.addActionListener(new Button_15ActionListener());
		button_15.setText("اخذ گزارش اختراعات یک کاربر");
		button_15.setBounds(46, 165, 171, 40);

		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(152, 251, 152));
		panel_5.setBounds(301, 290, 189, 232);

		panel_5.add(label_5);
		label_5.setHorizontalTextPosition(SwingConstants.CENTER);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setText("مدیریت حساب‌های کاربری");
		label_5.setBounds(22, 0, 125, 29);

		panel_5.add(button_16);
		button_16.addActionListener(new Button_16ActionListener());
		button_16.setText("حذف حساب کاربری");
		button_16.setBounds(22, 69, 136, 40);

		panel_5.add(button_17);
		button_17.addActionListener(new Button_17ActionListener());
		button_17.setText("مشاهده‌ی حساب کاربری");
		button_17.setBounds(10, 115, 169, 40);

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("صدور اجازه‌ی درخواست ثبت اختراع");
		button.setBounds(508, 290, 204, 40);

		getContentPane().add(button_1);
		button_1.addActionListener(new Button_1ActionListener());
		button_1.setBackground(Color.YELLOW);
		button_1.setText("خروج");
		button_1.setBounds(508, 412, 205, 40);

	}

	private class Button_7ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_7_actionPerformed(e);
		}
	}

	private class Button_8ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_8_actionPerformed(e);
		}
	}

	private class Button_9ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_9_actionPerformed(e);
		}
	}

	private class Button_10ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_10_actionPerformed(e);
		}
	}

	private class Button_11ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_11_actionPerformed(e);
		}
	}

	private class Button_12ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_12_actionPerformed(e);
		}
	}

	private class Button_2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_2_actionPerformed(e);
		}
	}

	private class Button_4ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_4_actionPerformed(e);
		}
	}

	private class Button_5ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_5_actionPerformed(e);
		}
	}

	private class Button_13ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_13_actionPerformed(e);
		}
	}

	private class Button_14ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_14_actionPerformed(e);
		}
	}

	private class Button_15ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_15_actionPerformed(e);
		}
	}

	private class Button_16ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_16_actionPerformed(e);
		}
	}

	private class Button_17ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_17_actionPerformed(e);
		}
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}

	private class Button_3ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_3_actionPerformed(e);
		}
	}

	private class Button_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_1_actionPerformed(e);
		}
	}

	protected void button_7_actionPerformed(ActionEvent e) {
		new AddInventionField().setVisible(true);
	}

	protected void button_8_actionPerformed(ActionEvent e) {
		DeleteInventionField dafs = new DeleteInventionField();
		dafs.refreshData();
		dafs.setVisible(true);
	}

	protected void button_9_actionPerformed(ActionEvent e) {
		ViewInventionFields vif = new ViewInventionFields();
		vif.refreshData();
		vif.setVisible(true);
		
	}

	protected void button_10_actionPerformed(ActionEvent e) {
		AcceptOrRejectAddNewFieldRequest acceptOrRejectAddNewFieldRequest =new AcceptOrRejectAddNewFieldRequest();
		acceptOrRejectAddNewFieldRequest.refreshData();
		acceptOrRejectAddNewFieldRequest.setVisible(true);
	}

	protected void button_11_actionPerformed(ActionEvent e) {
		new AcceptOrRejectCreateUserAccount().setVisible(true);
	}

	protected void button_12_actionPerformed(ActionEvent e) {
		new AcceptOrRejectCompanyRegisterationRequest().setVisible(true);
	}

	protected void button_2_actionPerformed(ActionEvent e) {
		new AssignInventionField().setVisible(true);
	}

	protected void button_4_actionPerformed(ActionEvent e) {
		new DeleteAssignedFieldSel().setVisible(true);
	}

	protected void button_5_actionPerformed(ActionEvent e) {
		new ViewAssignmentedFieldsSel().setVisible(true);
	}

	protected void button_13_actionPerformed(ActionEvent e) {
		new RequestAllUsersReport().setVisible(true);
	}

	protected void button_14_actionPerformed(ActionEvent e) {
		new RequestInCheckByExertsReport().setVisible(true);
	}

	protected void button_15_actionPerformed(ActionEvent e) {
		new RequestPeronsInventions().setVisible(true);
	}

	protected void button_16_actionPerformed(ActionEvent e) {
		new DeleteUserAccountSel().setVisible(true);
	}

	protected void button_17_actionPerformed(ActionEvent e) {
		new ViewUserAccountSel().setVisible(true);
	}

	protected void button_actionPerformed(ActionEvent e) {
		new GivePermitionToRequest().setVisible(true);
	}

	protected void button_3_actionPerformed(ActionEvent e) {
		new RequestPeronsInventions().setVisible(true);
	}

	protected void button_1_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		new Login().setVisible(true);
	}

}