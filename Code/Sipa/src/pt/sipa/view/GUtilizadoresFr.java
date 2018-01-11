package pt.sipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import pt.sipa.controller.ManagerGSala;
import pt.sipa.controller.ManagerGUtilizador;
import pt.sipa.controller.Sipa;
import pt.sipa.model.Instituição;
import pt.sipa.model.Sala;
import pt.sipa.model.TipoObjeto;
import pt.sipa.model.TipoUtilizador;
import pt.sipa.model.Utilizador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class GUtilizadoresFr extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;

	
	/**
	 * Create the frame.
	 */
	public GUtilizadoresFr() {
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultComboBoxModel<TipoUtilizador> cbtipoU = new DefaultComboBoxModel<TipoUtilizador>();
		for(TipoUtilizador tu:Sipa.tiposUtilizadores)
		{
			cbtipoU.addElement(tu);
		}
		
		
		
		JComboBox cbPermissões = new JComboBox<TipoUtilizador>(cbtipoU);
		cbPermissões.setBounds(130, 140, 89, 20);
		contentPane.add(cbPermissões);
		
		JLabel lblUsername = new JLabel("Nome Utilizador:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblUsername.setBounds(31, 82, 89, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPassword.setBounds(245, 82, 52, 14);
		contentPane.add(lblPassword);
		
		JLabel lblPassword2 = new JLabel("Confirmar Password:");
		lblPassword2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPassword2.setBounds(191, 107, 106, 14);
		contentPane.add(lblPassword2);
		
		JLabel lblGestoDeUtilizadores = new JLabel("Gest\u00E3o de Utilizadores");
		lblGestoDeUtilizadores.setForeground(Color.BLUE);
		lblGestoDeUtilizadores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGestoDeUtilizadores.setBounds(21, 31, 164, 40);
		contentPane.add(lblGestoDeUtilizadores);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(133, 79, 86, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(307, 79, 86, 20);
		contentPane.add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(307, 105, 86, 20);
		contentPane.add(passwordField2);
		
		

		
		
	
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ConfiguracaoFr c = new ConfiguracaoFr();
				c.setVisible(true);
				try {
					Sipa.save();
				} catch (FileNotFoundException e1) {
				
					e1.printStackTrace();
				}
			}
		});
		btnVoltar.setBounds(304, 300, 89, 23);
		contentPane.add(btnVoltar);
		
		
		DefaultComboBoxModel<Utilizador> dcm = new DefaultComboBoxModel<Utilizador>();
		for(Utilizador to:Sipa.utilizadores)
		{
			dcm.addElement(to);
		}
		
		
		JComboBox cbNomeUser = new JComboBox<Utilizador>(dcm);
		cbNomeUser.setBounds(133, 239, 86, 20);
		contentPane.add(cbNomeUser);
		
	
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ManagerGUtilizador.removerUtilizador(cbNomeUser.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Utilizador Removido");
				
				refreshcbTipoU();
			}
			private void refreshcbTipoU() {
				dcm.removeAllElements();
				for(Utilizador to:Sipa.utilizadores)
				{
					dcm.addElement(to);
				}
			}
		});
		btnRemover.setBounds(304, 238, 89, 23);
		contentPane.add(btnRemover);
		
		JLabel lblPermisso = new JLabel("Permiss\u00E3o:");
		lblPermisso.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPermisso.setBounds(31, 143, 89, 14);
		contentPane.add(lblPermisso);
		
		JLabel lblUtilizadorARemover = new JLabel("Utilizador a remover:");
		lblUtilizadorARemover.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblUtilizadorARemover.setBounds(21, 239, 106, 14);
		contentPane.add(lblUtilizadorARemover);
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = textFieldUsername.getText();
				String password1 = passwordField1.getText();
				String password2 = passwordField2.getText();
				TipoUtilizador permissao = (TipoUtilizador) cbPermissões.getSelectedItem();
				
			if(ManagerGUtilizador.adicionarUtilizador(username, password1, password2, permissao)==true){
				JOptionPane.showMessageDialog(null, "Utilizador adicionado");
				refreshcbTipoU();
			}
				
				
				
			}
			
			private void refreshcbTipoU() {
				dcm.removeAllElements();
				for(Utilizador to:Sipa.utilizadores)
				{
					dcm.addElement(to);
				}
			}
		});
		btnAdicionar.setBounds(304, 175, 89, 23);
		contentPane.add(btnAdicionar);
		
		
		
		
		
	}
}
