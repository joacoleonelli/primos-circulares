
public class CalculosMatematicos {
	
    public boolean esPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public boolean esPar(int n){
    	if (n % 2 == 0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public int rotarNumero(int n){
    	int primerosNumeros = n / 10;
    	int ultimoNumero = n % 10;
    	n = primerosNumeros;
    	while(n !=0){
    		if(esPar(n))
    			n = n-1;
    		ultimoNumero = ultimoNumero * 10;
    		n = n/10;
    	}
        return ultimoNumero += primerosNumeros;
    }
    
    public boolean esPrimoCircular(int n){
    	if(esPrimo(n)){
    		int proximo = n;
    		while((proximo = rotarNumero(proximo)) != n){
    			if(proximo == -1 || !esPrimo(proximo)){
    				return false;
    			}
    		}
    		return true;
    	}else{
    		return false;
    	}
    }
}
