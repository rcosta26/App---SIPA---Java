package pt.sipa.controller;

import javax.swing.JOptionPane;

import pt.sipa.model.Instituição;

import pt.sipa.model.TipoObjeto;

public class ManagerGTipoObjeto {
	
	
	// Remover TipoObjeto 
	
	public static boolean removerTipoObjeto(String obj){
		
		boolean res = false;
		
		for (int i=0; i<Sipa.tiposObjetos.size();i++) {
			
			if (Sipa.tiposObjetos.get(i).getNome().equals(obj)) {
				Sipa.tiposObjetos.remove(i);
				res=true;
			}
		}
		return res;

	}
	// adicionar TipoObjeto

	public static boolean adicionarTipoObjeto(String tipoObj, Instituição insti) {
	boolean res=true;
		for (TipoObjeto to : Sipa.tiposObjetos){
			
			if(to.getNome().equals(tipoObj)){
				res=false;
				JOptionPane.showMessageDialog(null, "Objeto Existente");
				}
			}
			if(res==true){
				TipoObjeto to = new TipoObjeto(tipoObj,insti);
				Sipa.tiposObjetos.add(to);
			
			}
		return res;
		
		
	}

}

