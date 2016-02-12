import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadNumerosPrimos extends Thread{

	private String nombre;
    private CalculosMatematicos calc;
    private Thread hilo;
    private List<Integer> listaDePrimos;
    private boolean finalizado = false;
    private int contador = 0;
    
    ThreadNumerosPrimos(String nombreThread, CalculosMatematicos cm) {
        this.nombre = nombreThread;
        this.calc = cm;
        System.out.println("Creando Thread: " + this.nombre);
    }
    

    @Override
    public void run() {
        //IMPLEMENTAR FUNCIONALIDAD AQUI
        System.out.println("Ejecutando Thread: " + this.nombre);
        /* Primero pongo todos los numeros primos dentro de una Coleccion [Lista] */
        this.listaDePrimos = new LinkedList<>();
        for (int i = 0; i <= 1000000; i++) {
            if (this.calc.esPrimo(i)) {
                this.listaDePrimos.add(i);
                contador++;
                System.out.println(i);
            }
        }
        System.out.println("Cantidad de numeros primos de uno al millon: " + contador);
        this.finalizado = true;
        try {
            /* Una vez finalizado el proceso duermo un rato el Thread*/
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadNumerosPrimos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Integer> getListaDePrimos() {
        return listaDePrimos;
    }

    synchronized boolean isFinalizado() {
        return finalizado;
    }

    synchronized void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public void start() {
        System.out.println("Comenzando Thread: " + this.nombre);
        if (this.hilo == null) {
            hilo = new Thread(this, this.nombre);
            hilo.start();
        }
    }
    
}
