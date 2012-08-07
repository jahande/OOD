package invregsystem.ui;

import interfaces.AbstractUser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 * @usecase 38(1)
 */
public class ViewAssignmentedFieldsSel extends SelectUser {
	/**
	 * Create the frame
	 */
	public ViewAssignmentedFieldsSel() {
		super();
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
		
	}
	@Override
	protected void nextActionPerform(MouseEvent e, AbstractUser user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void returnActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.dispose();
		
	}
	

}
