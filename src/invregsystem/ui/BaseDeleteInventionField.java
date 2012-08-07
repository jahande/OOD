package invregsystem.ui;

import javax.swing.JFrame;

public class BaseDeleteInventionField extends JFrame {

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			BaseDeleteInventionField frame = new BaseDeleteInventionField();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public BaseDeleteInventionField() {
		super();
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
	}

}
