package EjerciciosJava;

import java.util.Random;

public class CarreraDeHilos implements Runnable{
    public int hilo;
    public String nombre;
    public int posicion = 0;
    public static boolean ganador = false;
    public static final int meta = 100;
     private final Random random = new Random();

    public CarreraDeHilos(final String nombre) {
        this.nombre = nombre;
    }

    public void run() {
       while(posicion < meta && !ganador) {
        final int paso = random.nextInt(10) + 1;
        posicion += paso;
         System.out.println("[Corredor " + nombre + "] avanza " + paso + " --> total: " + posicion);

         if(posicion >= meta && !ganador){
            System.out.println("Gano el corredor:  " + nombre);
         }
         try  {
            Thread.sleep(500);
         } catch(InterruptedException e) {
            e.printStackTrace();
         }
       }
    }
    public static void main(final String[] args) {
        final CarreraDeHilos h1 = new CarreraDeHilos("1:");
        final CarreraDeHilos h2 = new CarreraDeHilos("2: ");
        final CarreraDeHilos h3 = new CarreraDeHilos("3: ");

        final Thread t1 = new Thread(h1);
        final Thread t2 = new Thread(h2);
        final Thread t3 = new Thread(h3);

        t1.start();
        t2.start();
        t3.start();
    }
    
}
