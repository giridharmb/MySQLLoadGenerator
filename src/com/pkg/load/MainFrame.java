package com.pkg.load;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	private JTextField tf_server_ip;
	private JTextField tf_server_port;
	private JTextField tf_row_insert_per_thread;
	private JTextField tf_commits_per_statement;
	private JTextField tf_csv_file_name;
	private JTextField tf_concurrency;
	private JTextField tf_detach;
	private JTextField tf_iterations;
	private JTextField tf_varchar_columns;
	private JTextField tf_int_columns;
	private JTextField tf_password;
	private JTextField tf_username;
	private JTextField tf_status;
		
	private String slap1 = "/usr/local/mysql/bin/mysqlslap";
	private String slap2 = "/usr/bin/mysqlslap";
	
	private void _l(String str) {
		System.out.println("");
	}
	
	private String getMysqlSlapBin() {
		String s = "";
		
		File f1 = new File(slap1);
		File f2 = new File(slap2);
		
		if(f1.exists()) {
			s = slap1;
		} else if(f2.exists()){
			s = slap2;
		} else {
			tf_status.setText("Slap File Does not exist !");
		}
				
		return s;
	}
	
	private void setup() {
		setupIntegerKeyListener(tf_server_port);
		setupIntegerKeyListener(tf_row_insert_per_thread);
		setupIntegerKeyListener(tf_commits_per_statement);
		setupIntegerKeyListener(tf_concurrency);
		
		setupIntegerKeyListener(tf_detach);
		setupIntegerKeyListener(tf_iterations);
		setupIntegerKeyListener(tf_varchar_columns);
		setupIntegerKeyListener(tf_int_columns);
		
		setupIntegerDotKeyListener(tf_server_ip);
		
	}
	
	private String getLaunchCommand() {
		String retStr = "";
				
		return retStr;
	}
	
	private void launchTest() {
		
	}
	
	private void setupIntegerKeyListener(JTextField tf) {
		tf.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				char c = arg0.getKeyChar();
				if(c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
					if( ! ((c == '0') || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c=='6'|| c=='7' || c=='8' || c=='9')) {
						arg0.consume(); // ignore this key
					}
				}
			}
			
		});
	}
	
	private void setupIntegerDotKeyListener(JTextField tf) {
		tf.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				char c = arg0.getKeyChar();
				if(c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
					if( ! ((c == '0') || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c=='6'|| c=='7' || c=='8' || c=='9' || c=='.' )) {
						arg0.consume(); // ignore this key
					}
				}
			}
			
		});
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setTitle("MySQL Stress Test \u00A9 Giridhar Bhujanga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMysqlServerHost = new JLabel("MySQL Server Host IP");
		lblMysqlServerHost.setBounds(35, 24, 163, 16);
		contentPane.add(lblMysqlServerHost);
		
		tf_server_ip = new JTextField();
		tf_server_ip.setHorizontalAlignment(SwingConstants.CENTER);
		tf_server_ip.setBounds(210, 18, 261, 28);
		contentPane.add(tf_server_ip);
		tf_server_ip.setColumns(10);
		
		JLabel lblServerPort = new JLabel("Server Port");
		lblServerPort.setBounds(497, 24, 96, 16);
		contentPane.add(lblServerPort);
		
		tf_server_port = new JTextField();
		tf_server_port.setHorizontalAlignment(SwingConstants.CENTER);
		tf_server_port.setBounds(605, 18, 90, 28);
		contentPane.add(tf_server_port);
		tf_server_port.setColumns(10);
		
		JComboBox cb_load_type = new JComboBox();
		cb_load_type.setBounds(290, 102, 197, 27);
		contentPane.add(cb_load_type);
		
		JLabel lblLoadType = new JLabel("Load Type");
		lblLoadType.setBounds(35, 106, 248, 16);
		contentPane.add(lblLoadType);
		
		JLabel lblNumberOfRow = new JLabel("Number of Row Inserts Per Thread");
		lblNumberOfRow.setBounds(35, 147, 248, 16);
		contentPane.add(lblNumberOfRow);
		
		tf_row_insert_per_thread = new JTextField();
		tf_row_insert_per_thread.setHorizontalAlignment(SwingConstants.CENTER);
		tf_row_insert_per_thread.setBounds(290, 141, 139, 28);
		contentPane.add(tf_row_insert_per_thread);
		tf_row_insert_per_thread.setColumns(10);
		
		JLabel lblCommitsEveryx = new JLabel("Commits every (X) Statements");
		lblCommitsEveryx.setBounds(35, 185, 248, 16);
		contentPane.add(lblCommitsEveryx);
		
		tf_commits_per_statement = new JTextField();
		tf_commits_per_statement.setHorizontalAlignment(SwingConstants.CENTER);
		tf_commits_per_statement.setBounds(290, 179, 139, 28);
		contentPane.add(tf_commits_per_statement);
		tf_commits_per_statement.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Generate CSV Output : File Name");
		chckbxNewCheckBox.setBounds(27, 219, 256, 23);
		contentPane.add(chckbxNewCheckBox);
		
		tf_csv_file_name = new JTextField();
		tf_csv_file_name.setHorizontalAlignment(SwingConstants.CENTER);
		tf_csv_file_name.setBounds(290, 217, 345, 28);
		contentPane.add(tf_csv_file_name);
		tf_csv_file_name.setColumns(10);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("User Compression in server/client protocol");
		chckbxNewCheckBox_1.setBounds(27, 262, 460, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JLabel lblConcurrencynumberOf = new JLabel("Concurrency (Number of clients to simulate for query to run)");
		lblConcurrencynumberOf.setBounds(35, 304, 452, 16);
		contentPane.add(lblConcurrencynumberOf);
		
		tf_concurrency = new JTextField();
		tf_concurrency.setHorizontalAlignment(SwingConstants.CENTER);
		tf_concurrency.setBounds(501, 298, 134, 28);
		contentPane.add(tf_concurrency);
		tf_concurrency.setColumns(10);
		
		JLabel lblDetachcloseAnd = new JLabel("Detach (close and reopen) connections after X number of requests");
		lblDetachcloseAnd.setBounds(35, 344, 452, 16);
		contentPane.add(lblDetachcloseAnd);
		
		tf_detach = new JTextField();
		tf_detach.setHorizontalAlignment(SwingConstants.CENTER);
		tf_detach.setBounds(501, 338, 134, 28);
		contentPane.add(tf_detach);
		tf_detach.setColumns(10);
		
		JLabel lblIterationsnumberOf = new JLabel("Iterations (number of times to run the tests)");
		lblIterationsnumberOf.setBounds(35, 384, 452, 16);
		contentPane.add(lblIterationsnumberOf);
		
		tf_iterations = new JTextField();
		tf_iterations.setHorizontalAlignment(SwingConstants.CENTER);
		tf_iterations.setBounds(501, 378, 134, 28);
		contentPane.add(tf_iterations);
		tf_iterations.setColumns(10);
		
		JCheckBox chckbxDoNotDrop = new JCheckBox("Do not drop schema after the test");
		chckbxDoNotDrop.setBounds(27, 425, 460, 23);
		contentPane.add(chckbxDoNotDrop);
		
		JLabel lblNumberOfVarcher = new JLabel("Number of VARCHAR columns to create in table");
		lblNumberOfVarcher.setBounds(35, 470, 356, 16);
		contentPane.add(lblNumberOfVarcher);
		
		tf_varchar_columns = new JTextField();
		tf_varchar_columns.setHorizontalAlignment(SwingConstants.CENTER);
		tf_varchar_columns.setBounds(403, 464, 134, 28);
		contentPane.add(tf_varchar_columns);
		tf_varchar_columns.setColumns(10);
		
		JLabel lblNumberOfInt = new JLabel("Number of INT columns to create in table");
		lblNumberOfInt.setBounds(35, 510, 356, 16);
		contentPane.add(lblNumberOfInt);
		
		tf_int_columns = new JTextField();
		tf_int_columns.setHorizontalAlignment(SwingConstants.CENTER);
		tf_int_columns.setBounds(403, 504, 134, 28);
		contentPane.add(tf_int_columns);
		tf_int_columns.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(382, 68, 90, 16);
		contentPane.add(lblPassword);
		
		tf_password = new JTextField();
		tf_password.setHorizontalAlignment(SwingConstants.CENTER);
		tf_password.setBounds(498, 62, 197, 28);
		contentPane.add(tf_password);
		tf_password.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(35, 68, 163, 16);
		contentPane.add(lblUserName);
		
		tf_username = new JTextField();
		tf_username.setHorizontalAlignment(SwingConstants.CENTER);
		tf_username.setBounds(210, 62, 143, 28);
		contentPane.add(tf_username);
		tf_username.setColumns(10);
		
		JButton btn_launch = new JButton("Launch the MySQL Stress Test !");
		btn_launch.setBounds(35, 556, 303, 36);
		contentPane.add(btn_launch);
		
		JButton btn_stop = new JButton("Stop !");
		btn_stop.setBounds(350, 556, 185, 36);
		contentPane.add(btn_stop);
		
		JButton btn_exit = new JButton("Exit");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btn_exit.setBounds(547, 556, 117, 36);
		contentPane.add(btn_exit);
		
		tf_status = new JTextField();
		tf_status.setHorizontalAlignment(SwingConstants.CENTER);
		tf_status.setEditable(false);
		tf_status.setBounds(120, 607, 544, 28);
		contentPane.add(tf_status);
		tf_status.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(35, 613, 61, 16);
		contentPane.add(lblStatus);
		
		setup();
	}
}

