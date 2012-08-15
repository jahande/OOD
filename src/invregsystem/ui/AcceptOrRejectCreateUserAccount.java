package invregsystem.ui;

import invregsystem.AbstractUser;
import invregsystem.logic.Request;
import invregsystem.logic.invention.InventionFieldRegistrationRequestCatalog;
import invregsystem.logic.member.Message;
import invregsystem.logic.member.MessageCatalog;
import invregsystem.logic.member.UserCatalog;
import invregsystem.logic.member.UserRegistrationRequest;
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
		this.catalogInstance = UserRegistrationRequestCatalog.getInstance();
		this.requests = this.catalogInstance.getAllItems();
	}

	@Override
	protected void acceptActionPerform(MouseEvent e, Request req) {
		UserRegistrationRequest request = (UserRegistrationRequest)req;
		JLabel mes = new JLabel("آیا شما به تایید درخواست مطمئن هستید؟ !");
		int n = JOptionPane.showOptionDialog(this, mes, "تایید",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, null, null);
		// pane.set
		if (n == JOptionPane.YES_OPTION) {
			request.setState(Request.ACCEPTED);
			AbstractUser u =  request.getUser();
			u.setActive(true);
			UserCatalog.getInstance().updateItem(u);
			this.catalogInstance.updateItem(request);
			if (this.removeRequest) {
				this.catalogInstance.removeItem(request);
			}
			Message m = this.getAcceptMessage(request);
			if (m != null) {
				MessageCatalog.getInstance().addItem(
						this.getAcceptMessage(request));
			}
			this.refreshData();
		}

	}

}