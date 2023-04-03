package projetoEstacao;

public abstract class Trem {
	private int capacidadeTotal;
	private double peso;
	private int vagoes;

	public Trem(int capacidadeTotal, double peso, int vagoes) {
		this.capacidadeTotal = capacidadeTotal;
		this.peso = peso;
		this.vagoes = vagoes;
	}

	public int getCapacidadeTotal() {
		return capacidadeTotal;
	}

	public void setCapacidadeTotal(int capacidadeTotal) {
		this.capacidadeTotal = capacidadeTotal;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getVagoes() {
		return vagoes;
	}

	public void setVagoes(int vagoes) {
		this.vagoes = vagoes;
	}
	@Override
	public String toString() {
		return "Capacidade Total:"+this.getCapacidadeTotal()+
				"|Peso do trem:"+this.getPeso()+
				"|Quantidade de vagões:"+this.getVagoes();
		
	}
}
