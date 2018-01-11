package pt.sipa.model;



public class TipoObjeto {

	private String nome;	
	private Instituição codigoIS;
	
	
	
	
	
	public TipoObjeto(String nome, Instituição codigoIS) {
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
	public Instituição getCodigoIS() {
		return codigoIS;
	}
	public void setCodigoIS(Instituição codigoIS) {
		this.codigoIS = codigoIS;
	}

	@Override
	public String toString() {
		return nome ;
	}
	
	
}
