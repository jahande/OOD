package invregsystem.ui.models;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListMouseAdapter<E> extends MouseAdapter {
	private final ListMouseListenner listenner;
	private final E listElement;

	private ListMouseAdapter() {
		listElement = null;
		this.listenner = null;
	}

	public ListMouseAdapter(E inf,ListMouseListenner listenner) {
		this.listElement = inf;
		this.listenner = listenner;
	}

	public void mouseClicked(MouseEvent e) {
		this.listenner.listMouseListennerActionPerform(e, this.listElement);
	}
}