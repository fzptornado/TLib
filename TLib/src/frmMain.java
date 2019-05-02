import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Forms.frmBook;

public class frmMain extends JFrame {
	public static final int tWidth = 600;
	public static final int tHeight = 500;

	private JButton manageBooks;
	public frmMain() {
		super("Books Manager System");
		this.setBounds(500, 100, tWidth, tHeight);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		
		
		//Manage Books Form Button
		manageBooks = new JButton("Book Mng.");
		manageBooks.setEnabled(true);
		manageBooks.setBounds(50, 50, 100, 30);
		manageBooks.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new frmBook().setVisible(true);
				//dispose();Close Current From				
			}
		});
		this.add(manageBooks);
		//Create Set Button
		
		
	}

	public static void main(String[] args) {
		new frmMain();
	}

}
