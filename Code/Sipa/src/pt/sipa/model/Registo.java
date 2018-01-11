package pt.sipa.model;




public class Registo {


	private int codigoEntrada;
	private String nome;
	private String email;
	private String data;
	private String cor;
	private String estado;
	private String descrição; 
	private TipoObjeto objeto;
	private Sala sala;
	
	
	
	
	public Registo(int codigoEntrada, String nome, String email, String data,
			String cor, String estado, String descrição, TipoObjeto to,
			Sala sala) {
		
		super();
		this.codigoEntrada = codigoEntrada;
		this.nome = nome;
		this.email = email;
		this.data = data;
		this.cor = cor;
		this.estado = estado;
		this.descrição = descrição;
		this.objeto =  to;
		this.sala = sala;
	}




	public int getCodigoEntrada() {
		return codigoEntrada;
	}




	public void setCodigoEntrada(int codigoEntrada) {
		this.codigoEntrada = codigoEntrada;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getData() {
		return data;
	}




	public void setData(String data) {
		this.data = data;
	}




	public String getCor() {
		return cor;
	}




	public void setCor(String cor) {
		this.cor = cor;
	}




	public String getEstado() {
		return estado;
	}




	public void setEstado(String estado) {
		this.estado = estado;
	}




	public String getDescrição() {
		return descrição;
	}




	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}




	public TipoObjeto getObjeto() {
		return objeto;
	}




	public void setObjeto(TipoObjeto objeto) {
		this.objeto = objeto;
	}




	public Sala getSala() {
		return sala;
	}




	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	
}
