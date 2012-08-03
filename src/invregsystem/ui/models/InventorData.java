package invregsystem.ui.models;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class InventorData {
	public InventorData(JComboBox inventorCombobox, JCheckBox defaultCheckBox, JTextField shareTextField) {
		this.inventorCombobox = inventorCombobox;
		this.defaultCheckBox = defaultCheckBox;
		this.shareTextField = shareTextField;
	}

	private JComboBox inventorCombobox;
	private JCheckBox defaultCheckBox;
	private JTextField shareTextField;

	public JComboBox getInventorCombobox() {
		return inventorCombobox;
	}

	public void setInventorCombobox(JComboBox inventorCombobox) {
		this.inventorCombobox = inventorCombobox;
	}

	public JCheckBox getDefaultCheckBox() {
		return defaultCheckBox;
	}

	public void setDefaultCheckBox(JCheckBox defaultCheckBox) {
		this.defaultCheckBox = defaultCheckBox;
	}

	public JTextField getShareTextField() {
		return shareTextField;
	}

	public void setShareTextField(JTextField shareTextField) {
		this.shareTextField = shareTextField;
	}
}
