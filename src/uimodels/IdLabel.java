package uimodels;

import javax.swing.JLabel;

public class IdLabel extends JLabel implements HasId{

	private int id = 0;
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id= id;
	}
	

}
