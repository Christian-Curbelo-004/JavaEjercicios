package EjerciciosJava;

public class CuentaRegresiva implements Runnable {
    public static int Hilo;
    public int Contador;
    public int LimiteContador = 5;
    
    public CuentaRegresiva( int contador, int Hilo, int LimiteContador) {
       this.Contador = contador;
        CuentaRegresiva.Hilo = Hilo;
       this.LimiteContador = LimiteContador;
    }
    
    public void run() {
        while(Contador >= 0) {
            System.out.println("Hilo: " + Contador);
            Contador --;

            try{
                Thread.sleep(1000);
            } catch(final InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("termino la cuenta regresiva del hilo");
    }
    public static void main(String[] args) {
        CuentaRegresiva cr = new CuentaRegresiva(5,1,5);
        Thread hilo = new Thread(cr);

        hilo.start();

    }
    }
           

    

