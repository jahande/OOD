package invregsystem.ui;

import invregsystem.logic.invention.Invention;
import invregsystem.logic.invention.InventionCatalog;
import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.invention.InventionRegistrationRequestCatalog;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;


import com.jgoodies.forms.factories.DefaultComponentFactory;

public class InvRegReqApprove extends JFrame {

	private final JLabel label_9 = new JLabel();
	private final JTextField titleTextField = new JTextField();
	private final JLabel label = new JLabel();
	private final JTextPane descTextPane = new JTextPane();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JTextPane abstractTextPane = new JTextPane();
	private final JLabel label_4 = new JLabel();
	private final JTextPane ideaDescTextPane = new JTextPane();
	private final JLabel label_5 = new JLabel();
	private final JTextPane ideaHistoryTextPane = new JTextPane();
	private final JLabel label_6 = new JLabel();
	private final JTextPane assertTextPane = new JTextPane();
	private final JLabel label_7 = new JLabel();
	private final JTextPane fullDescTextPane = new JTextPane();
	private final JLabel label_8 = new JLabel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JScrollPane scrollPane_3 = new JScrollPane();
	private final JScrollPane scrollPane_4 = new JScrollPane();
	private final JScrollPane scrollPane_5 = new JScrollPane();
	private final JScrollPane scrollPane_6 = new JScrollPane();
	private final JTextField fileTextField1 = new JTextField();
	private final JButton button = new JButton();

	private final JButton button_1 = new JButton();

	private final JTextField fileTextField2 = new JTextField();
	private final JTextField fileTextField3 = new JTextField();

	private Invention invention;
	private InventionRegistrationRequestCatalog invRegReqCatalog;
	private InventionCatalog inventionCatalog;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvRegReqApprove frame = new InvRegReqApprove(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvRegReqApprove(Invention invention) {
		super();
		invRegReqCatalog = InventionRegistrationRequestCatalog.getInstance();
		inventionCatalog = InventionCatalog.getInstance();
		this.invention = invention;

		setBounds(100, 100, 387, 744);
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
		setTitle("ایجاد درخواست ثبت اختراع");

		getContentPane().add(label_9);
		label_9.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_9.setText("عنوان");
		label_9.setBounds(297, 32, 66, 16);

		getContentPane().add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("اطلاعات اختراع را برای بار آخر بررسی و تأیید نمایید.");
		label.setBounds(143, 10, 220, 16);

		getContentPane().add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("مشخصات کلی");
		label_2.setBounds(297, 82, 66, 16);

		getContentPane().add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("چکیده");
		label_3.setBounds(297, 160, 66, 16);

		getContentPane().add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("شرح ایده");
		label_4.setBounds(297, 238, 66, 16);

		getContentPane().add(label_5);
		label_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_5.setText("سابقه ایده");
		label_5.setBounds(297, 318, 66, 16);

		getContentPane().add(label_6);
		label_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_6.setText("ادعانامه");
		label_6.setBounds(297, 396, 66, 16);

		getContentPane().add(label_7);
		label_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_7.setText("شرح کامل");
		label_7.setBounds(297, 474, 66, 16);

		getContentPane().add(label_8);
		label_8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_8.setText("فایل های پیوست");
		label_8.setBounds(297, 552, 66, 16);

		getContentPane().add(titleTextField);
		titleTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		titleTextField.setText(invention.getTitle());
		titleTextField.setEditable(false);
		titleTextField.setBounds(10, 56, 353, 20);

		getContentPane().add(scrollPane);
		scrollPane.setBounds(10, 104, 353, 50);

		scrollPane.setViewportView(descTextPane);
		descTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		descTextPane.setText(invention.getTotalSpec());
		// end temp
		descTextPane.setEditable(false);

		getContentPane().add(scrollPane_2);
		scrollPane_2.setBounds(10, 182, 353, 50);

		scrollPane_2.setViewportView(abstractTextPane);
		abstractTextPane.setText(invention.getSummary());
		// end temp
		abstractTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		abstractTextPane.setEditable(false);

		getContentPane().add(scrollPane_3);
		scrollPane_3.setBounds(10, 260, 353, 50);

		scrollPane_3.setViewportView(ideaDescTextPane);
		// begin temp
		ideaDescTextPane.setText(invention.getIdeaDescription());
		// end temp
		ideaDescTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaDescTextPane.setEditable(false);

		getContentPane().add(scrollPane_4);
		scrollPane_4.setBounds(10, 340, 353, 50);

		scrollPane_4.setViewportView(ideaHistoryTextPane);
		// begin temp
		ideaHistoryTextPane.setText(invention.getIdeaHistory());
		// end temp
		ideaHistoryTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaHistoryTextPane.setEditable(false);

		getContentPane().add(scrollPane_5);
		scrollPane_5.setBounds(10, 418, 353, 50);

		scrollPane_5.setViewportView(assertTextPane);
		// begin temp
		assertTextPane.setText(invention.getClaim());
		// end temp
		assertTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		assertTextPane.setEditable(false);

		getContentPane().add(scrollPane_6);
		scrollPane_6.setBounds(10, 496, 353, 50);

		scrollPane_6.setViewportView(fullDescTextPane);
		fullDescTextPane.setEditable(false);
		// begin temp
		fullDescTextPane.setText(invention.getExplanation());
		// end temp
		fullDescTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(fileTextField1);
		fileTextField1.setEditable(false);
		if (invention.getFile1() != null)
			fileTextField1.setText(invention.getFile1());
		fileTextField1.setBounds(10, 569, 353, 20);

		getContentPane().add(fileTextField2);
		if (invention.getFile2() != null)
			fileTextField2.setText(invention.getFile2());
		fileTextField2.setEditable(false);
		fileTextField2.setBounds(10, 595, 353, 20);

		getContentPane().add(fileTextField3);
		if (invention.getFile3() != null)
			fileTextField3.setText(invention.getFile3());
		fileTextField3.setEditable(false);
		fileTextField3.setBounds(10, 621, 353, 20);

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("تأیید نهایی");
		button.setBounds(279, 659, 84, 26);

		getContentPane().add(button_1);
		button_1.addActionListener(new Button_1ActionListener());
		button_1.setText("تعیین ارتباط با اختراع های دیگر");
		button_1.setBounds(10, 659, 176, 26);

	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}

	private class Button_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_1_actionPerformed(e);
		}
	}

	protected void button_actionPerformed(ActionEvent e) {
		inventionCatalog.addItem(invention);
		InventionRegistrationRequest request = new InventionRegistrationRequest(new Date(), invention);
		invRegReqCatalog.addItem(request);
		this.setVisible(false);
	}

	protected void button_1_actionPerformed(ActionEvent e) {
		new InvRegReqRelations().setVisible(true);
	}

}
