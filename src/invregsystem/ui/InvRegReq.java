package invregsystem.ui;

import invregsystemlogic.invention.Invention;
import invregsystemlogic.member.User;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class InvRegReq extends JFrame {

	private final JLabel label = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	private final JLabel label_6 = new JLabel();
	private final JLabel label_7 = new JLabel();
	private final JLabel label_8 = new JLabel();
	private final JTextField titleTextField = new JTextField();
	private final JTextPane descTextPane = new JTextPane();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JTextPane abstractTextPane = new JTextPane();
	private final JScrollPane scrollPane_3 = new JScrollPane();
	private final JTextPane ideaDescTextPane = new JTextPane();
	private final JScrollPane scrollPane_4 = new JScrollPane();
	private final JTextPane ideaHistoryTextPane = new JTextPane();
	private final JScrollPane scrollPane_5 = new JScrollPane();
	private final JTextPane assertTextPane = new JTextPane();
	private final JScrollPane scrollPane_6 = new JScrollPane();
	private final JTextPane fullDescTextPane = new JTextPane();
	private final JButton fileChooseButton1 = new JButton();
	private final JButton fileChooseButton2 = new JButton();
	private final JButton fileChooseButton3 = new JButton();
	private final JTextField fileTextField1 = new JTextField();
	private final JTextField fileTextField2 = new JTextField();
	private final JTextField fileTextField3 = new JTextField();
	private final JButton nextButton = new JButton();

	private String title;
	private String description;
	private String invAbstract;
	private String ideaDesc;
	private String ideaHistory;
	private String assertion;
	private String fullDesc;
	private File[] attachedFiles = new File[3];

	private User currentUser;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvRegReq frame = new InvRegReq(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvRegReq(User currentUser) {
		super();
		this.currentUser = currentUser;
		setBounds(100, 100, 419, 607);
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

		getContentPane().add(label_8);
		label_8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_8.setText("عنوان");
		label_8.setBounds(307, 21, 66, 16);

		getContentPane().add(label);
		label.setText("مشخصات کلی");
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setBounds(307, 52, 66, 16);

		getContentPane().add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("چکیده");
		label_2.setBounds(307, 110, 66, 16);

		getContentPane().add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("شرح ایده");
		label_3.setBounds(307, 169, 66, 16);

		getContentPane().add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("سابقه ایده");
		label_4.setBounds(307, 228, 66, 16);

		getContentPane().add(label_5);
		label_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_5.setText("ادعانامه");
		label_5.setBounds(307, 287, 66, 16);

		getContentPane().add(label_6);
		label_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_6.setText("شرح کامل");
		label_6.setBounds(307, 346, 66, 16);

		getContentPane().add(label_7);
		label_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_7.setText("فایل های پیوست");
		label_7.setBounds(307, 421, 66, 16);

		titleTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		getContentPane().add(titleTextField);
		titleTextField.setBounds(40, 21, 254, 20);

		getContentPane().add(scrollPane);
		scrollPane.setBounds(40, 47, 254, 53);

		descTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(descTextPane);

		getContentPane().add(scrollPane_2);
		scrollPane_2.setBounds(40, 105, 254, 53);

		scrollPane_2.setViewportView(abstractTextPane);
		abstractTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(scrollPane_3);
		scrollPane_3.setBounds(40, 164, 254, 53);

		scrollPane_3.setViewportView(ideaDescTextPane);
		ideaDescTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(scrollPane_4);
		scrollPane_4.setBounds(40, 223, 254, 53);

		scrollPane_4.setViewportView(ideaHistoryTextPane);
		ideaHistoryTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(scrollPane_5);
		scrollPane_5.setBounds(40, 282, 254, 53);

		scrollPane_5.setViewportView(assertTextPane);
		assertTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(scrollPane_6);
		scrollPane_6.setBounds(40, 341, 254, 53);

		scrollPane_6.setViewportView(fullDescTextPane);
		fullDescTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(fileChooseButton1);
		fileChooseButton1.addActionListener(new FileChooseButton1ActionListener());
		fileChooseButton1.setText("انتخاب ...");
		fileChooseButton1.setBounds(209, 411, 85, 26);

		getContentPane().add(fileChooseButton2);
		fileChooseButton2.addActionListener(new FileChooseButton2ActionListener());
		fileChooseButton2.setText("انتخاب ...");
		fileChooseButton2.setBounds(209, 443, 85, 26);

		getContentPane().add(fileChooseButton3);
		fileChooseButton3.addActionListener(new FileChooseButton3ActionListener());
		fileChooseButton3.setText("انتخاب ...");
		fileChooseButton3.setBounds(209, 475, 85, 26);

		getContentPane().add(fileTextField1);
		fileTextField1.setBounds(40, 411, 163, 20);

		getContentPane().add(fileTextField2);
		fileTextField2.setBounds(40, 443, 163, 20);

		getContentPane().add(fileTextField3);
		fileTextField3.setBounds(40, 475, 163, 20);

		getContentPane().add(nextButton);
		nextButton.addActionListener(new NextButtonActionListener());
		nextButton.setText("بعدی");
		nextButton.setBounds(168, 528, 77, 26);

	}

	private class FileChooseButton1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fileChooseButton1_actionPerformed(e);
		}
	}

	private class FileChooseButton2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fileChooseButton2_actionPerformed(e);
		}
	}

	private class FileChooseButton3ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fileChooseButton3_actionPerformed(e);
		}
	}

	private class NextButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			nextButton_actionPerformed(e);
		}
	}

	protected void fileChooseButton1_actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		if (fc.getSelectedFile() != null) {
			attachedFiles[0] = fc.getSelectedFile();
			fileTextField1.setText(attachedFiles[0].getPath());
		}
	}

	protected void fileChooseButton2_actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		if (fc.getSelectedFile() != null) {
			attachedFiles[1] = fc.getSelectedFile();
			fileTextField2.setText(attachedFiles[1].getPath());
		}
	}

	protected void fileChooseButton3_actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		if (fc.getSelectedFile() != null) {
			attachedFiles[2] = fc.getSelectedFile();
			fileTextField3.setText(attachedFiles[2].getPath());
		}
	}

	protected void nextButton_actionPerformed(ActionEvent e) {
		title = titleTextField.getText();
		description = descTextPane.getText();
		invAbstract = abstractTextPane.getText();
		ideaDesc = ideaDescTextPane.getText();
		ideaHistory = ideaHistoryTextPane.getText();
		assertion = assertTextPane.getText();
		fullDesc = fullDescTextPane.getText();

		if (title.equals("") || description.equals("") || invAbstract.equals("") || ideaDesc.equals("") || ideaHistory.equals("") || assertion.equals("") || fullDesc.equals("")) {
			JOptionPane.showMessageDialog(this, "لطفاً مشخصات اختراع را تکمیل نمایید.", "خطا", JOptionPane.ERROR_MESSAGE);
		} else {
			List<String> files = new ArrayList<String>();
			if (!fileTextField1.getText().equals("")) {
				files.add(fileTextField1.getText());
			}
			if (!fileTextField2.getText().equals("")) {
				files.add(fileTextField2.getText());
			}
			if (!fileTextField3.getText().equals("")) {
				files.add(fileTextField3.getText());
			}
			Invention invention = new Invention(title, description, invAbstract, ideaDesc, ideaHistory, assertion, fullDesc, files);
			this.setVisible(false);
			new InvRegReqInventors(currentUser, invention).setVisible(true);
		}
	}
}
