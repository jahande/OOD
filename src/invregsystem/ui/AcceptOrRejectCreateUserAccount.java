package invregsystem.ui;

import invregsystem.logic.invention.InventionFieldRegistrationRequestCatalog;
import invregsystem.logic.member.UserRegistrationRequestCatalog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 * @usecase 29
 */

public class AcceptOrRejectCreateUserAccount extends AcceptOrRejectBase {
	public AcceptOrRejectCreateUserAccount() {
		this.catalogInstance = UserRegistrationRequestCatalog
				.getInstance();
		this.requests = this.catalogInstance.getAllItems();
	}
}