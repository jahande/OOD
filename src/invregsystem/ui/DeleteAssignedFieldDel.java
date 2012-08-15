package invregsystem.ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import invregsystem.AbstractUser;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
import invregsystem.logic.member.UserCatalog;

/**
 * 
 * @author rj
 * @usecase 42
 */

public class DeleteAssignedFieldDel extends SelectInventionFieldBase {

	private AbstractUser user;

	/**
	 * Create the frame
	 */
	public DeleteAssignedFieldDel(AbstractUser user) {
		super(Color.RED, "حذف");
		this.user = user;
		this.setTitle("حذف حوزه‌ی کارشناسی از "
				+this.user.getFullName());
		try {
			inventionFields = (InventionFieldCatalog.getInstance()
					.getInventionFieldsOfExpert(this.user));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۱");
			return;
		}
	}

	@Override
	protected void nextActionPerform(MouseEvent e, InventionField inf) {
		// TODO Auto-generated method stub
		JLabel mes = new JLabel(
				"آیا شما به حذف حوزه‌ی اختراع از کارشناس مطمئن هستید؟ این عمل برگشت پذیر نیست!");
		int n = JOptionPane.showOptionDialog(this, mes, "اخطار",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
				null, null, null);
		// pane.set
		if (n == JOptionPane.YES_OPTION) {
			InventionFieldCatalog catalog = null;

			catalog = InventionFieldCatalog.getInstance();
			catalog.removeInventionFieldFromExpert(this.user, inf);
			if (this.user.getInventionFields() == null) {
				System.out.println("sassasssasssa");
			}
			if (catalog.getInventionFieldsOfExpert(this.user) == null
					|| catalog.getInventionFieldsOfExpert(this.user).size() <= 0) {
				this.user.setExpert(false);
				UserCatalog.getInstance().updateItem(this.user);
			}
			this.setVisible(false);
			this.dispose();
			// this.refreshData();

		}

	}

}
