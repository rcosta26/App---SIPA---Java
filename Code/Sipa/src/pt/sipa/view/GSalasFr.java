package pt.sipa.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.JComboBox;

import pt.sipa.controller.ManagerGSala;
import pt.sipa.controller.ManagerRegisto;
import pt.sipa.controller.Sipa;
import pt.sipa.model.Sala;
import pt.sipa.model.TipoObjeto;


public class GSalasFr extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAdicionarSala;

	/**
	 * Create the frame.
	 */
	public GSalasFr() {
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		textFieldAdicionarSala = new JTextField();
		textFieldAdicionarSala.setBounds(160, 93, 89, 20);
		contentPane.add(textFieldAdicionarSala);
		textFieldAdicionarSala.setColumns(10);
		
		JLabel lblGestaoDeSalas = new JLabel("Gest\u00E3o de Salas");
		lblGestaoDeSalas.setForeground(Color.BLUE);
		lblGestaoDeSalas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGestaoDeSalas.setBounds(40, 23, 110, 40);
		contentPane.add(lblGestaoDeSalas);
		
		
		
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
		btnVoltar.setBounds(278, 192, 89, 23);
		contentPane.add(btnVoltar);
		
		DefaultComboBoxModel<Sala> dcm = new DefaultComboBoxModel<Sala>();
		for (Sala s: Sipa.salas) {
			dcm.addElement(s);
		}
		
		
		JComboBox<Sala> cbSala = new JComboBox<Sala>(dcm);
		cbSala.setBounds(160, 137, 89, 20);
		contentPane.add(cbSala);
		
	
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(ManagerGSala.removerSala(cbSala.getSelectedItem().toString())==true){
					JOptionPane.showMessageDialog(null, "Sala Removida");
				};
			
				refreshcbSalas();
				
				
			}
			private void refreshcbSalas() {
				dcm.removeAllElements();
				for (Sala s: Sipa.salas) {
					dcm.addElement(s);
			
				}				
			}
		
		});
		btnRemover.setBounds(278, 136, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnAdicionarSala = new JButton("Adicionar");
		btnAdicionarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str = textFieldAdicionarSala.getText();
				if(ManagerGSala.adicionarSala(str)==true){
				JOptionPane.showMessageDialog(null, "Sala Adicionada");
				refreshcbSalas();
				};
			}
			private void refreshcbSalas() {
				dcm.removeAllElements();
				for (Sala s: Sipa.salas) {
					dcm.addElement(s);
			
				}				
			}
		});
		btnAdicionarSala.setBounds(278, 92, 89, 23);
		contentPane.add(btnAdicionarSala);
		
		JLabel lblSalaAAdicionar = new JLabel("Sala a adicionar:");
		lblSalaAAdicionar.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSalaAAdicionar.setBounds(40, 96, 89, 14);
		contentPane.add(lblSalaAAdicionar);
		
		JLabel lblSelecioneParaRemover = new JLabel("Sala a remover");
		lblSelecioneParaRemover.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSelecioneParaRemover.setBounds(40, 140, 89, 14);
		contentPane.add(lblSelecioneParaRemover);
		
		
		
	}
}
