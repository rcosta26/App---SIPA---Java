package pt.sipa.controller;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import pt.sipa.model.Sala;
import pt.sipa.model.Utilizador;

public class ManagerGSala {
	
	
	
	// Remover sala 
	
	public static boolean removerSala(String sala){
		
		boolean res = false;
		
		for (int i=0; i<Sipa.salas.size();i++) {
			
			if (Sipa.salas.get(i).getNomeSala().equals(sala)) {
				Sipa.salas.remove(i);
				res=true;
			}
		}
		return res;

	}

	public static boolean adicionarSala(String str) {
	boolean res=true;
		for (Sala s : Sipa.salas){
			
			if(s.getNomeSala().equals(str)){
				res=false;
				JOptionPane.showMessageDialog(null, "Sala Existente");
				}
			}
			if(res==true){
				Sala sal = new Sala(str);
				Sipa.salas.add(sal);
				
			}
		return res;
		
		
	}

}
