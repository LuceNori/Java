package heranca;

public class Professor extends Pessoa{
	private int siape;
	private String areaCurso;
	public Professor(String nome, String dataNascimento, int siape, String areaCurso) {
		super(nome, dataNascimento);
		this.areaCurso = areaCurso;
		this.siape = siape;
	}
	public int getSiape() {
		return siape;
	}
	public void setSiape(int siape) {
		this.siape = siape;
	}
	public String getAreaCurso() {
		return areaCurso;
	}
	public void setAreaCurso(String areaCurso) {
		this.areaCurso = areaCurso;
	}
	@Override
	public String toString() {
		return 	super.toString()+
				this.getSiape()+'\n'+
				this.getAreaCurso();
	}
}
