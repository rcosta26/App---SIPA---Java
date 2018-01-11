package pt.sipa.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



















import pt.sipa.model.Instituição;
import pt.sipa.model.Registo;
import pt.sipa.model.Sala;
import pt.sipa.model.TipoObjeto;
import pt.sipa.model.TipoUtilizador;
import pt.sipa.model.Utilizador;


public class Sipa {

	//data
	public static Date data = new Date();
	
	// VG
	
	public static int contagemRegistos=1;
	public static String permissao ;
	public static String nomeUtilizador;
	public static ArrayList<Registo> importações = new ArrayList<Registo>();
	public static ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
	public static ArrayList<Registo> registos = new ArrayList<Registo>();
	public static ArrayList<Instituição> instituições = new ArrayList<Instituição>();
	public static ArrayList<TipoUtilizador> tiposUtilizadores = new ArrayList<TipoUtilizador>();
	public static ArrayList<Sala> salas = new ArrayList<Sala>();
	public static ArrayList<TipoObjeto> tiposObjetos = new ArrayList<TipoObjeto>();
	static File utilizadoresFile = new File("Utilizadores.txt");
	static File registoFile = new File("Registo.txt");
	static File salaFile= new File("Salas.txt");
	static File instituicoesFile= new File("Instituições.txt");
	static File tipoUtilizadorFile= new File("TiposUtilizadores.txt");
	static File tipoObjetoFile=new File("TiposObjetos.txt");
	static File importaçãoFile;
	
	
	//  (load)	
		public static void load() throws FileNotFoundException {
			
			Scanner inInstituicoesFile = new Scanner(instituicoesFile);
			while (inInstituicoesFile.hasNextLine()) {
				String line = inInstituicoesFile.nextLine();
				Instituição i = new Instituição(line);
				instituições.add(i);
			}
			inInstituicoesFile.close();
			
			Scanner inSalasFile = new Scanner(salaFile);
			while (inSalasFile.hasNextLine()) {
				String line = inSalasFile.nextLine();
				Sala s = new Sala(line);
				salas.add(s);
			}
			inSalasFile.close();
			
			Scanner inTiposUtilizadoresFile = new Scanner (tipoUtilizadorFile);
			while (inTiposUtilizadoresFile.hasNextLine()){
				String line= inTiposUtilizadoresFile.nextLine();
				String[] fields = line.split("#");
				TipoUtilizador tu = new TipoUtilizador(fields[0], Boolean.parseBoolean(fields[1]),Boolean.parseBoolean(fields[2]),Boolean.parseBoolean(fields[3]),Boolean.parseBoolean(fields[4]),Boolean.parseBoolean(fields[5]),Boolean.parseBoolean(fields[6]));
				tiposUtilizadores.add(tu);
				
			}
			inTiposUtilizadoresFile.close();
			
			Scanner inUtilizadoresFile = new Scanner(utilizadoresFile);
			while (inUtilizadoresFile.hasNextLine()) {
				String line = inUtilizadoresFile.nextLine();
				String[] fields = line.split("#");
				
				//Obter o objeto tipoUtilizador respetivo
				TipoUtilizador t = null;
				for (TipoUtilizador tu : tiposUtilizadores) {
					if (tu.getTipoUtilizador().equals(fields[2])) {
						t = tu;
			
					}			
				}
				Utilizador u = new Utilizador(fields[0], fields[1], t);
				utilizadores.add(u);
			}
			inUtilizadoresFile.close();
			
			
			Scanner inTiposObjetosfile = new Scanner(tipoObjetoFile);
			while (inTiposObjetosfile.hasNextLine()) {
				String line = inTiposObjetosfile.nextLine();
				String[] fields = line.split("#");
				
				//Obter o objeto codigoInstituicao respetivo
				Instituição i = null;
				for (Instituição io : instituições) {
					if (io.getNome().equals(fields[1])) {
						i = io;
					}			
				}
				TipoObjeto to = new TipoObjeto(fields[0],i);
				tiposObjetos.add(to);
			}
			
			
			Scanner inRegistosFile = new Scanner(registoFile);
			while (inRegistosFile.hasNextLine()) {
				String line = inRegistosFile.nextLine();
				String[] fields = line.split("#");
				
				
				//Obter o objeto Sala respetivo
				Sala sa = null;
				for (Sala s : salas) {
					if (s.getNomeSala().equals(fields[3])) {
						sa = s;
					}			
				}

				//Obter o objeto tipoObjeto respetivo
				TipoObjeto t = null;
				for (TipoObjeto tu : tiposObjetos) {
					if (tu.getNome().equals(fields[5])) {
						t = tu;
					}			
				}
				Registo r = new Registo(Integer.parseInt(fields[0]),fields[1],fields[2],fields[4],fields[6],fields[7],fields[8],t,sa);
				registos.add(r);
			}
			inRegistosFile.close();
			
			
		
		}
		//save
		
		public static void save()  throws FileNotFoundException {
			
			try {
				PrintWriter writerSala = new PrintWriter(salaFile);
				for(Sala s : Sipa.salas)
					writerSala.println(s);
				writerSala.close();
	
			
				PrintWriter writerInst = new PrintWriter(instituicoesFile);
				for(Instituição i : Sipa.instituições)
						writerInst.println(i);
					writerInst.close();
					
				PrintWriter writerTipoObjeto = new PrintWriter(tipoObjetoFile);
					for(TipoObjeto to : Sipa.tiposObjetos)
							
						writerTipoObjeto.println(to.getNome() + "#" + to.getCodigoIS());
					    writerTipoObjeto.close();
					    
				PrintWriter writerUtilizador = new PrintWriter(utilizadoresFile);
					    for(Utilizador u : Sipa.utilizadores)
								
					    writerUtilizador.println(u.getUser() + "#" + u.getPassword()+ "#"+u.getTipoutilizador());
					    writerUtilizador.close();
					    
			    PrintWriter writerRegisto = new PrintWriter(registoFile);
					    for(Registo r : Sipa.registos)
								
					    writerRegisto.println(r.getCodigoEntrada()+contagemRegistos++ +
					    		"#"+ r.getNome()+
					    		"#"+r.getEmail()+
					    		"#"+r.getSala()+
					    		"#"+r.getData()+
					    		"#"+r.getObjeto()+
					    		"#"+r.getCor()+
					    		"#"+r.getEstado()+
					    		"#"+r.getDescrição());
					    writerRegisto.close();		    
				
			
				} catch (Exception r) {
					r.printStackTrace();
		

		
		}	
		}
		}		

