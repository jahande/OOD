package invregsystem.ui;

import invregsystem.logic.Request;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
import invregsystem.logic.invention.InventionFieldRegistrationRequest;
import invregsystem.logic.invention.InventionFieldRegistrationRequestCatalog;
import invregsystem.logic.member.Message;
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

public class AcceptOrRejectAddNewFieldRequest extends AcceptOrRejectBase
		implements NeedRefreshData {

	public AcceptOrRejectAddNewFieldRequest() {
		this.catalogInstance = InventionFieldRegistrationRequestCatalog
				.getInstance();
		this.requests = this.catalogInstance.getAllItems();
	}

	@Override
	protected Message getAcceptMessage(Request request) {
		InventionFieldRegistrationRequest i = (InventionFieldRegistrationRequest) request;
		return new Message("رد درخواست ثبت حوزه‌ی اختراع",
				"درخواست شما مبنی بر ثبت حوزه‌ی " + i.getFieldName()
						+ " توسط مدیر سایت رد شده است", i.getUser());
	}

	@Override
	protected Message getRejectMessage(Request request) {
		InventionFieldRegistrationRequest i = (InventionFieldRegistrationRequest) request;
		return new Message("تایید درخواست ثبت حوزه‌ی اختراع",
				"درخواست شما مبنی بر ثبت حوزه‌ی " + i.getFieldName()
						+ "توسط مدیر سایت تایید شده است ", i.getUser());
	}
}
