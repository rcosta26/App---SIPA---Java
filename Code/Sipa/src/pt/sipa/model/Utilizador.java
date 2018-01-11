package pt.sipa.model;



public class Utilizador {

	private String user;
	private String password;
	private TipoUtilizador tipoutilizador;
	
	 
	 
	 
	 
	 public Utilizador(String user, String password,
			TipoUtilizador tipoutilizador) {
		super();
		this.user = user;
		this.password = password;
		this.tipoutilizador = tipoutilizador;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TipoUtilizador getTipoutilizador() {
		return tipoutilizador;
	}
	public void setTipoutilizador(TipoUtilizador tipoutilizador) {
		this.tipoutilizador = tipoutilizador;
	}
	@Override
	public String toString() {
		return user;
	}
	
	
}
