package invregsystem.ui;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			EditInvDoc frame = new EditInvDoc();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public EditInvDoc() {
		super();
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
		scrollPane_1
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_1.setViewportView(descTextPane);
		descTextPane.setText("این اختراع یک آپولوی در ابعاد آزمایشگاهی است.");
		descTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_2.setBounds(10, 68, 254, 53);
		panel.add(scrollPane_2);
		scrollPane_2
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_2.setViewportView(abstractTextPane);
		abstractTextPane
				.setText("پروژه فضایی آپولو (به انگلیسی: Apollo Program) یکی از پروژه‌های فضایی ناسا در زمان مسابقه فضایی میان شوروی و آمریکا بود که کوشش می‌کرد تا اولین انسان را بر روی سطح کره ماه فرود بیاورد. ");
		abstractTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_3.setBounds(10, 127, 254, 53);
		panel.add(scrollPane_3);
		scrollPane_3
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_3.setViewportView(ideaDescTextPane);
		ideaDescTextPane
				.setText("ایده این است که ما دوباره آپولوی اصلی را در ابعاد کوچک آزمایشگاهی بسازیم که بفهمیم راست بوده است یا دروغ.");
		ideaDescTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_4.setBounds(10, 186, 254, 53);
		panel.add(scrollPane_4);
		scrollPane_4
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_4.setViewportView(ideaHistoryTextPane);
		ideaHistoryTextPane
				.setText("آپولو پس از ریاست جمهوری بعدی آمریکا جان اف. کندی با جدیت ادامه پیدا کرد. جان اف. کندی پشتیبانی خود از طرح فرود انسان بر روی کره ماه را طی یک سخنرانی ویژه خطاب به کنگره در ماه مه ۱۹۶۱ بدین گونه اعلام کرد:...من اعتقاد دارم کشورم می‌بایست برای دستیابی به هدف فرود انسان بر روی کره ماه و به سلامت بازگشتن به زمین قبل از خروج از این دهه متعهد شود.در این دوره هیج برنامه فضایی دیگری نمی‌تواند برای بشر تأثیرگذارتر از اکتشاف مسیرهای با برد طولانی در فضا باشد؛ و انجام هیچ کدام نمی‌تواند تا این حد سخت و گران باشد.");
		ideaHistoryTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_5.setBounds(10, 245, 254, 53);
		panel.add(scrollPane_5);
		scrollPane_5
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_5.setViewportView(assertTextPane);
		assertTextPane
				.setText("1. ادعا می کنیم این آپولو با آپولوی اصلی هیچ تفاوتی ندارد الا این که در مقیاس 1/5 است.");
		assertTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_6.setBounds(10, 304, 254, 53);
		panel.add(scrollPane_6);
		scrollPane_6
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		scrollPane_6.setViewportView(fullDescTextPane);
		fullDescTextPane
				.setText("روژه فضایی آپولو (به انگلیسی: Apollo Program) یکی از پروژه‌های فضایی ناسا در زمان مسابقه فضایی میان شوروی و آمریکا بود که کوشش می‌کرد تا اولین انسان را بر روی سطح کره ماه فرود بیاورد. پروژه در دوره ریاست جمهوری دوایت آیزنهاور شروع به کار کرد، آپولو پس از ریاست جمهوری بعدی آمریکا جان اف. کندی با جدیت ادامه پیدا کرد. جان اف. کندی پشتیبانی خود از طرح فرود انسان بر روی کره ماه را طی یک سخنرانی ویژه خطاب به کنگره در ماه مه ۱۹۶۱ بدین گونه اعلام کرد:...من اعتقاد دارم کشورم می‌بایست برای دستیابی به هدف فرود انسان بر روی کره ماه و به سلامت بازگشتن به زمین قبل از خروج از این دهه متعهد شود.در این دوره هیج برنامه فضایی دیگری نمی‌تواند برای بشر تأثیرگذارتر از اکتشاف مسیرهای با برد طولانی در فضا باشد؛ و انجام هیچ کدام نمی‌تواند تا این حد سخت و گران باشد.");
		fullDescTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		fileChooseButton1.setBounds(179, 374, 85, 26);
		panel.add(fileChooseButton1);
		fileChooseButton1
				.addActionListener(new FileChooseButton1ActionListener());
		fileChooseButton1.setText("انتخاب ...");

		fileChooseButton2.setBounds(179, 406, 85, 26);
		panel.add(fileChooseButton2);
		fileChooseButton2
				.addActionListener(new FileChooseButton2ActionListener());
		fileChooseButton2.setText("انتخاب ...");

		fileChooseButton3.setBounds(179, 438, 85, 26);
		panel.add(fileChooseButton3);
		fileChooseButton3
				.addActionListener(new FileChooseButton3ActionListener());
		fileChooseButton3.setText("انتخاب ...");

		fileTextField1.setBounds(10, 374, 163, 20);
		panel.add(fileTextField1);
		fileTextField1
				.setText("C:University StuffObject Oriented DesignProjectdefinitionDefinition.pdf");

		fileTextField2.setBounds(10, 406, 163, 20);
		panel.add(fileTextField2);

		fileTextField3.setBounds(10, 438, 163, 20);
		panel.add(fileTextField3);

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
		this.setVisible(false);
	}

}
