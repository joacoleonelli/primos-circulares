
public class Main {

	public static void main(String[] args) {

		CalculosMatematicos calculos = new CalculosMatematicos();
		int contador = 0;
		for(int n = 1; n <= 1000000; n++){
			if(calculos.esPrimoCircular(n)){
				System.out.println(n);
				contador++;
			}
		}
		System.out.println("Cantidad de números primos circulares de uno al millon: " + contador);
	}
}
