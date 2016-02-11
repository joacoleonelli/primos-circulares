import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadPrimosCirculares extends Thread{
	private String nombre;
    private CalculosMatematicos calc;
    private Thread hilo;
    private List<Integer> listaDePrimos;
    private List<Integer> listaDePrimosCirculares;
    private Set<Integer> conjuntoDePrimosCirculares;
    volatile boolean finalizado = false;
    
    ThreadPrimosCirculares(String nombreThread, CalculosMatematicos cm, List<Integer> listaDePrimos){
        this.nombre = nombreThread;
        this.calc = cm;
        this.listaDePrimos = listaDePrimos;
        System.out.println("Creando Thread: "+this.nombre); 
    }
       
    @Override
    public void run(){
        System.out.println("Ejecutando Thread: "+this.nombre);
        this.listaDePrimosCirculares = new LinkedList<>();
        this.conjuntoDePrimosCirculares = new HashSet<>();
        for(Integer numeroPrimo : listaDePrimos){
                if(numeroPrimo >= 10){
                    int longitud = String.valueOf(numeroPrimo).length();
                    List<Integer> listadoDeCombinaciones = new LinkedList<>();
                    String combinacion = String.valueOf(numeroPrimo);
                    int cantidad = 0;
                    for(int elemento=0; elemento < longitud;elemento++){
                        if(this.calc.esPrimo(Integer.valueOf(combinacion))){
                            listadoDeCombinaciones.add(Integer.valueOf(combinacion));
                            cantidad++;
                        }
                        combinacion = this.calc.rotarNumero(combinacion);
                    }
                    if(cantidad==longitud) conjuntoDePrimosCirculares.addAll(listadoDeCombinaciones);
                }else{
                    conjuntoDePrimosCirculares.add(numeroPrimo);
                }          
        }
        listaDePrimosCirculares.addAll(conjuntoDePrimosCirculares);
        this.setFinalizado(true);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadNumerosPrimos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    synchronized  boolean isFinalizado() {
        return finalizado;
    }

    synchronized  void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public List<Integer> getListaDePrimosCirculares() {
        return listaDePrimosCirculares;
    }   
    
    @Override
    public void start(){
        System.out.println("Comenzando Thread: "+this.nombre);
        if(this.hilo == null){
            hilo = new Thread(this, this.nombre);
            hilo.start();
        }
    }
	
}
