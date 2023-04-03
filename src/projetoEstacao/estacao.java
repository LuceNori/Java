package projetoEstacao;

public class estacao {

	public static void main(String[] args) {
	TremCarga trem1 = new TremCarga(26, 10, 43, "Matéria prima");
	TremPassageiro trem2 = new TremPassageiro(10, 5, 6, 3, 2);
	
	System.out.println(trem1);
	System.out.println(trem2);
	}

}
