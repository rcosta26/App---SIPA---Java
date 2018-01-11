package pt.sipa.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import pt.sipa.controller.Sipa;
import pt.sipa.model.TipoUtilizador;
import pt.sipa.model.Utilizador;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingConstants;

public class Menu extends JFrame {
	
		
	private JPanel contentPane;
	static String datas;
	static String dias;
	

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		DateFormat dia = new SimpleDateFormat("yyyy/MM/dd");
		Date dataDia= new Date();
		Date date = new Date();
		   // verificar se a data dá 
		   System.out.println(dateFormat.format(date));
		   datas = date.toString();
		   dias=dia.format(dataDia).toString();
		   
		  
		   Calendar cal = Calendar.getInstance();
		 
			JLabel label = new JLabel(dateFormat.format(cal.getTime()));
			label.setBounds(34, 188, 85, 11);
			label.setFont(new Font("Tahoma", Font.PLAIN, 9));
			contentPane.add(label);
			
			
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLogo.setBounds(24, 95, 218, 83);
		lblLogo.setIcon(new ImageIcon(Menu.class.getResource("/pt/sipa/res/icon horizontal.png")));
		contentPane.add(lblLogo);
		
		JButton bt_doações = new JButton("  Doa\u00E7\u00F5es  ");
		bt_doações.setFont(new Font("Tahoma", Font.BOLD, 10));
		bt_doações.setBounds(387, 40, 97, 30);
		bt_doações.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hoje é dia : "+Menu.dias);
				DoaçãoFr d = new DoaçãoFr();
				d.setVisible(true);
			}
		});

	
		
		JButton bt_registar = new JButton("Registar");
		bt_registar.setFont(new Font("Tahoma", Font.BOLD, 10));
		bt_registar.setBounds(24, 40, 97, 30);
		
		bt_registar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					RegistoFr r = new RegistoFr();
					r.setVisible(true);
					dispose();
					
				
				
				
			}
		});
		contentPane.add(bt_registar);
		
		JButton bt_reclamar = new JButton("Reclamar");
		bt_reclamar.setFont(new Font("Tahoma", Font.BOLD, 10));
		bt_reclamar.setBounds(145, 40, 97, 30);
		bt_reclamar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReclamarFr reclamar = new ReclamarFr();
				reclamar.setVisible(true);
			}
		});
		contentPane.add(bt_reclamar);
		
		JButton bt_importação = new JButton("Importa\u00E7\u00E3o");
		bt_importação.setFont(new Font("Tahoma", Font.BOLD, 10));
		bt_importação.setBounds(266, 40, 97, 30);
		bt_importação.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ImportaçãoFr importação = new ImportaçãoFr();
				importação.setVisible(true);
			}
		});
		contentPane.add(bt_importação);
		contentPane.add(bt_doações);
		
		JButton bt_listagem = new JButton("Listagem");
		bt_listagem.setFont(new Font("Tahoma", Font.BOLD, 10));
		bt_listagem.setBounds(508, 40, 97, 30);
		bt_listagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListagemFr listagem =new ListagemFr();
				listagem.setVisible(true);
			}
		});
		contentPane.add(bt_listagem);
		
		JButton bt_configuração = new JButton("Configurar");
		bt_configuração.setFont(new Font("Tahoma", Font.BOLD, 10));
		bt_configuração.setBounds(508, 178, 97, 30);
		bt_configuração.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfiguracaoFr c = new ConfiguracaoFr();
				c.setVisible(true);
			}
		});
		contentPane.add(bt_configuração);
		
		JButton bt_mudaruser = new JButton("Mudar User");
		bt_mudaruser.setFont(new Font("Tahoma", Font.BOLD, 10));
		bt_mudaruser.setBounds(387, 178, 97, 30);
		bt_mudaruser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
		
	
		
		JLabel lblSessoIniciadaComo = new JLabel("Sess\u00E3o Iniciada:");
		lblSessoIniciadaComo.setBounds(203, 182, 72, 21);
		lblSessoIniciadaComo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(lblSessoIniciadaComo);
		contentPane.add(bt_mudaruser);
		
		JLabel lblUser = new JLabel(Sipa.nomeUtilizador);
		lblUser.setBounds(285, 182, 71, 21);
		contentPane.add(lblUser);
		
		JLabel lblSoftwareDesenvolvidoPor = new JLabel("Software desenvolvido por:");
		lblSoftwareDesenvolvidoPor.setForeground(Color.BLUE);
		lblSoftwareDesenvolvidoPor.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblSoftwareDesenvolvidoPor.setBounds(494, 95, 143, 37);
		contentPane.add(lblSoftwareDesenvolvidoPor);
		
		JLabel lblRenatoEJoo = new JLabel("Renato e Jo\u00E3o Costa");
		lblRenatoEJoo.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblRenatoEJoo.setBounds(508, 129, 114, 24);
		contentPane.add(lblRenatoEJoo);
		
		
		for(TipoUtilizador tu : Sipa.tiposUtilizadores){
			if(tu.getTipoUtilizador().equals(Sipa.permissao)){
				bt_registar.setVisible(tu.isRegisto());
				bt_listagem.setVisible(tu.isListagens());
				bt_configuração.setVisible(tu.isConfiguração());
				bt_reclamar.setVisible(tu.isReclamaçao());
				bt_doações.setVisible(tu.isDoaçao());
				bt_importação.setVisible(tu.isImportaçao());
				
		}
			}
		
		
	}
}
