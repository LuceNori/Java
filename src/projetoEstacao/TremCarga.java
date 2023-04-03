package projetoEstacao;

public class TremCarga extends Trem{
	public TremCarga(int capacidadeTotal, double peso, int vagoes, String tipoCarga) {
		super(capacidadeTotal, peso, vagoes);
		this.tipoCarga = tipoCarga;
	}
	private String tipoCarga;

	public String getTipoCarga() {
		return tipoCarga;
	}
	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	@Override
	public String toString() {
		return super.toString()+"|Tipo da carga:"+this.getTipoCarga();
	}
}
