package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class test1 extends JFrame {

	private final JPanel panel = new JPanel();
	private final JButton button = new JButton();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			test1 frame = new test1();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public test1() {
		super();
		setBounds(100, 100, 500, 375);
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
		
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBounds(192, 66, 125, 116);
		
		panel.add(button);
		button.addActionListener(new ButtonActionListener());
		button.setBounds(31, 62, 69, 26);
		button.setText("New JButton");
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}
	protected void button_actionPerformed(ActionEvent e) {
	}

}
