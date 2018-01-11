package pt.sipa.model;



public class Instituição {

	private String nome;
	
	
	
	
	public Instituição(String nome) {
		super();
		this.nome = nome;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return nome;
	}
	
		
	
}
