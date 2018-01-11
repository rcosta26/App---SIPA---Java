package pt.sipa.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import pt.sipa.model.Registo;
import pt.sipa.model.Sala;
import pt.sipa.model.TipoObjeto;

public class ManagerImportação {

	public static boolean importar(File path) throws FileNotFoundException{
		boolean res=false;
		
		
		Scanner inImportaçãoFile = new Scanner(path);
		while (inImportaçãoFile.hasNextLine()) {
			String line = inImportaçãoFile.nextLine();
			String[] fields = line.split("#");
			
			
			
			//Obter o objeto Sala respetivo
			Sala sa = null;
			for (Sala s : Sipa.salas) {
				if (s.getNomeSala().equals(fields[3])) {
					sa = s;
				}			
			}

			//Obter o objeto tipoObjeto respetivo
			TipoObjeto t = null;
			for (TipoObjeto tu : Sipa.tiposObjetos) {
				if (tu.getNome().equals(fields[4])) {
					t = tu;
				}			
			}
			int codigo = 0;
			Registo r = new Registo(codigo,fields[1],fields[2],fields[0],fields[5],fields[6],fields[7],t,sa);
			
			
			Sipa.importações.add(r);
			codigo++;
			res=true;
		}
		inImportaçãoFile.close();
		
		
		
		return res;
		
		
	}
	
}
