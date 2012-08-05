package invregsystem.ui;

import interfaces.AbstractInvention;
import interfaces.AbstractUser;
import invregsystem.logic.invention.InventionCatalog;
import invregsystem.logic.invention.operation.Change;
import invregsystem.logic.invention.operation.InventionLog;
import invregsystem.logic.invention.operation.InventionLogCatalog;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

public class EditInvDoc extends JFrame {

	private final JLabel label_1 = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	private final JLabel label_6 = new JLabel();
	private final JLabel label_7 = new JLabel();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTextPane descTextPane = new JTextPane();
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
	private final JButton saveButton = new JButton();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JTextArea textArea = new JTextArea();
	private final JLabel label = new JLabel();
	private final JScrollPane scrollPane_7 = new JScrollPane();

	private AbstractInvention invention;
	private AbstractUser currentUser;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			EditInvDoc frame = new EditInvDoc(null, null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public EditInvDoc(AbstractInvention invention, AbstractUser currentUser) {
		super();
		this.invention = invention;
		this.currentUser = currentUser;
		setBounds(100, 100, 384, 679);
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
		setTitle("ویرایش مستندات اختراع");

		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(null);
		panel.setBounds(10, 10, 359, 477);

		label_1.setBounds(277, 15, 66, 16);
		panel.add(label_1);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setText("مشخصات کلی");

		label_2.setBounds(277, 73, 66, 16);
		panel.add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("چکیده");

		label_3.setBounds(277, 132, 66, 16);
		panel.add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("شرح ایده");

		label_4.setBounds(277, 191, 66, 16);
		panel.add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("سابقه ایده");

		label_5.setBounds(277, 250, 66, 16);
		panel.add(label_5);
		label_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_5.setText("ادعانامه");

		label_6.setBounds(277, 309, 66, 16);
		panel.add(label_6);
		label_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_6.setText("شرح کامل");

		label_7.setBounds(277, 384, 66, 16);
		panel.add(label_7);
		label_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_7.setText("فایل های پیوست");

		scrollPane_1.setBounds(10, 10, 254, 53);
		panel.add(scrollPane_1);
		scrollPane_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_1.setViewportView(descTextPane);
		descTextPane.setText(invention.getTotalSpec());
		descTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_2.setBounds(10, 68, 254, 53);
		panel.add(scrollPane_2);
		scrollPane_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_2.setViewportView(abstractTextPane);
		abstractTextPane.setText(invention.getSummary());
		abstractTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_3.setBounds(10, 127, 254, 53);
		panel.add(scrollPane_3);
		scrollPane_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_3.setViewportView(ideaDescTextPane);
		ideaDescTextPane.setText(invention.getIdeaDescription());
		ideaDescTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_4.setBounds(10, 186, 254, 53);
		panel.add(scrollPane_4);
		scrollPane_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_4.setViewportView(ideaHistoryTextPane);
		ideaHistoryTextPane.setText(invention.getIdeaHistory());
		ideaHistoryTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_5.setBounds(10, 245, 254, 53);
		panel.add(scrollPane_5);
		scrollPane_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_5.setViewportView(assertTextPane);
		assertTextPane.setText(invention.getClaim());
		assertTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_6.setBounds(10, 304, 254, 53);
		panel.add(scrollPane_6);
		scrollPane_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_6.setViewportView(fullDescTextPane);
		fullDescTextPane.setText(invention.getExplanation());
		fullDescTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		fileChooseButton1.setBounds(179, 374, 85, 26);
		panel.add(fileChooseButton1);
		fileChooseButton1.addActionListener(new FileChooseButton1ActionListener());
		fileChooseButton1.setText("انتخاب ...");

		fileChooseButton2.setBounds(179, 406, 85, 26);
		panel.add(fileChooseButton2);
		fileChooseButton2.addActionListener(new FileChooseButton2ActionListener());
		fileChooseButton2.setText("انتخاب ...");

		fileChooseButton3.setBounds(179, 438, 85, 26);
		panel.add(fileChooseButton3);
		fileChooseButton3.addActionListener(new FileChooseButton3ActionListener());
		fileChooseButton3.setText("انتخاب ...");

		fileTextField1.setBounds(10, 374, 163, 20);
		panel.add(fileTextField1);
		fileTextField1.setText(invention.getFile1());

		fileTextField2.setBounds(10, 406, 163, 20);
		panel.add(fileTextField2);
		fileTextField2.setText(invention.getFile2());

		fileTextField3.setBounds(10, 438, 163, 20);
		panel.add(fileTextField3);
		fileTextField3.setText(invention.getFile3());

		getContentPane().add(saveButton);
		saveButton.addActionListener(new SaveButtonActionListener());
		saveButton.setText("ذخیره تغییرات");
		saveButton.setBounds(130, 605, 100, 26);

		getContentPane().add(panel_1);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel_1.setLayout(null);
		panel_1.setBounds(13, 498, 356, 93);

		panel_1.add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("توضیح برای ویرایش:");
		label.setBounds(251, 8, 95, 16);

		panel_1.add(scrollPane_7);
		scrollPane_7.setBounds(10, 28, 336, 53);

		scrollPane_7.setViewportView(textArea);
		textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

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

	private class SaveButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			saveButton_actionPerformed(e);
		}
	}

