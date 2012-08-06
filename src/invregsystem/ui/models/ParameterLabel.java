package invregsystem.ui.models;

import javax.swing.JLabel;

public class ParameterLabel<E> extends JLabel {

	private E parameter = null;
	public E getParameter() {
		return this.parameter;
	}
	public void setParameter(E parameter) {
		this.parameter= parameter;
	}
	

}
