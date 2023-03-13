package heranca;

public class Estudante extends Pessoa{
	private int ra;
	private String curso;
	public Estudante(String nome, String dataNascimento, int ra, String curso) {
		super(nome, dataNascimento);
		this.ra = ra;
		this.curso = curso;
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	@Override
	public String toString() {
		return 	super.toString()+
				this.getRa()+'\n'+
				this.getCurso();
	}
}
