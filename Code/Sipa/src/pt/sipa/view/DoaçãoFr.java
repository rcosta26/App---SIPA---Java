package pt.sipa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pt.sipa.controller.Sipa;
import pt.sipa.model.Registo;

import javax.swing.JLabel;

import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoaçãoFr extends JFrame {
	private JTable table;
	private JPanel contentPane;
	DefaultTableModel dtm = new DefaultTableModel();
	private JLabel lblDataDoRegisto;
	private JLabel lblTipoDeObjeto;
	private JLabel lblDescrio;
	private JLabel lblInstituio;
	private boolean resData=false;
	private boolean resEstado=false;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	long msDiff;
	private JButton btnDoar;
	private JButton btnVoltar;
	

	/**
	 * Create the frame.
	 */
	public DoaçãoFr() {
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		dtm.setRowCount(0);
		
		
		dtm.addColumn("Data");
		dtm.addColumn("Tipo Objeto");
		dtm.addColumn("Descrição");
		dtm.addColumn("Instituição");
		
		// iterar no array Registos e obter informaçoes para a tabela
		for (Registo r :Sipa.registos){
			if( r.getEstado().equals("Bom")|| r.getEstado().equals("Razoável")){
				resEstado=true;
			}
		/*	try {
				
				
			Date dtStartDate =formatter.parse(r.getData());
			Date dtEndDate= formatter.parse(Menu.datas);
			
			
			msDiff = dtEndDate.getTime() - dtStartDate.getTime();
				} catch (ParseException e1) {
			
			e1.printStackTrace();*/
			//problema  no msDiff (calculo da diferença usando datas nao está a funcionar)
			if(msDiff==0){
				resData=true;
			}
			
				
			
			if(resEstado==true && resData==true){
				
			
			dtm.addRow(new Object[]{r.getData(),r.getObjeto(),r.getDescrição(),r.getObjeto().getCodigoIS()});
			}
		}
	
		
		
		table = new JTable(dtm);
		table.setBounds(54, 132, 627, 164);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				int row = table.rowAtPoint(p);
				
				int index = table.getSelectedRow();
				
				
						
				
			
			}
			
		});
		
		
		
		contentPane.add(table);
		
		JLabel lblDoaes = new JLabel("Doa\u00E7\u00F5es ");
		lblDoaes.setForeground(Color.BLUE);
		lblDoaes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDoaes.setBounds(54, 42, 92, 17);
		contentPane.add(lblDoaes);
		
		lblDataDoRegisto = new JLabel("Data do Registo");
		lblDataDoRegisto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDoRegisto.setBounds(82, 107, 92, 14);
		contentPane.add(lblDataDoRegisto);
		
		lblTipoDeObjeto = new JLabel("Tipo de Objeto");
		lblTipoDeObjeto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoDeObjeto.setBounds(254, 107, 92, 14);
		contentPane.add(lblTipoDeObjeto);
		
		lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescrio.setBounds(421, 107, 62, 14);
		contentPane.add(lblDescrio);
		
		lblInstituio = new JLabel("Institui\u00E7\u00E3o");
		lblInstituio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInstituio.setBounds(567, 107, 77, 14);
		contentPane.add(lblInstituio);
		
		btnDoar = new JButton("Doar");
		btnDoar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnDoar.setBounds(57, 307, 89, 23);
		contentPane.add(btnDoar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(592, 307, 89, 23);
		contentPane.add(btnVoltar);
	}
		}

