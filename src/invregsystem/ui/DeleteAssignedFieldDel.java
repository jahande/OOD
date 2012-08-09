package invregsystem.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;



import invregsystem.AbstractUser;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
import invregsystem.ui.models.ListMouseAdapter;
import invregsystem.ui.models.ListMouseListenner;
import invregsystem.ui.models.NeedRefreshData;
import invregsystem.ui.models.ParameterLabel;
import invregsystem.ui.models.SimpleListModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



/**
 * 
 * @author rj
 * @usecase 42
 */

public class DeleteAssignedFieldDel extends SelectInventionFieldBase{

	private AbstractUser user;
		/**
	 * Create the frame
	 */
	public DeleteAssignedFieldDel(AbstractUser user) {
		super(Color.RED,"حذف");
		this.user = user;
		setBounds(100, 100, 393, 410);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			inventionFields = (InventionFieldCatalog.getInstance().getInventionFieldsOfExpert(this.user));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۱");
			return;
		}
		//
	}


	

	

	
	

	
	@Override
	protected void nextActionPerform(MouseEvent e, InventionField inf) {
		// TODO Auto-generated method stub
		JLabel mes = new JLabel("آیا شما به حذف حوزه‌ی اختراع از کارشناس مطمئن هستید؟ این عمل برگشت پذیر نیست!");
		int n = JOptionPane.showOptionDialog(this, mes, "اخطار", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
		// pane.set
		if (n == JOptionPane.YES_OPTION) {
			InventionFieldCatalog catalog = null;
			try {
				catalog = InventionFieldCatalog.getInstance();
				catalog.removeInventionFieldFromExpert(this.user, inf);
				this.setVisible(false);
				this.dispose();
				//this.refreshData();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۵");
				return;
			}
		}
		
	}


}
