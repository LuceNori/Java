package tarefas;
import java.util.Scanner;
public class Atv01 {
	private String nome;
	private String frase;
	private int Quant;
	private double Base;
	private double Altura;
	public Atv01(String nome) {
		this.nome=nome;
	}
	public Atv01(String frase, int quant) {
		this.frase = frase;
		Quant = quant;
	}
	public Atv01(double base, double altura) {
		Base = base;
		Altura = altura;
	}
	
	public double getBase() {
		return Base;
	}
	public void setBase(double base) {
		Base = base;
	}
	public double getAltura() {
		return Altura;
	}
	public void setAltura(double altura) {
		Altura = altura;
	}
	public String getFrase() {
		return frase;
	}
	public void setFrase(String frase) {
		this.frase = frase;
	}
	public int getQuant() {
		return Quant;
	}
	public void setQuant(int quant) {
		Quant = quant;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String teste() {
	String nome = "olá, " + getNome();
		return nome;
	}
	public String repete() {
		String frase = getFrase();
		return frase;
	}	
	public double resul1() {
		double perimetro = (2*(this.getBase()+this.getAltura()));
		return perimetro;
	}
	public double resul2() {
		double area = (this.getBase()*this.getAltura());
		return area;
	}
	

}
