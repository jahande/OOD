package ui;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvRegReqApprove frame = new InvRegReqApprove();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvRegReqApprove() {
		super();
		setBounds(100, 100, 387, 650);
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
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("اطلاعات اختراع را برای بار آخر بررسی و تأیید نمایید.");
		label.setBounds(143, 10, 220, 16);

		getContentPane().add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("مشخصات کلی");
		label_2.setBounds(297, 47, 66, 16);

		getContentPane().add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("چکیده");
		label_3.setBounds(297, 125, 66, 16);

		getContentPane().add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("شرح ایده");
		label_4.setBounds(297, 203, 66, 16);

		getContentPane().add(label_5);
		label_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_5.setText("سابقه ایده");
		label_5.setBounds(297, 283, 66, 16);

		getContentPane().add(label_6);
		label_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_6.setText("ادعانامه");
		label_6.setBounds(297, 361, 66, 16);

		getContentPane().add(label_7);
		label_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_7.setText("شرح کامل");
		label_7.setBounds(297, 439, 66, 16);

		getContentPane().add(label_8);
		label_8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_8.setText("فایل های پیوست");
		label_8.setBounds(297, 517, 66, 16);

		getContentPane().add(scrollPane);
		scrollPane.setBounds(10, 69, 353, 50);

		scrollPane.setViewportView(descTextPane);
		descTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		descTextPane.setText("این اختراع یک آپولوی در ابعاد آزمایشگاهی است.");
		// end temp
		descTextPane.setEditable(false);

		getContentPane().add(scrollPane_2);
		scrollPane_2.setBounds(10, 147, 353, 50);

		scrollPane_2.setViewportView(abstractTextPane);
		abstractTextPane
				.setText("پروژه فضایی آپولو (به انگلیسی: Apollo Program) یکی از پروژه‌های فضایی ناسا در زمان مسابقه فضایی میان شوروی و آمریکا بود که کوشش می‌کرد تا اولین انسان را بر روی سطح کره ماه فرود بیاورد. ");
		// end temp
		abstractTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		abstractTextPane.setEditable(false);

		getContentPane().add(scrollPane_3);
		scrollPane_3.setBounds(10, 225, 353, 50);

		scrollPane_3.setViewportView(ideaDescTextPane);
		// begin temp
		ideaDescTextPane
				.setText("ایده این است که ما دوباره آپولوی اصلی را در ابعاد کوچک آزمایشگاهی بسازیم که بفهمیم راست بوده است یا دروغ.");
		// end temp
		ideaDescTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaDescTextPane.setEditable(false);

		getContentPane().add(scrollPane_4);
		scrollPane_4.setBounds(10, 305, 353, 50);

		scrollPane_4.setViewportView(ideaHistoryTextPane);
		// begin temp
		ideaHistoryTextPane
				.setText("آپولو پس از ریاست جمهوری بعدی آمریکا جان اف. کندی با جدیت ادامه پیدا کرد. جان اف. کندی پشتیبانی خود از طرح فرود انسان بر روی کره ماه را طی یک سخنرانی ویژه خطاب به کنگره در ماه مه ۱۹۶۱ بدین گونه اعلام کرد:...من اعتقاد دارم کشورم می‌بایست برای دستیابی به هدف فرود انسان بر روی کره ماه و به سلامت بازگشتن به زمین قبل از خروج از این دهه متعهد شود.در این دوره هیج برنامه فضایی دیگری نمی‌تواند برای بشر تأثیرگذارتر از اکتشاف مسیرهای با برد طولانی در فضا باشد؛ و انجام هیچ کدام نمی‌تواند تا این حد سخت و گران باشد.");
		// end temp
		ideaHistoryTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaHistoryTextPane.setEditable(false);

		getContentPane().add(scrollPane_5);
		scrollPane_5.setBounds(10, 383, 353, 50);

		scrollPane_5.setViewportView(assertTextPane);
		// begin temp
		assertTextPane
				.setText("1. ادعا می کنیم این آپولو با آپولوی اصلی هیچ تفاوتی ندارد الا این که در مقیاس 1/5 است.");
		// end temp
		assertTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		assertTextPane.setEditable(false);

		getContentPane().add(scrollPane_6);
		scrollPane_6.setBounds(10, 461, 353, 50);

		scrollPane_6.setViewportView(fullDescTextPane);
		fullDescTextPane.setEditable(false);
		// begin temp
		fullDescTextPane
				.setText("روژه فضایی آپولو (به انگلیسی: Apollo Program) یکی از پروژه‌های فضایی ناسا در زمان مسابقه فضایی میان شوروی و آمریکا بود که کوشش می‌کرد تا اولین انسان را بر روی سطح کره ماه فرود بیاورد. پروژه در دوره ریاست جمهوری دوایت آیزنهاور شروع به کار کرد، آپولو پس از ریاست جمهوری بعدی آمریکا جان اف. کندی با جدیت ادامه پیدا کرد. جان اف. کندی پشتیبانی خود از طرح فرود انسان بر روی کره ماه را طی یک سخنرانی ویژه خطاب به کنگره در ماه مه ۱۹۶۱ بدین گونه اعلام کرد:...من اعتقاد دارم کشورم می‌بایست برای دستیابی به هدف فرود انسان بر روی کره ماه و به سلامت بازگشتن به زمین قبل از خروج از این دهه متعهد شود.در این دوره هیج برنامه فضایی دیگری نمی‌تواند برای بشر تأثیرگذارتر از اکتشاف مسیرهای با برد طولانی در فضا باشد؛ و انجام هیچ کدام نمی‌تواند تا این حد سخت و گران باشد.");
		// end temp
		fullDescTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(fileTextField1);
		fileTextField1.setEditable(false);
		fileTextField1
				.setText("C:University StuffObject Oriented DesignProjectdefinitionDefinition.pdf");
		fileTextField1.setBounds(10, 534, 353, 20);

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("تأیید نهایی");
		button.setBounds(279, 571, 84, 26);

		getContentPane().add(button_1);
		button_1.addActionListener(new Button_1ActionListener());
		button_1.setText("تعیین ارتباط با اختراع های دیگر");
		button_1.setBounds(10, 571, 176, 26);

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
		this.setVisible(false);
	}

	protected void button_1_actionPerformed(ActionEvent e) {
		new InvRegReqRelations().setVisible(true);
	}

}
