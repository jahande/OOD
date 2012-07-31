package invregsystem.ui;

import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 * 
 * @author rj
 * @usecase 40
 */

public class AddInventionField extends JFrame {

	private final JButton button = new JButton();
	private final JTextField textField = new JTextField();
	private final JLabel label = new JLabel();

	private final JButton button_1 = new JButton();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			AddInventionField frame = new AddInventionField();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public AddInventionField() {
		super();
		setBounds(100, 100, 277, 173);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("افزودن حوزه‌ی اختراع");

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("افزودن");
		button.setBounds(37, 103, 87, 26);

		getContentPane().add(textField);
		textField.setBounds(37, 66, 87, 20);

		getContentPane().add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setText("نام حوزه‌ی اختراع");
		label.setBounds(154, 68, 88, 16);

		getContentPane().add(button_1);
		button_1.addActionListener(new Button_1ActionListener());
		button_1.setText("بازگشت");
		button_1.setBounds(141, 103, 106, 26);
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
		String name = this.textField.getText();
		if (name == null || name.equals("")) {
			JOptionPane.showMessageDialog(this, "شما نامی را وارد نکردید.");
		} else {
			InventionFieldCatalog catalog = InventionFieldCatalog.getInstance();
			catalog.addItem(new InventionField(name));
			JOptionPane.showMessageDialog(this, "حوزه اختراع \"" + name
					+ "\" با موفقیت ثبت شد");
		}
	}

	protected void button_1_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
