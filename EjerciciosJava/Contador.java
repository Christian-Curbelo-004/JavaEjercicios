package EjerciciosJava;


// Contador 
public class Contador implements Runnable {
    int Contador;
    String NombreHilo;
    int LimiteContador;

    public Contador(int limite) {
        this.LimiteContador = limite;
        this.Contador = 0;
        this.NombreHilo = "Hilo-Contador";
    }

    public void run(){
        for(int i = 0; i < LimiteContador; i++){
            Contador++;
            System.out.println("Contador: " + Contador + " - " + NombreHilo);
        }
    }

    public static void main(String[] args){
        Contador c1 = new Contador(1);
        Contador c2 = new Contador(2);
        Contador c3 = new Contador(3);
        
        Thread thread1 = new Thread(c1);
        Thread thread2 = new Thread(c2);
        Thread thread3 = new Thread(c3);
        
        thread1.start();
        thread2.start();
        thread3.start();    
    }
}
