
public class Main {

	public static void main(String[] args) {

//		CalculosMatematicos calculos = new CalculosMatematicos();
//		int contador = 0;
//		for(int n = 1; n <= 1000000; n++){
//			if(calculos.esPrimoCircular(n)){
//				System.out.println(n);
//				contador++;
//			}
//		}
//		System.out.println("Cantidad de números primos circulares de uno al millon: " + contador);}
		
        CalculosMatematicos cm = new CalculosMatematicos();

        ThreadNumerosPrimos threadNP = null;
//        ThreadPrimosCirculares threadNPCirc = null;

        /* Creo un nuevo Thread que será para armar la lista de numeros primos*/
        threadNP = new ThreadNumerosPrimos("Calculo de Numeros Primos", cm);
        threadNP.start();
	}
}
