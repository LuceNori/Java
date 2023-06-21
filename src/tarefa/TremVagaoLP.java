package tarefa;
public class TremVagaoLP {
    private int idVagao;
    private String tipoVagao;
    private double pesoVagao;

    public TremVagaoLP() {
    }

    public TremVagaoLP(int idVagao, String tipoVagao, double pesoVagao) {
        this.idVagao = idVagao;
        this.tipoVagao = tipoVagao;
        this.pesoVagao = pesoVagao;
    }

	public int getIdVagao() {
		return idVagao;
	}

	public void setIdVagao(int idVagao) {
		this.idVagao = idVagao;
	}

	public String getTipoVagao() {
		return tipoVagao;
	}

	public void setTipoVagao(String tipoVagao) {
		this.tipoVagao = tipoVagao;
	}

	public double getPesoVagao() {
		return pesoVagao;
	}

	public void setPesoVagao(double pesoVagao) {
		this.pesoVagao = pesoVagao;
	}

}
