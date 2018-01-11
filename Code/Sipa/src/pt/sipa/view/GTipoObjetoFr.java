package pt.sipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pt.sipa.controller.ManagerGSala;
import pt.sipa.controller.ManagerGTipoObjeto;
import pt.sipa.controller.Sipa;
import pt.sipa.model.Instituição;
import pt.sipa.model.TipoObjeto;
import pt.sipa.model.Utilizador;

public class GTipoObjetoFr extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTipoO;
	
	public GTipoObjetoFr() {
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 330);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textFieldTipoO = new JTextField();
		textFieldTipoO.setBounds(138, 103, 89, 20);
		contentPane.add(textFieldTipoO);
		textFieldTipoO.setColumns(10);
		
		JLabel lblTipoObjeto = new JLabel("Tipo de Objeto");
		lblTipoObjeto.setForeground(Color.BLUE);
		lblTipoObjeto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoObjeto.setBounds(45, 32, 110, 40);
		contentPane.add(lblTipoObjeto);
		
		
		
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
		btnVoltar.setBounds(374, 187, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblInstituio = new JLabel("Institui\u00E7\u00E3o a doar");
		lblInstituio.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblInstituio.setForeground(Color.BLACK);
		lblInstituio.setBounds(254, 86, 89, 14);
		contentPane.add(lblInstituio);
		
		
		DefaultComboBoxModel<Instituição> dcm = new DefaultComboBoxModel<Instituição>();
		for(Instituição i:Sipa.instituições)
		{
			dcm.addElement(i);
		}
		
		JComboBox cbInst = new JComboBox<Instituição>(dcm);
		cbInst.setBounds(254, 103, 89, 20);
		contentPane.add(cbInst);
		

		DefaultComboBoxModel<TipoObjeto> mcd = new DefaultComboBoxModel<TipoObjeto>();
		for(TipoObjeto to:Sipa.tiposObjetos)
		{
			mcd.addElement(to);
		}
		
		JComboBox cbTipoOb = new JComboBox<TipoObjeto>(mcd);
		cbTipoOb.setBounds(138, 154, 89, 20);
		contentPane.add(cbTipoOb);
		
		
		JButton btnRemoverTipoObjeto = new JButton("Remover");
		btnRemoverTipoObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManagerGTipoObjeto.removerTipoObjeto(cbTipoOb.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Tipo de Objeto Removido");
				refreshcbTipoObjeto();
			}
			private void refreshcbTipoObjeto() {
				mcd.removeAllElements();
				for(TipoObjeto to:Sipa.tiposObjetos)
				{
					mcd.addElement(to);
				}
			}
		});
		btnRemoverTipoObjeto.setBounds(374, 153, 89, 23);
		contentPane.add(btnRemoverTipoObjeto);
		
		
		JButton btnAdicionarTipoObjeto = new JButton("Adicionar");
		btnAdicionarTipoObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tipoObj = textFieldTipoO.getText();
				Instituição insti =(Instituição) cbInst.getSelectedItem();
				if(ManagerGTipoObjeto.adicionarTipoObjeto(tipoObj,insti)==true){
				JOptionPane.showMessageDialog(null, "Objeto Adicionado");
				refreshcbTipoObjeto();}
			}
			
			private void refreshcbTipoObjeto() {
				mcd.removeAllElements();
				for(TipoObjeto to:Sipa.tiposObjetos)
				{
					mcd.addElement(to);
				}
			}
		});
		btnAdicionarTipoObjeto.setBounds(374, 102, 89, 23);
		contentPane.add(btnAdicionarTipoObjeto);
		
		JLabel lblNovoObjeto = new JLabel("Novo Objeto:");
		lblNovoObjeto.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNovoObjeto.setBounds(45, 106, 79, 14);
		contentPane.add(lblNovoObjeto);
		
		JLabel lblObjetoARemover = new JLabel("Objeto a remover");
		lblObjetoARemover.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblObjetoARemover.setBounds(45, 157, 96, 14);
		contentPane.add(lblObjetoARemover);
	}
}
