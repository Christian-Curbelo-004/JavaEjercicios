package EjerciciosJava;
// incrementos de hilos mediante un contador

public class IncrementoHilos implements Runnable {
    private static  int contador = 0;

    public void run(){
        for(int i = 0; i < 5000; i++){
            contador++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new IncrementoHilos());
        Thread t2 = new Thread(new IncrementoHilos());
        Thread t3 = new Thread(new IncrementoHilos());
        Thread t4 = new Thread(new IncrementoHilos());
        
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Valor final del contador: " + contador);

    }
}