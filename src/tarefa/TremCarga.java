package tarefaLp2BD;

public class TremCarga {
    private int idTrem;
    private int quantidadeVagoes;
    private String tipoCarga;

    public TremCarga(int idTrem, int quantidadeVagoes, String tipoCarga) {
        this.idTrem = idTrem;
        this.quantidadeVagoes = quantidadeVagoes;
        this.tipoCarga = tipoCarga;
    }

    public int getIdTrem() {
        return idTrem;
    }

    public int getQuantidadeVagoes() {
        return quantidadeVagoes;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

	public void setIdTrem(int idTrem) {
		this.idTrem = idTrem;
	}

	public void setQuantidadeVagoes(int quantidadeVagoes) {
		this.quantidadeVagoes = quantidadeVagoes;
	}

	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}


}
