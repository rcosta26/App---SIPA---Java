package pt.sipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import pt.sipa.controller.ManagerGInstituições;
import pt.sipa.controller.ManagerGSala;
import pt.sipa.controller.Sipa;
import pt.sipa.model.Instituição;
import pt.sipa.model.Sala;

public class GInstituiçõesFr extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldGInstitui;



	/**
	 * Create the frame.
	 */
	public GInstituiçõesFr() {
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
	
		
		JLabel lblGestaoDeInstituições = new JLabel("Gest\u00E3o de Institui\u00E7\u00F5es");
		lblGestaoDeInstituições.setForeground(Color.BLUE);
		lblGestaoDeInstituições.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGestaoDeInstituições.setBounds(31, 11, 160, 40);
		contentPane.add(lblGestaoDeInstituições);
		
		
		
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
		btnVoltar.setBounds(271, 182, 89, 23);
		contentPane.add(btnVoltar);
		
		
		
	
		
		textFieldGInstitui = new JTextField();
		textFieldGInstitui.setBounds(151, 82, 89, 20);
		contentPane.add(textFieldGInstitui);
		textFieldGInstitui.setColumns(10);
		
		
		DefaultComboBoxModel<Instituição> dcm = new DefaultComboBoxModel<Instituição>();
		for (Instituição i: Sipa.instituições) {
			dcm.addElement(i);
		}
		
		
				
		JComboBox cbInstituições = new JComboBox<Instituição>(dcm);
		cbInstituições.setBounds(151, 128, 89, 20);
		contentPane.add(cbInstituições);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManagerGInstituições.removerInstituição(cbInstituições.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Instituição Removida");
				refreshcbInstituição();
				
			}
			private void refreshcbInstituição() {
				dcm.removeAllElements();
				for (Instituição i: Sipa.instituições) {
					dcm.addElement(i);
				}
			}
		});
		btnRemover.setBounds(271, 127, 89, 23);
		contentPane.add(btnRemover);
		
		JLabel lblNomeDaInstituio = new JLabel("Nome da Institui\u00E7\u00E3o:");
		lblNomeDaInstituio.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNomeDaInstituio.setBounds(31, 85, 108, 14);
		contentPane.add(lblNomeDaInstituio);
		
		JLabel lblEscolhaParaRemover = new JLabel("Escolha para remover");
		lblEscolhaParaRemover.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEscolhaParaRemover.setBounds(31, 131, 110, 14);
		contentPane.add(lblEscolhaParaRemover);
		
		JButton btnAdicionarInst = new JButton("Adicionar");
		btnAdicionarInst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String insti = textFieldGInstitui.getText();
				if(ManagerGInstituições.adicionarInstituição(insti)==true){
					JOptionPane.showMessageDialog(null, "Instituição Adicionada");
					refreshcbInstituição();
				};
				
				
			}
			private void refreshcbInstituição() {
				dcm.removeAllElements();
				for (Instituição i: Sipa.instituições) {
					dcm.addElement(i);
				}
			}
		});
		btnAdicionarInst.setBounds(271, 81, 89, 23);
		contentPane.add(btnAdicionarInst);
	}
	
}