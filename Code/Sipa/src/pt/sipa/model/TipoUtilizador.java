package pt.sipa.model;

public class TipoUtilizador {

	
	private String tipoUtilizador;
	
    public String getTipoUtilizador() {
		return tipoUtilizador;
	}
	public void setTipoUtilizador(String tipoUtilizador) {
		this.tipoUtilizador = tipoUtilizador;
	}
	private boolean Registo;
    private boolean Reclama�ao;
    private boolean Doa�ao;
    private boolean Importa�ao;
    private boolean Listagens;
    private boolean Configura��o;
	public TipoUtilizador(String tipoUtilizador, boolean registo,
			boolean reclama�ao, boolean doa�ao, boolean importa�ao,
			boolean listagens, boolean configura��o) {
		super();
		this.tipoUtilizador = tipoUtilizador;
		Registo = registo;
		Reclama�ao = reclama�ao;
		Doa�ao = doa�ao;
		Importa�ao = importa�ao;
		Listagens = listagens;
		Configura��o = configura��o;
	}
	
	public boolean isRegisto() {
		return Registo;
	}
	public void setRegisto(boolean registo) {
		Registo = registo;
	}
	public boolean isReclama�ao() {
		return Reclama�ao;
	}
	public void setReclama�ao(boolean reclama�ao) {
		Reclama�ao = reclama�ao;
	}
	public boolean isDoa�ao() {
		return Doa�ao;
	}
	public void setDoa�ao(boolean doa�ao) {
		Doa�ao = doa�ao;
	}
	public boolean isImporta�ao() {
		return Importa�ao;
	}
	public void setImporta�ao(boolean importa�ao) {
		Importa�ao = importa�ao;
	}
	public boolean isListagens() {
		return Listagens;
	}
	public void setListagens(boolean listagens) {
		Listagens = listagens;
	}
	public boolean isConfigura��o() {
		return Configura��o;
	}
	public void setConfigura��o(boolean configura��o) {
		Configura��o = configura��o;
	}
    
	@Override
	public String toString() {
		return tipoUtilizador;
	}
   
	
	
}
