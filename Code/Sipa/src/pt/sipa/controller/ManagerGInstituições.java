package pt.sipa.controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import pt.sipa.model.Instituição;


public class ManagerGInstituições {

	// Remover instituição
	
		public static boolean removerInstituição(String instituição){
			
			boolean res = false;
			
			for (int i=0; i<Sipa.instituições.size();i++) {
				
				if (Sipa.instituições.get(i).getNome().equals(instituição)) {
					Sipa.instituições.remove(i);
					res=true;
				}
			}
			return res;

		}

		public static boolean adicionarInstituição(String insti) {
		boolean res=true;
			for (Instituição i : Sipa.instituições){
				
				if(i.getNome().equals(insti)){
					res=false;
					JOptionPane.showMessageDialog(null, "Instituição Existente");
					}
				}
				if(res==true){
					Instituição ins = new Instituição(insti);
					Sipa.instituições.add(ins);
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