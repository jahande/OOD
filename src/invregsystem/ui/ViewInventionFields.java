package invregsystem.ui;

import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
import java.util.List;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * 
 * @author rj
 * @usecase 42
 */

public class ViewInventionFields extends ViewInventionFieldBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5082707021067791884L;
	private JList list = null;
	private final JLabel label = new JLabel();
	// private final JLabel label_1 = new JLabel();
	// private final JLabel label_3 = new JLabel();
	// private final JLabel label_4 = new JLabel();
	// private final JLabel label_5 = new JLabel();
	private final JButton button = new JButton();

	/**
	 * Create the frame
	 */
	public ViewInventionFields() {
		super();
		setBounds(100, 100, 393, 410);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			this.inventionFields = (List<InventionField>) (InventionFieldCatalog
					.getInstance().getAllItems());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۳۳");
			return;
		}
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("مشاهده‌ی حوزه‌های اختراع");

	}

}
