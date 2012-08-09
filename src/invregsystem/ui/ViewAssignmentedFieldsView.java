package invregsystem.ui;

import java.util.List;

import invregsystem.AbstractUser;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
import invregsystem.logic.member.User;
import invregsystem.logic.member.UserCatalog;
import invregsystem.ui.models.SimpleListModel;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListDataListener;

/**
 * 
 * @author rj
 * @usecase 38(2)
 */

public class ViewAssignmentedFieldsView extends ViewInventionFieldBase {

	private final JList list = new JList();
	private final JLabel label = new JLabel();

	

	/**
	 * Create the frame
	 */
	public ViewAssignmentedFieldsView(AbstractUser user) {
		super();
		// setBounds(100, 100, 393, 379);
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.inventionFields = InventionFieldCatalog.getInstance().getInventionFieldsOfExpert(user);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("مشاهده‌ی حوزه‌های اختصاص داده شده");

	}

	
}
