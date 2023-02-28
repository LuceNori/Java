package tarefas;
import java.util.Scanner;
import java.util.ArrayList;
public class Atv06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Atv01> N =  new ArrayList<>();
		System.out.println("---TABELA---");
		System.out.println("1.Diga olá");
		System.out.println("2.Repetindo frase");
		System.out.println("3.Repetindo frase v2");
		System.out.println("4.geometria");
		System.out.println("5.Bidimensional");
		System.out.println("6.Sair");
		int op = sc.nextInt();
		switch(op) {
		case 1:
			System.out.println("Caso 1:");
			System.out.println("Digite seu nome");
			sc.nextLine();
			String nome = sc.nextLine();
			Atv01 n1 = new Atv01(nome);
			N.add(n1);
			for (Atv01 atv01 : N) {
				System.out.println(atv01.teste());
			}
			break;
		case 2:
			System.out.println("Caso 2:");
			System.out.println("Digite uma frase");
			sc.nextLine();
			String frase = sc.nextLine();
			System.out.println("Digite quantas vezes a frase vai repetir:");
			int quant = sc.nextInt();
			Atv01 n2 = new Atv01(frase,quant);
			N.add(n2);
			for (Atv01 atv01 : N) {
				for(int i=0;i<quant;i++) {
					System.out.println(atv01.repete());			
				}
			}
			break;
		case 3:
			System.out.println("Caso 3");
			System.out.println("Digite quantas vezes a frase vai repetir:");
			quant = sc.nextInt();
			System.out.println("Digite uma frase");
			sc.nextLine();
			frase = sc.nextLine();
			Atv01 n3 = new Atv01(frase,quant);
			N.add(n3);
			for (Atv01 atv01 : N) {
				for(int i=0;i<quant;i++) {
					System.out.println(atv01.repete());			
				}
			}
			break;
		case 4:
			System.out.println("Caso 4");
			System.out.println("Digite a base do retangulo:");
			double base = sc.nextDouble();
			System.out.println("Digite a altura do retangulo:");
			double altura = sc.nextDouble();
			Atv01 n4 = new Atv01(base,altura);
			N.add(n4);
			for (Atv01 atv01 : N) {
				System.out.println("O perimetro é:"+atv01.resul1()+" e a area é:"+atv01.resul2());
			}
			break;
		case 5:
			System.out.println("Caso 5");
			System.out.println("Quantidade de linhas:");
			int k = sc.nextInt();
			System.out.println("Quantidade de colunas:");
			int l = sc.nextInt();
			String m[][]= new String[k][l];
			for(int i=0;i<k;i++) {
				sc.nextLine();
				for(int j=0;j<l;j++) {
					m[i][j] =sc.nextLine();
				}
			}
			for(int i=0;i<k;i++) {
				System.out.println("");
				for(int j=0;j<l;j++) {
					System.out.print(m[i][j]+"|");
				}
			}
			break;
		case 6:
			System.out.println("Fim");
			break;
		}
	}

}
