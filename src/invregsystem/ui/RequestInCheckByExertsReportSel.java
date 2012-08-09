package invregsystem.ui;

import invregsystem.AbstractUser;
import invregsystem.logic.member.UserCatalog;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 *
 * @usecase 46
 */
public class RequestInCheckByExertsReportSel extends SelectUser {

	public RequestInCheckByExertsReportSel() {
		
	}
	@Override
	protected void nextActionPerform(MouseEvent e, AbstractUser user) {
		RequestInCheckByExertsReportView byExertsReportView = new RequestInCheckByExertsReportView(user);
		byExertsReportView.refreshData();
		byExertsReportView.setVisible(true);
		
	}
	@Override
	public void refreshData() {
		this.users = UserCatalog.getInstance().getExperts();
		super.refreshData();
	}

	

}
