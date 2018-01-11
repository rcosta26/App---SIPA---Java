package pt.sipa.controller;

import pt.sipa.model.Registo;
import pt.sipa.model.Sala;
import pt.sipa.model.TipoObjeto;

public class ManagerRegisto {

	
	public static boolean registar(int codigoEntrada, String nome, String email, String data, String cor, String estado, String descrição, TipoObjeto to, Sala sala){
		
		boolean res = false;	
		
		Registo r = new Registo(codigoEntrada,nome,email,data,cor,estado,descrição,to,sala);
		Sipa.registos.add(r);
		res= true;
		return res;
		
		
	}
	
	
}
