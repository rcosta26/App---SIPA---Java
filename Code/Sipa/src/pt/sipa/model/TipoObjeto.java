package pt.sipa.model;



public class TipoObjeto {

	private String nome;	
	private Institui��o codigoIS;
	
	
	
	
	
	public TipoObjeto(String nome, Institui��o codigoIS) {
		super();
	
		this.nome = nome;
		this.codigoIS = codigoIS;
	}

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Institui��o getCodigoIS() {
		return codigoIS;
	}
	public void setCodigoIS(Institui��o codigoIS) {
		this.codigoIS = codigoIS;
	}

	@Override
	public String toString() {
		return nome ;
	}
	
	
}
