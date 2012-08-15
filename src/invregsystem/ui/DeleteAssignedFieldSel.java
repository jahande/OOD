package invregsystem.ui;

import invregsystem.AbstractUser;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
import invregsystem.ui.models.SimpleListModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 * @usecase 37(1)
 */

public class DeleteAssignedFieldSel extends SelectUser {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2316546092488565792L;

	public DeleteAssignedFieldSel() {
		super();
		this.setTitle("حذف حوزه‌ی کارشناسی اختصاص داده شده");
	}

	@Override
	protected void nextActionPerform(MouseEvent e, AbstractUser user) {
		DeleteAssignedFieldDel assignedFieldDel = new DeleteAssignedFieldDel(user);
		assignedFieldDel.refreshData();
		assignedFieldDel.setVisible(true);
	}

	@Override
	protected void returnActionPerform(ActionEvent e) {
		this.setVisible(false);
		this.dispose();
	}


}
