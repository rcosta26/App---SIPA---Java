package pt.sipa.controller;

import pt.sipa.model.Utilizador;
import pt.sipa.view.Menu;

public class ManagerUtilizador {

	
	public static boolean isUtilizador(String nomeUtilizador, String password) {
		boolean res = false;
		for (Utilizador u : Sipa.utilizadores) {
			
			if (u.getUser().equals(nomeUtilizador) && u.getPassword().equals(password)) {
				res = true;
				Sipa.permissao=u.getTipoutilizador().toString();
				
			}
		}		
		return res;
	}
}

