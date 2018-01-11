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

import pt.sipa.controller.ManagerGInstitui��es;
import pt.sipa.controller.ManagerGSala;
import pt.sipa.controller.Sipa;
import pt.sipa.model.Institui��o;
import pt.sipa.model.Sala;

public class GInstitui��esFr extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldGInstitui;



	/**
	 * Create the frame.
	 */
	public GInstitui��esFr() {
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
	
		
		JLabel lblGestaoDeInstitui��es = new JLabel("Gest\u00E3o de Institui\u00E7\u00F5es");
		lblGestaoDeInstitui��es.setForeground(Color.BLUE);
		lblGestaoDeInstitui��es.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGestaoDeInstitui��es.setBounds(31, 11, 160, 40);
		contentPane.add(lblGestaoDeInstitui��es);
		
		
		
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
		
		
		DefaultComboBoxModel<Institui��o> dcm = new DefaultComboBoxModel<Institui��o>();
		for (Institui��o i: Sipa.institui��es) {
			dcm.addElement(i);
		}
		
		
				
		JComboBox cbInstitui��es = new JComboBox<Institui��o>(dcm);
		cbInstitui��es.setBounds(151, 128, 89, 20);
		contentPane.add(cbInstitui��es);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManagerGInstitui��es.removerInstitui��o(cbInstitui��es.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Institui��o Removida");
				refreshcbInstitui��o();
				
			}
			private void refreshcbInstitui��o() {
				dcm.removeAllElements();
				for (Institui��o i: Sipa.institui��es) {
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
				if(ManagerGInstitui��es.adicionarInstitui��o(insti)==true){
					JOptionPane.showMessageDialog(null, "Institui��o Adicionada");
					refreshcbInstitui��o();
				};
				
				
			}
			private void refreshcbInstitui��o() {
				dcm.removeAllElements();
				for (Institui��o i: Sipa.institui��es) {
					dcm.addElement(i);
				}
			}
		});
		btnAdicionarInst.setBounds(271, 81, 89, 23);
		contentPane.add(btnAdicionarInst);
	}
	
}