package pt.sipa.view;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import pt.sipa.controller.Sipa;
import pt.sipa.model.Registo;
import pt.sipa.model.Sala;
import pt.sipa.model.TipoObjeto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

public class ReclamarFr extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel dtm = new DefaultTableModel();
	String info;
	int cont=0;
	int indexFiltroTipoO;
	int indexFiltroCor;
	boolean resTipoO=false;
	boolean resCor=false;

	/**
	 * Create the frame.
	 */
	public ReclamarFr() {
		
		
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultComboBoxModel<String> listModelCor=new 	DefaultComboBoxModel<String>();
		listModelCor.addElement("Amarelo");
		listModelCor.addElement("Azul");
		listModelCor.addElement("Branco");
		listModelCor.addElement("Castanho");
		listModelCor.addElement("Cinzento");
		listModelCor.addElement("Preto");
		listModelCor.addElement("Laranja");
		listModelCor.addElement("Rosa");
		listModelCor.addElement("Verde");
		listModelCor.addElement("Vermelho");
		listModelCor.addElement("Roxo");
		
		JComboBox cbCorRecla = new JComboBox<String>(listModelCor);
		cbCorRecla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {if (cbCorRecla.getSelectedIndex() != -1) {
	 			
	 			// Limpa o TableModel		 			
	 			dtm.setRowCount(0);
	 			
	 			// Itera sobre todos os registos e adiciona ao tableModel os filtrados
	 			for (int i = 0; i< Sipa.registos.size(); i++) {
	 				Registo r = Sipa.registos.get(i);
					if (r.getCor().toString().contains(cbCorRecla.getSelectedItem().toString())) {
						dtm.addRow(new Object[]{r.getObjeto(), r.getCor(), r.getEstado()});
						resCor=true;
						
					}
				}
				
			}
	 		
	 	}
	 });
		cbCorRecla.setBounds(304, 99, 104, 25);
		cbCorRecla.setSelectedIndex(-1);
		contentPane.add(cbCorRecla);
		
		JLabel lbObjetorecla = new JLabel("Objeto :");
		lbObjetorecla.setForeground(new Color(0, 51, 255));
		lbObjetorecla.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbObjetorecla.setBounds(84, 93, 78, 36);
		contentPane.add(lbObjetorecla);
		
		DefaultComboBoxModel<TipoObjeto> dcm = new DefaultComboBoxModel<TipoObjeto>();
		for (TipoObjeto to: Sipa.tiposObjetos) {
			dcm.addElement(to);
		}

		JButton btnLimparFiltros = new JButton("Limpar Filtros");
		btnLimparFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				for (Registo r :Sipa.registos){
					
					dtm.addRow(new Object[]{r.getObjeto(),r.getCor(),r.getEstado()});
					
				}
				
			}
		});
		btnLimparFiltros.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnLimparFiltros.setBounds(447, 100, 104, 23);
		contentPane.add(btnLimparFiltros);
		
		
		
		JComboBox cbObjetoRecla = new JComboBox<TipoObjeto>(dcm);
		cbObjetoRecla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (cbObjetoRecla.getSelectedIndex() != -1) {
		 			
		 			// Limpa o TableModel		 			
		 			dtm.setRowCount(0);
		 			
		 			// Itera sobre todos os registos e adiciona ao tableModel os filtrados
		 			for (int i = 0; i< Sipa.registos.size(); i++) {
		 				Registo r = Sipa.registos.get(i);
						if (r.getObjeto().toString().contains(cbObjetoRecla.getSelectedItem().toString())) {
							dtm.addRow(new Object[]{r.getObjeto(), r.getCor(), r.getEstado()});
							resTipoO=true;
							
						}
					}
					
				}
		 		
		 	}
		 });
			
		cbObjetoRecla.setBounds(133, 99, 104, 25);
		cbObjetoRecla.setSelectedIndex(-1);
		contentPane.add(cbObjetoRecla);
		
		
		
		
		dtm.setRowCount(0);
		
		// criar colunas da jtable
		
		dtm.addColumn("Tipo Objeto");
		dtm.addColumn("Cor");
		dtm.addColumn("Estado");
		
		// iterar no array Registos e obter informaçoes para a tabela
		for (Registo r :Sipa.registos){
			
			dtm.addRow(new Object[]{r.getObjeto(),r.getCor(),r.getEstado()});
			
		}
		
		
		
		
		table = new JTable(dtm);
		table.setBounds(60, 180, 491, 213);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				int row = table.rowAtPoint(p);
				
				int index = table.getSelectedRow();
				if(resTipoO==true){
					index=indexFiltroTipoO;
					
				}
				if(resCor==true){
					index=indexFiltroCor;
				}
				
				Registo objeto = Sipa.registos.get(index);
				info = "Nome: " +objeto.getNome()+"\n"+"Email: "+objeto.getEmail()+"\n"+ "Descrição: "+objeto.getDescrição()+"\n"+ "Data: "+ objeto.getData();		
				JOptionPane.showMessageDialog(null, (info));
				resTipoO=false;
				resCor=false;
			}
			
		});
		
		contentPane.add(table);
		
		JButton btRemoverItem = new JButton("Remover Item");
		btRemoverItem.addMouseListener(new MouseAdapter()  {
			public void  mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				Registo objeto = Sipa.registos.get(index);
				Sipa.registos.remove(index);
				JOptionPane.showMessageDialog(null, "Objeto Removido");
				
				
			}
		});
		btRemoverItem.setBounds(60, 446, 133, 39);
		contentPane.add(btRemoverItem);
		
		JButton btvoltar = new JButton("Voltar ");
		btvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					Sipa.save();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btvoltar.setBounds(462, 452, 89, 26);
		contentPane.add(btvoltar);
		
		JLabel lblReclamaoDeItem = new JLabel("Reclama\u00E7\u00E3o de Item");
		lblReclamaoDeItem.setForeground(Color.BLUE);
		lblReclamaoDeItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReclamaoDeItem.setBounds(60, 35, 177, 26);
		contentPane.add(lblReclamaoDeItem);
		
		JLabel lbCorRecla = new JLabel("Cor :");
		lbCorRecla.setForeground(new Color(0, 51, 255));
		lbCorRecla.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbCorRecla.setBounds(261, 93, 78, 36);
		contentPane.add(lbCorRecla);
		
		
		
		
		JLabel lblTipoObjeto = new JLabel("Tipo Objeto");
		lblTipoObjeto.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblTipoObjeto.setBounds(84, 155, 70, 14);
		contentPane.add(lblTipoObjeto);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCor.setBounds(261, 155, 52, 14);
		contentPane.add(lblCor);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEstado.setBounds(437, 155, 46, 14);
		contentPane.add(lblEstado);
		
		JLabel lblCliqueNoObejto = new JLabel("Clique no Objeto para mostrar a sua descri\u00E7\u00E3o");
		lblCliqueNoObejto.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliqueNoObejto.setBounds(213, 404, 247, 39);
		contentPane.add(lblCliqueNoObejto);
		
		

	}
}