	protected void fileChooseButton1_actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		if (fc.getSelectedFile() != null) {
			fileTextField1.setText(fc.getSelectedFile().getPath());
		}
	}

	protected void fileChooseButton2_actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		if (fc.getSelectedFile() != null) {
			fileTextField2.setText(fc.getSelectedFile().getPath());
		}
	}

	protected void fileChooseButton3_actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		if (fc.getSelectedFile() != null) {
			fileTextField3.setText(fc.getSelectedFile().getPath());
		}
	}

	protected void saveButton_actionPerformed(ActionEvent e) {
		String description = descTextPane.getText();
		String invAbstract = abstractTextPane.getText();
		String ideaDesc = ideaDescTextPane.getText();
		String ideaHistory = ideaHistoryTextPane.getText();
		String assertion = assertTextPane.getText();
		String fullDesc = fullDescTextPane.getText();

		if (description.equals("") || invAbstract.equals("") || ideaDesc.equals("") || ideaHistory.equals("") || assertion.equals("")
				|| fullDesc.equals("")) {
			JOptionPane.showMessageDialog(this, "لطفاً مشخصات اختراع را تکمیل نمایید.", "خطا", JOptionPane.ERROR_MESSAGE);
		} else {
			Set<Change> changeSet = new HashSet<Change>();
			if (!description.equals(invention.getTotalSpec())) {
				Change change = new Change("totalSpec", invention.getTotalSpec(), description);
				changeSet.add(change);
				invention.setTotalSpec(description);
			}
			if (!invAbstract.equals(invention.getSummary())) {
				Change change = new Change("summary", invention.getSummary(), invAbstract);
				changeSet.add(change);
				invention.setSummary(invAbstract);
			}
			if (!ideaDesc.equals(invention.getIdeaDescription())) {
				Change change = new Change("ideaDescription", invention.getIdeaDescription(), ideaDesc);
				changeSet.add(change);
				invention.setIdeaDescription(ideaDesc);
			}
			if (!ideaHistory.equals(invention.getIdeaHistory())) {
				Change change = new Change("ideaHistory", invention.getIdeaHistory(), ideaHistory);
				changeSet.add(change);
				invention.setIdeaHistory(ideaHistory);
			}
			if (!assertion.equals(invention.getClaim())) {
				Change change = new Change("claim", invention.getClaim(), assertion);
				changeSet.add(change);
				invention.setClaim(assertion);
			}
			if (!fullDesc.equals(invention.getExplanation())) {
				Change change = new Change("explanation", invention.getExplanation(), fullDesc);
				changeSet.add(change);
				invention.setExplanation(fullDesc);
			}
			if (!fileTextField1.getText().equals(invention.getFile1()) && !(fileTextField1.getText().equals("") || invention.getFile1() == null)) {
				Change change = new Change("file1", invention.getFile1(), fileTextField1.getText());
				changeSet.add(change);
				invention.setFile1(fileTextField1.getText());
			}
			if (!fileTextField2.getText().equals(invention.getFile2()) && !(fileTextField2.getText().equals("") || invention.getFile2() == null)) {
				Change change = new Change("file2", invention.getFile2(), fileTextField2.getText());
				changeSet.add(change);
				invention.setFile2(fileTextField2.getText());
			}
			if (!fileTextField3.getText().equals(invention.getFile3()) && !(fileTextField3.getText().equals("") || invention.getFile3() == null)) {
				Change change = new Change("file3", invention.getFile3(), fileTextField3.getText());
				changeSet.add(change);
				invention.setFile3(fileTextField3.getText());
			}

			if (!changeSet.isEmpty()) {
				InventionLogCatalog inventionLogCatalog = InventionLogCatalog.getInstance();
				InventionLog inventionLog = new InventionLog(invention, currentUser, new Date(), textArea.getText());
				inventionLogCatalog.addItem(inventionLog);
				for (Change change : changeSet) {
					change.setInventionLog(inventionLog);
					inventionLogCatalog.addChange(change);
				}
				InventionCatalog inventionCatalog = InventionCatalog.getInstance();
				inventionCatalog.updateItem(invention);
				JOptionPane.showMessageDialog(this, "مشخصات اختراع با موفقیت تغییر یافت.");
			}
			this.setVisible(false);
		}
	}

}
