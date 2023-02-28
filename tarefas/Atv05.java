package tarefas;
import java.util.Scanner;
public class Atv05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
	}
}
