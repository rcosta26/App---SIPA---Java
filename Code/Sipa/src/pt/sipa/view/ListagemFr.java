package pt.sipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import pt.sipa.controller.Sipa;
import pt.sipa.model.Registo;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ListagemFr extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel dtm = new DefaultTableModel();
	String info;
	int cont;
	private JLabel lblListagemDeItems;
	private JLabel lblTipoDeObjeto;
	private JLabel lblCor;
	private JLabel lblEstado;

	/**
	 * Create the frame.
	 */
	public ListagemFr() {
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 376);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(283, 284, 89, 23);
		contentPane.add(btnVoltar);
		
		dtm.setRowCount(0);
		
		
		dtm.addColumn("Tipo Objeto");
		dtm.addColumn("Cor");
		dtm.addColumn("Estado");
		if(Sipa.permissao.equals("instituicao")){
			for (Registo r :Sipa.registos){
				if(Sipa.nomeUtilizador.equals(r.getObjeto().getCodigoIS().toString()))
				dtm.addRow(new Object[]{r.getObjeto(),r.getCor(),r.getEstado()});
		}
		}
			else{
		for (Registo r :Sipa.registos){
			
			dtm.addRow(new Object[]{r.getObjeto(),r.getCor(),r.getEstado()});
			
		}
			}
		
		table = new JTable(dtm);
		table.setBounds(32, 100, 340, 136);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				int row = table.rowAtPoint(p);
				int index = table.getSelectedRow();
				Registo objeto = Sipa.registos.get(index);
				info = "Nome: " +objeto.getNome()+"\n"+"Email: "+objeto.getEmail()+"\n"+ "Descrição: "+objeto.getDescrição()+"\n"+ "Data: "+ objeto.getData();		
				JOptionPane.showMessageDialog(null, (info));
				
			}
		});
		
		contentPane.add(table);
		
		lblListagemDeItems = new JLabel("Listagem de Items ");
		lblListagemDeItems.setForeground(Color.BLUE);
		lblListagemDeItems.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListagemDeItems.setBounds(32, 35, 340, 23);
		contentPane.add(lblListagemDeItems);
		
		JLabel lblSeEstiverA = new JLabel("Se estiver com sess\u00E3o iniciada como Institui\u00E7\u00E3o poder\u00E1 apenas");
		lblSeEstiverA.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblSeEstiverA.setBounds(32, 247, 330, 14);
		contentPane.add(lblSeEstiverA);
		
		JLabel lblVerOsItems = new JLabel(" ver os items que relacionados com a entidade");
		lblVerOsItems.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblVerOsItems.setBounds(32, 259, 307, 14);
		contentPane.add(lblVerOsItems);
		
		lblTipoDeObjeto = new JLabel("Tipo de Objeto");
		lblTipoDeObjeto.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTipoDeObjeto.setBounds(42, 75, 89, 14);
		contentPane.add(lblTipoDeObjeto);
		
		lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCor.setBounds(164, 75, 46, 14);
		contentPane.add(lblCor);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEstado.setBounds(276, 75, 46, 14);
		contentPane.add(lblEstado);
		
		
		
	
	}
}

