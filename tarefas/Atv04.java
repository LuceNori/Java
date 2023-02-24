package tarefas;
import java.util.Scanner;
public class Atv04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual a base do triangulo?");
		double base = sc.nextDouble();
		System.out.println("Qual a altura do triangulo?");
		double altura = sc.nextDouble();
		double area = base * altura;
		double perimetro = 2*(base+altura);
		System.out.println("A base é:"+base+" e o perimetro é:"+perimetro);
	}

}
