package ui;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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

	private String description;
	private String invAbstract;
	private String ideaDesc;
	private String ideaHistory;
	private String assertion;
	private String fullDesc;
	private File[] attachedFiles = new File[3];

	private final JButton nextButton = new JButton();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvRegReq frame = new InvRegReq();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvRegReq() {
		super();
		setBounds(100, 100, 419, 587);
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

		getContentPane().add(label);
		label.setText("مشخصات کلی");
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setBounds(308, 37, 66, 16);

		getContentPane().add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("چکیده");
		label_2.setBounds(308, 95, 66, 16);

		getContentPane().add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("شرح ایده");
		label_3.setBounds(308, 154, 66, 16);

		getContentPane().add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("سابقه ایده");
		label_4.setBounds(308, 213, 66, 16);

		getContentPane().add(label_5);
		label_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_5.setText("ادعانامه");
		label_5.setBounds(308, 272, 66, 16);

		getContentPane().add(label_6);
		label_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_6.setText("شرح کامل");
		label_6.setBounds(308, 331, 66, 16);

		getContentPane().add(label_7);
		label_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_7.setText("فایل های پیوست");
		label_7.setBounds(308, 406, 66, 16);

		getContentPane().add(scrollPane);
		scrollPane.setBounds(41, 32, 254, 53);

		descTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(descTextPane);

		getContentPane().add(scrollPane_2);
		scrollPane_2.setBounds(41, 90, 254, 53);

		scrollPane_2.setViewportView(abstractTextPane);
		abstractTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(scrollPane_3);
		scrollPane_3.setBounds(41, 149, 254, 53);

		scrollPane_3.setViewportView(ideaDescTextPane);
		ideaDescTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(scrollPane_4);
		scrollPane_4.setBounds(41, 208, 254, 53);

		scrollPane_4.setViewportView(ideaHistoryTextPane);
		ideaHistoryTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(scrollPane_5);
		scrollPane_5.setBounds(41, 267, 254, 53);

		scrollPane_5.setViewportView(assertTextPane);
		assertTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(scrollPane_6);
		scrollPane_6.setBounds(41, 326, 254, 53);

		scrollPane_6.setViewportView(fullDescTextPane);
		fullDescTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(fileChooseButton1);
		fileChooseButton1
				.addActionListener(new FileChooseButton1ActionListener());
		fileChooseButton1.setText("انتخاب ...");
		fileChooseButton1.setBounds(210, 396, 85, 26);

		getContentPane().add(fileChooseButton2);
		fileChooseButton2
				.addActionListener(new FileChooseButton2ActionListener());
		fileChooseButton2.setText("انتخاب ...");
		fileChooseButton2.setBounds(210, 428, 85, 26);

		getContentPane().add(fileChooseButton3);
		fileChooseButton3
				.addActionListener(new FileChooseButton3ActionListener());
		fileChooseButton3.setText("انتخاب ...");
		fileChooseButton3.setBounds(210, 460, 85, 26);

		getContentPane().add(fileTextField1);
		fileTextField1.setBounds(41, 396, 163, 20);

		getContentPane().add(fileTextField2);
		fileTextField2.setBounds(41, 428, 163, 20);

		getContentPane().add(fileTextField3);
		fileTextField3.setBounds(41, 460, 163, 20);

		getContentPane().add(nextButton);
		nextButton.addActionListener(new NextButtonActionListener());
		nextButton.setText("بعدی");
		nextButton.setBounds(169, 513, 77, 26);
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
		description = descTextPane.getText();
		invAbstract = abstractTextPane.getText();
		ideaDesc = ideaDescTextPane.getText();
		ideaHistory = ideaHistoryTextPane.getText();
		assertion = assertTextPane.getText();
		fullDesc = fullDescTextPane.getText();

		if (description.equals("") || invAbstract.equals("")
				|| ideaDesc.equals("") || ideaHistory.equals("")
				|| assertion.equals("") || fullDesc.equals("")) {
			JOptionPane.showMessageDialog(this,
					"لطفاً مشخصات اختراع را تکمیل نمایید.", "خطا",
					JOptionPane.ERROR_MESSAGE);
		} else {
			this.setVisible(false);
			new InvRegReqInventors().setVisible(true);
		}
	}
}
