package pt.sipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Point;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JTable;

import pt.sipa.controller.ManagerImportação;
import pt.sipa.controller.Sipa;
import pt.sipa.model.Registo;

import javax.swing.JLabel;

import java.awt.Font;

public class ImportaçãoFr extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFicheiro;
	private JTable table;
	File path;
	DefaultTableModel dtm = new DefaultTableModel();
	private JLabel lblFicheiroASer;
	String info="";
	private JLabel lblImportaoDeFicheiros;

	/**
	 * Create the frame.
	 */
	public ImportaçãoFr() {
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldFicheiro = new JTextField();
		textFieldFicheiro.setBounds(53, 117, 186, 20);
		contentPane.add(textFieldFicheiro);
		textFieldFicheiro.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
					JFileChooser c = new JFileChooser();
				      // mostrar a janela
					//Cria filtros para os ficheiros a ser apresentados
					FileNameExtensionFilter filtro = new FileNameExtensionFilter("Ficheiro de Texto", "txt", "text");
					c.setFileFilter(filtro);
					c.showDialog(null, "Confirmar");
					c.setVisible(true);
					path = c.getSelectedFile();
					textFieldFicheiro.setText(path.toString());
				      
				   
			
			}   
		});
		btnProcurar.setBounds(289, 116, 89, 23);
		contentPane.add(btnProcurar);
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Sipa.save();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnVoltar.setBounds(289, 299, 89, 23);
		contentPane.add(btnVoltar);
		
		
		dtm.setRowCount(0);
		
		
		dtm.addColumn("Tipo Objeto");
		dtm.addColumn("Cor");
		dtm.addColumn("Estado");
		
		
	
		
		
		table = new JTable(dtm);
		table.setBounds(54, 167, 324, 121);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				int row = table.rowAtPoint(p);
				
				int index = table.getSelectedRow();
				
				Registo objeto = Sipa.importações.get(index);
				info = "Nome: " +objeto.getNome()+"\n"+"Email: "+objeto.getEmail()+"\n"+ "Descrição: "+objeto.getDescrição()+"\n"+ "Data: "+ objeto.getData();		
				JOptionPane.showMessageDialog(null, (info));
			
			}
			
		});
		
		
		
		contentPane.add(table);
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
					if( ManagerImportação.importar(path)==true){
					    	JOptionPane.showMessageDialog(null, "Objetos inseridos na tabela");
					    }
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
				refreshtable();
			}

			private void refreshtable() {
				for (Registo r :Sipa.importações){
					
					dtm.addRow(new Object[]{r.getObjeto(),r.getCor(),r.getEstado()});

				
			}
			}
		});
		btnVer.setBounds(54, 299, 89, 23);
		contentPane.add(btnVer);
		
		lblFicheiroASer = new JLabel("Ficheiro a ser carregado:");
		lblFicheiroASer.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFicheiroASer.setBounds(53, 92, 159, 14);
		contentPane.add(lblFicheiroASer);
		
		JButton btnImportar = new JButton("Importar");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Registo r :Sipa.importações){
					
					Sipa.registos.add(r);
					
				}
				JOptionPane.showMessageDialog(null, "Registos Importados com Sucessos");
				}
		});
		btnImportar.setBounds(168, 299, 89, 23);
		contentPane.add(btnImportar);
		
		lblImportaoDeFicheiros = new JLabel("Importa\u00E7\u00E3o de Ficheiros");
		lblImportaoDeFicheiros.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblImportaoDeFicheiros.setForeground(Color.BLUE);
		lblImportaoDeFicheiros.setBounds(53, 35, 186, 23);
		contentPane.add(lblImportaoDeFicheiros);
		
	}
}
