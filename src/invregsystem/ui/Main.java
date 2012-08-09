package invregsystem.ui;

import invregsystem.ui.models.RequestExpirationTimer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RequestExpirationTimer requestExpirationTimer = RequestExpirationTimer.getInstance();
		requestExpirationTimer.start();
		new Login().setVisible(true);
	}

}
