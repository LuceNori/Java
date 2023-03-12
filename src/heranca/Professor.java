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
	public void mostrarProfessor() {
		System.out.println("");
		System.out.println(this.getNome());
		System.out.println(this.getDataNascimento());
		System.out.println(this.getSiape());
		System.out.println(this.getAreaCurso());
	}
}
