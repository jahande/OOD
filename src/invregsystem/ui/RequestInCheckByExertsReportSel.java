package invregsystem.ui;

import invregsystem.AbstractUser;
import invregsystem.logic.member.UserCatalog;

import java.awt.Dimension;
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
		this.users = UserCatalog.getInstance().getExperts();
		this.setPreferredSize(new Dimension(550,238));
		this.setBounds(100, 100, 500, 410);
	}
	@Override
	protected void nextActionPerform(MouseEvent e, AbstractUser user) {
		RequestInCheckByExertsReportView byExertsReportView = new RequestInCheckByExertsReportView(user);
		byExertsReportView.refreshData();
		byExertsReportView.setVisible(true);
		
	}
	@Override
	public void refreshData() {
		this.setTitle("اخذ گزارش وضعیت بررسی ختراعاتی توسط یک کارشناس");
		
		this.users = UserCatalog.getInstance().getExperts();
		super.refreshData();
	}

	

}
