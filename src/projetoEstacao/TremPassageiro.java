package projetoEstacao;

public class TremPassageiro extends Trem{
	private int assentos;
	private int passageiros;
	public TremPassageiro(int capacidadeTotal, double peso, int vagoes,int assentos, int passageiros) {
		super(capacidadeTotal, peso, vagoes);
		this.assentos = assentos;
		this.passageiros = passageiros;
	}
	public int getAssentos() {
		return assentos;
	}
	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}
	public int getPassageiros() {
		return passageiros;
	}
	public void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
	}
	@Override
	public String toString() {
		return super.toString()+"|Quantidade de assentos:"+this.getAssentos()+
				"|Quantidade de passageiros:"+this.getPassageiros();
	}
}
