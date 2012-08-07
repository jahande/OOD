package invregsystem.ui;

import interfaces.AbstractUser;
import invregsystem.logic.member.Message;
import invregsystem.logic.member.MessageCatalog;

import java.awt.ComponentOrientation;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

public class Messages extends JFrame {

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] { "تاریخ", "عنوان", "متن" };
		private List<Message> messages;

		public TableTableModel(List<Message> messages) {
			this.messages = messages;
		}

		public int getRowCount() {
			return messages.size();
		}

		public int getColumnCount() {
			return COLUMNS.length;
		}

		public String getColumnName(int column) {
			return COLUMNS[column];
		}

		public Object getValueAt(int row, int column) {
			String colName = COLUMNS[column];
			Message message = null;
			try {
				message = messages.get(row);
			} catch (IndexOutOfBoundsException e) {
				return "Error";
			}
			if (colName.equals("تاریخ")) {
				return message.getSendDate();
			} else if (colName.equals("عنوان")) {
				return message.getTitle();
			} else if (colName.equals("متن")) {
				return message.getContent();
			} else {
				return "Error";
			}
		}
	}

	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();

	private AbstractUser currentUser;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Messages frame = new Messages(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public Messages(AbstractUser currentUser) {
		super();
		this.currentUser = currentUser;
		
		setBounds(100, 100, 700, 191);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("پیغام ها");

		getContentPane().add(scrollPane);
		scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setBounds(23, 10, 643, 133);

		MessageCatalog messageCatalog = MessageCatalog.getInstance();
		List<Message> messages = messageCatalog.getMessagesByUser(currentUser);

		scrollPane.setViewportView(table);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setModel(new TableTableModel(messages));

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn col = table.getColumnModel().getColumn(table.getColumnCount() - 1);
		col.setPreferredWidth(500);
	}

}
