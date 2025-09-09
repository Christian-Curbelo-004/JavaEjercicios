package EjerciciosJava;
 // letras y numeros
public class HilosNumerosLetras implements Runnable{
    String tipo;

    public HilosNumerosLetras(String tipo){
        this.tipo = tipo;
    }

    @Override
    public void run() {

        if(tipo.equals("1")){
            for(int n = 1; n < 30; n++){
                System.out.println("Numeros: " + n);
            }
        }
        else if(tipo.equals("2")){
            for(char l = 'A'; l <= 'Z'; l++){
                System.out.println("Letras: " + l);
            }
        }
    }

    public static void main(String[] args) {
    
        Thread t1 = new Thread(new HilosNumerosLetras("1"));
        Thread t2 = new Thread(new HilosNumerosLetras("2"));
        t1.start();
        t2.start();
    }
}
    

