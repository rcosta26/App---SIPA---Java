package pt.sipa.controller;

import javax.swing.JOptionPane;

import pt.sipa.model.TipoUtilizador;
import pt.sipa.model.Utilizador;



public class ManagerGUtilizador {
	
	
	
	// remover Utilizador existente
	public static boolean removerUtilizador(String utilizador){
		
		boolean res = false;
		
		for (int i=0; i<Sipa.utilizadores.size();i++) {
			
			if (Sipa.utilizadores.get(i).getUser().equals(utilizador)) {
				Sipa.utilizadores.remove(i);
				res=true;
			}
		}
		return res;
	

	}
	
	// adicionar Utilizador 
	
	public static boolean adicionarUtilizador(String utilizador,String password1, String password2,TipoUtilizador permissao){
		
		boolean res=true;
	
		
		
		if (res==true){
		for (Utilizador u : Sipa.utilizadores){
			
			if(u.getUser().equals(utilizador)){
				res=false;
				JOptionPane.showMessageDialog(null, "Utilizador Existente");
				}
			}
		}
		
			if (!password1.equals(password2)){
				res=false;
				JOptionPane.showMessageDialog(null, "Password não correspondem");
				}
			
			

			if(res==true){
				
					Utilizador uti = new Utilizador(utilizador,password1,permissao);
					Sipa.utilizadores.add(uti);	
					
				
			}
		return res;
		
		
		
		
	}
	
	
	
	
}	
