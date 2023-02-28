package tarefas;
import java.util.Scanner;
public class Atv05 {

	public static void main(String[] args) {
		System.out.println("Caso 5");
			System.out.println("Quantidade de linhas:");
			int k = sc.nextInt();
			System.out.println("Quantidade de colunas:");
			int l = sc.nextInt();
			System.out.println("Digite uma palavra");
			String palavra = sc.nextLine();
			for(int i=0;i<k;i++) {
				System.out.println("");
				for(int j=0;j<l;j++) {
					System.out.print(palavra+"|");
				}
			}
	}
}
