package uimodels;

import javax.swing.JFrame;

import controllers.Controller;

public  class BaseFrame extends JFrame {

	protected Controller controller;
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			BaseFrame frame = new BaseFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public BaseFrame(Controller c){
		this();
		this.controller = c;
		this.setVisible(false);	
	}

	/**
	 * Create the frame
	 */
	private BaseFrame() {
		super();
		this.setVisible(false);
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
	}
	protected String getClassName() {
		return this.getClass().getSimpleName();
	}
	protected void simpleCommand(String command) {
		controller.next(null, getClassName(), command);
	}

}
