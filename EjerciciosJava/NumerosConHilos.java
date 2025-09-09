package EjerciciosJava;
// numeros con hilos

public class NumerosConHilos implements Runnable {
    public void run(){
        for(int i = 0; i < 1000; i++) {
            System.out.println("0" + Thread.currentThread().getName());
        }
        for(int n = 0; n < 1000; n++) {
            System.out.println("1" + Thread.currentThread().getName());
        }
    }
}

