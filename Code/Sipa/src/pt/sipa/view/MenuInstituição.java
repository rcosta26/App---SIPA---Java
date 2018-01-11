package pt.sipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pt.sipa.controller.Sipa;
import pt.sipa.model.TipoUtilizador;

public class MenuInstituição extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuInstituição() {
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   
		   Date date = new Date();
		   System.out.println(dateFormat.format(date));
		  
		   Calendar cal = Calendar.getInstance();
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLogo.setBounds(10, 94, 218, 83);
		lblLogo.setIcon(new ImageIcon(Menu.class.getResource("/pt/sipa/res/icon horizontal.png")));
		contentPane.add(lblLogo);
		
		JButton bt_listagem = new JButton("Listagem");
		bt_listagem.setFont(new Font("Tahoma", Font.BOLD, 10));
		bt_listagem.setBounds(36, 38, 97, 30);
		bt_listagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListagemFr listagem =new ListagemFr();
				listagem.setVisible(true);
			}
		});
		contentPane.add(bt_listagem);
		
		JButton bt_mudaruser = new JButton("Mudar User");
		bt_mudaruser.setFont(new Font("Tahoma", Font.BOLD, 10));
		bt_mudaruser.setBounds(219, 38, 97, 30);
		bt_mudaruser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
		
		JLabel label = new JLabel("2016/07/13 15:13:06");
		label.setBounds(34, 188, 85, 11);
		label.setFont(new Font("Tahoma", Font.PLAIN, 9));
		contentPane.add(label);
		
		JLabel lblSessoIniciadaComo = new JLabel("Sess\u00E3o Iniciada:");
		lblSessoIniciadaComo.setBounds(203, 182, 72, 21);
		lblSessoIniciadaComo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(lblSessoIniciadaComo);
		contentPane.add(bt_mudaruser);
		
		JLabel lblUser = new JLabel(Sipa.nomeUtilizador);
		lblUser.setBounds(285, 182, 71, 21);
		contentPane.add(lblUser);
		
		
	
		
		
	}
}
