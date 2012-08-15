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

	/**
	 * 
	 */
	private static final long serialVersionUID = -5913029577889271684L;

	public ViewAssignmentedFieldsView(AbstractUser user) {
		super();
		this.setTitle(" مشاهده‌ی حوزه‌های کارشناسی "
				+user.getFullName());
		this.inventionFields = InventionFieldCatalog.getInstance().getInventionFieldsOfExpert(user);
		
	}

	

	
}
