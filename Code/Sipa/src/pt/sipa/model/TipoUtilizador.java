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
    private boolean Reclamaçao;
    private boolean Doaçao;
    private boolean Importaçao;
    private boolean Listagens;
    private boolean Configuração;
	public TipoUtilizador(String tipoUtilizador, boolean registo,
			boolean reclamaçao, boolean doaçao, boolean importaçao,
			boolean listagens, boolean configuração) {
		super();
		this.tipoUtilizador = tipoUtilizador;
		Registo = registo;
		Reclamaçao = reclamaçao;
		Doaçao = doaçao;
		Importaçao = importaçao;
		Listagens = listagens;
		Configuração = configuração;
	}
	
	public boolean isRegisto() {
		return Registo;
	}
	public void setRegisto(boolean registo) {
		Registo = registo;
	}
	public boolean isReclamaçao() {
		return Reclamaçao;
	}
	public void setReclamaçao(boolean reclamaçao) {
		Reclamaçao = reclamaçao;
	}
	public boolean isDoaçao() {
		return Doaçao;
	}
	public void setDoaçao(boolean doaçao) {
		Doaçao = doaçao;
	}
	public boolean isImportaçao() {
		return Importaçao;
	}
	public void setImportaçao(boolean importaçao) {
		Importaçao = importaçao;
	}
	public boolean isListagens() {
		return Listagens;
	}
	public void setListagens(boolean listagens) {
		Listagens = listagens;
	}
	public boolean isConfiguração() {
		return Configuração;
	}
	public void setConfiguração(boolean configuração) {
		Configuração = configuração;
	}
    
	@Override
	public String toString() {
		return tipoUtilizador;
	}
   
	
	
}
