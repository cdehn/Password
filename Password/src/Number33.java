import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.JPasswordField;

public class Number33 {

	private JFrame frame;
	public JButton btnHelp1;

	//Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Number33 window = new Number33();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Number33() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		final JPasswordField password1 = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, password1, 95,
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, password1, 6,
				SpringLayout.EAST, password1);
		springLayout.putConstraint(SpringLayout.EAST, password1, -15,
				SpringLayout.WEST, btnHelp1);
		frame.getContentPane().add(password1);

		
		JLabel password = new JLabel("Enter the Password:");
		springLayout.putConstraint(SpringLayout.NORTH, password, 95,
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, password, 41,
				SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, password, -249,
				SpringLayout.EAST, frame.getContentPane());
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(password);
		password.setLabelFor(password1);

		
		JButton btnOk = new JButton("OK");
		springLayout.putConstraint(SpringLayout.NORTH, btnOk, 69,
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnOk, 335,
				SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnOk, -31,
				SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				char[] input = password1.getPassword();
					if (passwordCorrect(input) == true) {
						JOptionPane.showMessageDialog(frame,
								"Success! You typed the right password.");
					} 
					else {
						JOptionPane.showMessageDialog(frame, "Invalid password, try again");
					}
			}

			private boolean passwordCorrect(char[] input) {
				char[] correctPwd = { 'b', 'u', 'g', 'a', 'b', 'o', 'o' };
				boolean password = true;
				if (input.length != correctPwd.length) {
					password = false;
				}

				else {
					password = true;
				}

				Arrays.fill(correctPwd, '0');
				return password;
			}});
		

		JButton btnHelp1 = new JButton("Help");
		springLayout.putConstraint(SpringLayout.NORTH, btnHelp1, 20,
				SpringLayout.SOUTH, btnOk);
		springLayout.putConstraint(SpringLayout.WEST, btnHelp1, 150,
				SpringLayout.EAST, password);
		springLayout.putConstraint(SpringLayout.EAST, btnHelp1, -31,
				SpringLayout.EAST, frame.getContentPane());
		btnHelp1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,
								"You can get the password by searching this example's source code for \n"
										+ "the string 'correctPassword.' Or look at the section How to Use Password Fields  \n"
										+ "in the components section of The Java Tutorial.");
			}
		});
		}
	}
