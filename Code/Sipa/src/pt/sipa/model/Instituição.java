package pt.sipa.model;



public class Institui��o {

	private String nome;
	
	
	
	
	public Institui��o(String nome) {
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
