package heranca;

public class Main {

	public static void main(String[] args) {
		Estudante outro = new Estudante("ads","01/03/2003", 10,"lucas");
		Professor teste = new Professor("Informatica","23/04/1986",23932,"Robesvaldo");
		outro.mostrarAluno();
		teste.mostrarProfessor();
	}

}
