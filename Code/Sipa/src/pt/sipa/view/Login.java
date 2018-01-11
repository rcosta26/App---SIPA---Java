package pt.sipa.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pt.sipa.controller.ManagerUtilizador;
import pt.sipa.controller.Sipa;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	static JTextField txtUsername;
	private JPasswordField txtPassw;
	private JLabel lblUsername;
	private JLabel lblPasswprd;
	private JLabel lblPporto;

	
	
	/**
	 * Create the frame.
	 */
	public Login() {
		setFont(new Font("Myriad Pro", Font.PLAIN, 12));
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSipaIcon = new JLabel("SIPA ICON");
		lblSipaIcon.setIcon(new ImageIcon(Login.class.getResource("/pt/sipa/res/sipa.png")));
		lblSipaIcon.setBounds(22, 15, 211, 289);
		contentPane.add(lblSipaIcon);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(Color.BLACK);
		txtUsername.setBounds(351, 93, 173, 40);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton blogin = new JButton("Enter");
		blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 if (ManagerUtilizador.isUtilizador(txtUsername.getText(), txtPassw.getText()) == true) {
	 JOptionPane.showMessageDialog(null, "Bem-vindo ! ! !");
	 Sipa.nomeUtilizador=txtUsername.getText();
	 if(Sipa.permissao.equals("instituicao")){
		 MenuInstituição mi = new MenuInstituição();
		 mi.setVisible(true);
		 Login.this.dispose();
	 }
	 else
	 {	 
	 Menu m = new Menu();
	 m.setVisible(true);
	 Login.this.dispose();
	 }
 	}
	 	else {
					JOptionPane.showMessageDialog(null, "Credenciais Erradas");
				}
			}
		});
		blogin.setBounds(424, 215, 89, 23);
		contentPane.add(blogin);
		
		txtPassw = new JPasswordField();
		txtPassw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_ENTER)
	                {
					 if (ManagerUtilizador.isUtilizador(txtUsername.getText(), txtPassw.getText()) == true) {
						 JOptionPane.showMessageDialog(null, "Bem-vindo ! ! !");
						 Sipa.nomeUtilizador=txtUsername.getText();
						 if(Sipa.permissao.equals("instituicao")){
							 MenuInstituição mi = new MenuInstituição();
							 mi.setVisible(true);
							 Login.this.dispose();
						 }
						 else
						 {	 
						 Menu m = new Menu();
						 m.setVisible(true);
						 Login.this.dispose();
						 }
					 	}
						 	else {
										JOptionPane.showMessageDialog(null, "Credenciais Erradas");
									}
								}
	                }
			
		});
		txtPassw.setBounds(351, 139, 173, 40);
		contentPane.add(txtPassw);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(276, 106, 74, 14);
		contentPane.add(lblUsername);
		
		lblPasswprd = new JLabel("Password:");
		lblPasswprd.setBounds(276, 152, 74, 14);
		contentPane.add(lblPasswprd);
		
		lblPporto = new JLabel("P.Porto LOGO");
		lblPporto.setIcon(new ImageIcon(Login.class.getResource("/pt/sipa/res/logo-ipp.png")));
		lblPporto.setBounds(351, 272, 162, 29);
		contentPane.add(lblPporto);
	}
}
