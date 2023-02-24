package tarefas;
import java.util.Scanner;
public class Atv02 {
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	  System.out.println("Digite uma frase:");
	  String frase = sc.nextLine();
	  System.out.println("Digite quantas vezes a frase vai repetir:");
	  int x = sc.nextInt();
	  for(int i=0;i<x;i++) {
		  System.out.println(frase);
	  }
	}
}
