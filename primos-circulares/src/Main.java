public class Main {

  public static void main(String[] args) {

    CalculosMatematicos cm = new CalculosMatematicos();

    ThreadNumerosPrimos threadNP = null;

    /* Creo un nuevo Thread que será para armar la lista de numeros primos */
    threadNP = new ThreadNumerosPrimos("Calculo de Numeros Primos", cm);
    threadNP.start();
    
    
  }
}
