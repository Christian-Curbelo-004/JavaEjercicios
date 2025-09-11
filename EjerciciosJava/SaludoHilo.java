package EjerciciosJava;

public class SaludoHilo implements Runnable{
    int hilo;
    String nombre;

    public SaludoHilo(String nombre){
        this.nombre = nombre;
        
    }

    public void run() {
       System.out.println("Hola, soy el hilo de nombre: "+ nombre);
    }
     public static void main(String[] args){
        SaludoHilo h1 = new SaludoHilo("Chino Recoba!");
        SaludoHilo h2 = new SaludoHilo("Luis Suarez!");
        
        Thread hiloUno = new Thread(h1);
        Thread hiloDos = new Thread(h2);
        
        hiloUno.start();
        hiloDos.start();

     }

}
