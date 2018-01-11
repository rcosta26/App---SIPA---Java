package pt.sipa.controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import pt.sipa.model.Institui��o;


public class ManagerGInstitui��es {

	// Remover institui��o
	
		public static boolean removerInstitui��o(String institui��o){
			
			boolean res = false;
			
			for (int i=0; i<Sipa.institui��es.size();i++) {
				
				if (Sipa.institui��es.get(i).getNome().equals(institui��o)) {
					Sipa.institui��es.remove(i);
					res=true;
				}
			}
			return res;

		}

		public static boolean adicionarInstitui��o(String insti) {
		boolean res=true;
			for (Institui��o i : Sipa.institui��es){
				
				if(i.getNome().equals(insti)){
					res=false;
					JOptionPane.showMessageDialog(null, "Institui��o Existente");
					}
				}
				if(res==true){
					Institui��o ins = new Institui��o(insti);
					Sipa.institui��es.add(ins);
					File yourFile = new File(insti+".txt");
					if(!yourFile.exists()) {
					    try {
							yourFile.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
			
				}
			return res;
			
			
		}

	}