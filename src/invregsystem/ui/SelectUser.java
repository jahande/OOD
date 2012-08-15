package invregsystem.ui;

import invregsystem.AbstractUser;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
import invregsystem.logic.member.UserCatalog;
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

public abstract class SelectUser extends JFrame implements NeedRefreshData,
		ListMouseListenner {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2571937414591360868L;
	private JList list = new JList();
	private final JLabel label = new JLabel();
	private JPanel panel;// s= new JPanel();
	// private final JLabel label_1 = new JLabel();
	// private final JLabel label_3 = new JLabel();
	// private final JLabel label_4 = new JLabel();
	// private final JLabel label_5 = new JLabel();
	private final JButton button = new JButton();
	protected List<AbstractUser> users;

	public SelectUser(List<AbstractUser> users) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		if(users==null){
			try {
				this.users = (List<AbstractUser>) (UserCatalog.getInstance()
						.getAllItems());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۱");
				return;
			}
		}else{
			this.users = users;
		}
		setBounds(100, 100, 393, 410);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public SelectUser() {
		this(null);
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("مشاهده‌ی حوزه‌های اختراع");

		getContentPane().add(label);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("کاربران:");
		label.setBounds(80, 27, 240, 31);

		resetInventionFieldsPanel();

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("بازگشت");
		button.setBounds(156, 340, 106, 26);

		/*
		 * panel.add(label_1); label_1.addMouseListener(new
		 * Label_1MouseListener());
		 * label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		 * label_1.setHorizontalAlignment(SwingConstants.CENTER);
		 * label_1.setForeground(Color.RED); label_1.setPreferredSize(new
		 * Dimension(40, 10)); label_1.setText("حذف");
		 * 
		 * panel.add(label_3); label_3.setPreferredSize(new Dimension(40, 10));
		 * label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		 * label_3.setHorizontalAlignment(SwingConstants.CENTER);
		 * label_3.setForeground(Color.RED); label_3.setText("حذف");
		 * 
		 * panel.add(label_4); label_4.setPreferredSize(new Dimension(40, 10));
		 * label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		 * label_4.setHorizontalAlignment(SwingConstants.CENTER);
		 * label_4.setForeground(Color.RED); label_4.setText("حذف");
		 * 
		 * panel.add(label_5); label_5.setPreferredSize(new Dimension(40, 10));
		 * label_5.setHorizontalTextPosition(SwingConstants.CENTER);
		 * label_5.setHorizontalAlignment(SwingConstants.CENTER);
		 * label_5.setForeground(Color.RED); label_5.setText("حذف");
		 */
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			returnActionPerform(e);
		}
	}

	@Override
	public void listMouseListennerActionPerform(MouseEvent e, Object obj, String type) {
		nextActionPerform(e, (AbstractUser) (obj));

		// JOptionPane.showMessageDialog(this, ((AbstractUser)obj).getId());
	}

	public void refreshData() {
		// TODO Auto-generated method stub
		resetInventionFieldsPanel();

		// this.panel = new JPanel();
		for (AbstractUser user : this.users) {
			ParameterLabel<AbstractUser> lbl = new ParameterLabel<AbstractUser>();

			lbl.setParameter(user);
			lbl.setPreferredSize(new Dimension(40, 12));
			lbl.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			lbl.setForeground(Color.BLUE);
			lbl
					.addMouseListener(new ListMouseAdapter<AbstractUser>(user,
							this));
			lbl.setText("انتخاب");

			panel.add(lbl);

		}
		// /////////////////////////
		try {
			getContentPane().remove(list);

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "خطای شماره ی ۱۰۲۲");
			return;
		}
		ArrayList<String> names = new ArrayList<String>();
		for (AbstractUser user2 : this.users) {
			names.add(user2.getFullName());

		}
		list = new JList();
		getContentPane().add(list);
		list.setModel(new SimpleListModel(names));
		list.setBounds(83, 75, 237, 244);

	}

	private JPanel resetInventionFieldsPanel() {
		try {
			getContentPane().remove(this.panel);
		} catch (Exception e) {
			// TODO: handle exception
		}

		JPanel p = new JPanel();
		getContentPane().add(p);
		p.setBounds(13, 76, 52, 222);
		this.panel = p;

		// /////////////////////////////////////

		return p;
	}

	protected void returnActionPerform(ActionEvent e) {
		this.setVisible(false);
		this.dispose();
	}

	protected abstract void nextActionPerform(MouseEvent e, AbstractUser user);

}
