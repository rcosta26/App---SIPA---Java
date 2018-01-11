package pt.sipa.model;

public class Sala {

	
	private String nomeSala;

	

	public Sala(String nomeSala) {
		super();
		this.nomeSala = nomeSala;
	}



	public String getNomeSala() {
		return nomeSala;
	}



	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}



	@Override
	public String toString() {
		return nomeSala;
	}
	
}
