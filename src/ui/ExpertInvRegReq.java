package ui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

public class ExpertInvRegReq extends JFrame {

	private final JPanel panel = new JPanel();
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
	private final JLabel label_8 = new JLabel();
	private final JScrollPane scrollPane_6 = new JScrollPane();
	private final JTextPane fullDescTextPane = new JTextPane();
	private final JTextField fileTextField1 = new JTextField();
	private final JButton approveHistoryButton = new JButton();
	private final JButton button = new JButton();

	private final JButton approveButton = new JButton();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvPage frame = new InvPage();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public ExpertInvRegReq() {
		super();
		setBounds(100, 100, 399, 659);
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
		setTitle("درخواست ثبت اختراع");

		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(null);
		panel.setBounds(10, 10, 374, 546);

		panel.add(label_1);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setText("مشخصات کلی");
		label_1.setBounds(34, 10, 0, 0);

		panel.add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("مشخصات کلی");
		label_2.setBounds(297, 10, 66, 16);

		panel.add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("چکیده");
		label_3.setBounds(297, 88, 66, 16);

		panel.add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("شرح ایده");
		label_4.setBounds(297, 166, 66, 16);

		panel.add(label_5);
		label_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_5.setText("سابقه ایده");
		label_5.setBounds(297, 246, 66, 16);

		panel.add(label_6);
		label_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_6.setText("ادعانامه");
		label_6.setBounds(297, 324, 66, 16);

		panel.add(label_7);
		label_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_7.setText("شرح کامل");
		label_7.setBounds(297, 402, 66, 16);

		panel.add(scrollPane_1);
		scrollPane_1
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_1.setBounds(10, 32, 353, 50);

		scrollPane_1.setViewportView(descTextPane);
		descTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		descTextPane.setText("این اختراع یک آپولوی در ابعاد آزمایشگاهی است.");
		descTextPane.setEditable(false);

		panel.add(scrollPane_2);
		scrollPane_2
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_2.setBounds(10, 110, 353, 50);

		scrollPane_2.setViewportView(abstractTextPane);
		abstractTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		abstractTextPane
				.setText("پروژه فضایی آپولو (به انگلیسی: Apollo Program) یکی از پروژه‌های فضایی ناسا در زمان مسابقه فضایی میان شوروی و آمریکا بود که کوشش می‌کرد تا اولین انسان را بر روی سطح کره ماه فرود بیاورد. ");
		abstractTextPane.setEditable(false);

		panel.add(scrollPane_3);
		scrollPane_3
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_3.setBounds(10, 188, 353, 50);

		scrollPane_3.setViewportView(ideaDescTextPane);
		ideaDescTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaDescTextPane
				.setText("ایده این است که ما دوباره آپولوی اصلی را در ابعاد کوچک آزمایشگاهی بسازیم که بفهمیم راست بوده است یا دروغ.");
		ideaDescTextPane.setEditable(false);

		panel.add(scrollPane_4);
		scrollPane_4
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_4.setBounds(10, 268, 353, 50);

		scrollPane_4.setViewportView(ideaHistoryTextPane);
		ideaHistoryTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaHistoryTextPane
				.setText("آپولو پس از ریاست جمهوری بعدی آمریکا جان اف. کندی با جدیت ادامه پیدا کرد. جان اف. کندی پشتیبانی خود از طرح فرود انسان بر روی کره ماه را طی یک سخنرانی ویژه خطاب به کنگره در ماه مه ۱۹۶۱ بدین گونه اعلام کرد:...من اعتقاد دارم کشورم می‌بایست برای دستیابی به هدف فرود انسان بر روی کره ماه و به سلامت بازگشتن به زمین قبل از خروج از این دهه متعهد شود.در این دوره هیج برنامه فضایی دیگری نمی‌تواند برای بشر تأثیرگذارتر از اکتشاف مسیرهای با برد طولانی در فضا باشد؛ و انجام هیچ کدام نمی‌تواند تا این حد سخت و گران باشد.");
		ideaHistoryTextPane.setEditable(false);

		panel.add(scrollPane_5);
		scrollPane_5
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_5.setBounds(10, 346, 353, 50);

		scrollPane_5.setViewportView(assertTextPane);
		assertTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		assertTextPane
				.setText("1. ادعا می کنیم این آپولو با آپولوی اصلی هیچ تفاوتی ندارد الا این که در مقیاس 1/5 است.");
		assertTextPane.setEditable(false);

		panel.add(label_8);
		label_8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_8.setText("فایل های پیوست");
		label_8.setBounds(297, 480, 66, 16);

		panel.add(scrollPane_6);
		scrollPane_6
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_6.setBounds(10, 424, 353, 50);

		scrollPane_6.setViewportView(fullDescTextPane);
		fullDescTextPane
				.setText("روژه فضایی آپولو (به انگلیسی: Apollo Program) یکی از پروژه‌های فضایی ناسا در زمان مسابقه فضایی میان شوروی و آمریکا بود که کوشش می‌کرد تا اولین انسان را بر روی سطح کره ماه فرود بیاورد. پروژه در دوره ریاست جمهوری دوایت آیزنهاور شروع به کار کرد، آپولو پس از ریاست جمهوری بعدی آمریکا جان اف. کندی با جدیت ادامه پیدا کرد. جان اف. کندی پشتیبانی خود از طرح فرود انسان بر روی کره ماه را طی یک سخنرانی ویژه خطاب به کنگره در ماه مه ۱۹۶۱ بدین گونه اعلام کرد:...من اعتقاد دارم کشورم می‌بایست برای دستیابی به هدف فرود انسان بر روی کره ماه و به سلامت بازگشتن به زمین قبل از خروج از این دهه متعهد شود.در این دوره هیج برنامه فضایی دیگری نمی‌تواند برای بشر تأثیرگذارتر از اکتشاف مسیرهای با برد طولانی در فضا باشد؛ و انجام هیچ کدام نمی‌تواند تا این حد سخت و گران باشد.");

		panel.add(fileTextField1);
		fileTextField1
				.setText("C:University StuffObject Oriented DesignProjectdefinitionDefinition.pdf");
		fileTextField1.setEditable(false);
		fileTextField1.setBounds(10, 497, 353, 20);

		approveHistoryButton.setBounds(78, 577, 99, 26);
		getContentPane().add(approveHistoryButton);
		approveHistoryButton
				.addActionListener(new ApproveHistoryButtonActionListener());
		approveHistoryButton.setText("سوابق تأیید یا رد");

		getContentPane().add(approveButton);
		approveButton.addActionListener(new ApproveButtonActionListener());
		approveButton.setText("تأیید یا رد درخواست");
		approveButton.setBounds(201, 577, 112, 26);

	}

	private class ApproveHistoryButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			approveHistoryButton_actionPerformed(e);
		}
	}

	private class ApproveButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			approveButton_actionPerformed(e);
		}
	}

	protected void approveHistoryButton_actionPerformed(ActionEvent e) {
		new ApproveRejectHistory().setVisible(true);
	}

	protected void approveButton_actionPerformed(ActionEvent e) {
		new ExpertInvApprove().setVisible(true);
	}

}
