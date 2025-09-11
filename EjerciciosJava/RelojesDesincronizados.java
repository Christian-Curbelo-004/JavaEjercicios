package EjerciciosJava;

public class RelojesDesincronizados implements Runnable{
    String Nombre;
    long intervalo;

    public RelojesDesincronizados(long intervalo, String nombre){
        this.intervalo = intervalo;
        this.Nombre = nombre;
    }
    public void run() {
        for(int i = 1; i <= 10; i++)
         System.out.println("[" + Nombre + "] → " + i);
         try {
            Thread.sleep(intervalo);
         }catch(InterruptedException e){
            e.printStackTrace();
         }
            System.out.println(Nombre + "Termino su cuenta de 10 ticks");
        }
        public static void main(String[] args) {
            RelojesDesincronizados r1 = new RelojesDesincronizados(1000, "Reloj 1"); 
            RelojesDesincronizados r2 = new RelojesDesincronizados(1500, "Reloj 2"); 
            RelojesDesincronizados r3 = new RelojesDesincronizados(2000, "Reloj 3");

            Thread t1 = new Thread(r1);
            Thread t2 = new Thread(r2);
            Thread t3 = new Thread(r3);

            t1.start();
            t2.start();
            t3.start();
        }
    }

    

