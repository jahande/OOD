package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	/**
	 * Launch the application
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
		setTitle("افزودن حوزه‌ی اختراع");
		
		getContentPane().add(button);
		button.setText("افزودن");
		button.setBounds(84, 100, 106, 26);
		
		getContentPane().add(textField);
		textField.setBounds(37, 66, 87, 20);
		
		getContentPane().add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setText("نام حوزه‌ی اختراع");
		label.setBounds(154, 68, 88, 16);
	}

}
