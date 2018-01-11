package pt.sipa.view;

import java.awt.Color;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pt.sipa.controller.ManagerRegisto;
import pt.sipa.controller.Sipa;
import pt.sipa.model.Sala;
import pt.sipa.model.TipoObjeto;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class RegistoFr extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JLabel lblEmail;
	private JLabel lblSala;
	private JTextField textEmail;
	
	
	
	/**
	 * Create the frame.
	 */
	public RegistoFr() {
		setTitle("SIPA - Sistema Interno de Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistoDeItem = new JLabel("Registo de Item");
		lblRegistoDeItem.setForeground(Color.BLUE);
		lblRegistoDeItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistoDeItem.setBounds(35, 31, 126, 26);
		contentPane.add(lblRegistoDeItem);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setForeground(new Color(0, 51, 255));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(35, 88, 55, 26);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(100, 90, 104, 26);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setForeground(new Color(0, 51, 255));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(35, 125, 55, 26);
		contentPane.add(lblEmail);
		
		lblSala = new JLabel("Sala :");
		lblSala.setForeground(new Color(0, 51, 255));
		lblSala.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSala.setBounds(35, 162, 55, 26);
		contentPane.add(lblSala);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(100, 125, 104, 26);
		contentPane.add(textEmail);
		
		
		
		
		DefaultComboBoxModel<Sala> dcm = new DefaultComboBoxModel<Sala>();
		for (Sala s: Sipa.salas) {
			dcm.addElement(s);
		}
		
		
		JComboBox<Sala> cbSala = new JComboBox<Sala>(dcm);
		cbSala.setBounds(137, 162, 67, 25);
		contentPane.add(cbSala);
		
		JLabel lblObjeto = new JLabel("Objeto :");
		lblObjeto.setForeground(new Color(0, 51, 255));
		lblObjeto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObjeto.setBounds(35, 199, 55, 26);
		contentPane.add(lblObjeto);
		
		DefaultComboBoxModel<TipoObjeto> dcm2 = new DefaultComboBoxModel<TipoObjeto>();
		for (TipoObjeto to: Sipa.tiposObjetos) {
			dcm2.addElement(to);
		}
		
		JComboBox<TipoObjeto> cbObjeto = new JComboBox<TipoObjeto>(dcm2);
		cbObjeto.setBounds(100, 198, 104, 25);
		contentPane.add(cbObjeto);
		
		JLabel lblCor = new JLabel("Cor :");
		lblCor.setForeground(new Color(0, 51, 255));
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCor.setBounds(35, 236, 55, 26);
		contentPane.add(lblCor);
		
		
		
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
		
		JComboBox<String> cbCor = new JComboBox<String>(listModelCor);
		cbCor.setBounds(100, 234, 104, 25);
		contentPane.add(cbCor);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setForeground(new Color(0, 51, 255));
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(35, 273, 55, 26);
		contentPane.add(lblEstado);
		
		
		
		DefaultComboBoxModel<String> listModelEstado=new 	DefaultComboBoxModel<String>();
		listModelEstado.addElement("Mau");
		listModelEstado.addElement("Razoável");
		listModelEstado.addElement("Bom");
		
		
		
		JComboBox<String> cbEstado = new JComboBox<String>(listModelEstado);
		cbEstado.setBounds(100, 270, 104, 25);
		contentPane.add(cbEstado);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o  :");
		lblDescrio.setForeground(new Color(0, 51, 255));
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescrio.setBounds(35, 324, 77, 26);
		contentPane.add(lblDescrio);
		
		JTextArea taDescricao = new JTextArea();
		taDescricao.setBounds(35, 361, 295, 59);
		contentPane.add(taDescricao);
		
		JButton btnAdicionarItem = new JButton("Adicionar Item");
		btnAdicionarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigoEntrada=0;
				String data= Menu.datas;
				
				
				
				if(ManagerRegisto.registar(codigoEntrada, 
						textNome.getText(), 
						textEmail.getText(), 
						data, 
						cbCor.getSelectedItem().toString(), 
						cbEstado.getSelectedItem().toString(), 
						taDescricao.getText().toString(), 
						(TipoObjeto) cbObjeto.getSelectedItem(),
						(Sala) cbSala.getSelectedItem())==true){
					JOptionPane.showMessageDialog(null, "Registo efetuado");	
				};
				
			}
			
			
		});
		btnAdicionarItem.setBounds(32, 444, 166, 37);
		contentPane.add(btnAdicionarItem);
		
		JButton btnVoltar = new JButton("Voltar ");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Sipa.save();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
				Menu r = new Menu();
				r.setVisible(true);
			}
		});
		btnVoltar.setBounds(212, 445, 118, 36);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RegistoFr.class.getResource("/pt/sipa/res/sipa.png")));
		lblNewLabel.setBounds(241, 43, 187, 263);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
