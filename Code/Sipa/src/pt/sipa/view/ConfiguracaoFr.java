package pt.sipa.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ConfiguracaoFr extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public ConfiguracaoFr() {
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGesto = new JLabel("Configura\u00E7\u00F5es");
		lblGesto.setForeground(Color.BLUE);
		lblGesto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGesto.setBounds(96, 22, 118, 53);
		contentPane.add(lblGesto);
		
		JButton btSalas = new JButton("Salas");
		btSalas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GSalasFr g = new GSalasFr();
				g.setVisible(true);
				dispose();
			}
		});
		btSalas.setBounds(72, 235, 142, 23);
		contentPane.add(btSalas);
		
		JButton btInstitucoes = new JButton("Institui\u00E7\u00F5es");
		btInstitucoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GInstituiçõesFr g = new GInstituiçõesFr();
				g.setVisible(true);
				dispose();
				
			}
		});
		btInstitucoes.setBounds(72, 185, 142, 23);
		contentPane.add(btInstitucoes);
		
		JButton btTipoObjeto = new JButton("Tipo de Objeto");
		btTipoObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GTipoObjetoFr g = new GTipoObjetoFr();
				g.setVisible(true);
				dispose();
			}
		});
		btTipoObjeto.setBounds(72, 85, 142, 23);
		contentPane.add(btTipoObjeto);
		
		JButton btUtilizadores = new JButton("Utilizadores");
		btUtilizadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUtilizadoresFr g = new GUtilizadoresFr();
				g.setVisible(true);
				dispose();
				
			}
		});
		btUtilizadores.setBounds(72, 135, 142, 23);
		contentPane.add(btUtilizadores);
		
		JButton btnVoltarconfg = new JButton("Voltar ");
		btnVoltarconfg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltarconfg.setBounds(84, 290, 118, 39);
		contentPane.add(btnVoltarconfg);
	}

}
