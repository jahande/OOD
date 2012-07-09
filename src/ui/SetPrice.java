package ui;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SetPrice extends JFrame {

	private final JLabel label = new JLabel();
	private final JTextField priceTtextField = new JTextField();
	private final JButton submitButton = new JButton();
	private final JLabel label_1 = new JLabel();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			SetPrice frame = new SetPrice();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public SetPrice() {
		super();
		setBounds(100, 100, 297, 161);
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
		setTitle("تعیین قیمت");
		
		getContentPane().add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("قیمت اختراع را تعیین نمایید:");
		label.setBounds(145, 36, 120, 16);
		
		getContentPane().add(priceTtextField);
		priceTtextField.setBounds(52, 34, 87, 20);
		
		getContentPane().add(submitButton);
		submitButton.addActionListener(new SubmitButtonActionListener());
		submitButton.setText("ثبت");
		submitButton.setBounds(109, 71, 63, 26);
		
		getContentPane().add(label_1);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setText("ریال");
		label_1.setBounds(10, 36, 36, 16);
	}
	private class SubmitButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			submitButton_actionPerformed(e);
		}
	}
	protected void submitButton_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
