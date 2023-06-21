package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class TremCargaLP {
    private int idTremCarga;
    private String tipoCarga;
    private List<TremVagaoLP> vagoes;

    public TremCargaLP() {
        this.vagoes = new ArrayList<>();
    }

    public TremCargaLP(int idTremCarga, String tipoCarga, List<TremVagaoLP> vagoes) {
        this.idTremCarga = idTremCarga;
        this.tipoCarga = tipoCarga;
        this.vagoes = vagoes;
    }

    

    public int getIdTremCarga() {
		return idTremCarga;
	}

	public void setIdTremCarga(int idTremCarga) {
		this.idTremCarga = idTremCarga;
	}

	public String getTipoCarga() {
		return tipoCarga;
	}

	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}

	public List<TremVagaoLP> getVagoes() {
		return vagoes;
	}

	public void setVagoes(List<TremVagaoLP> vagoes) {
		this.vagoes = vagoes;
	}

	public void adicionarVagao(TremVagaoLP vagao) {
        vagoes.add(vagao);
    }
}