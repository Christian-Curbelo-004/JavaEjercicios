package EjerciciosJava;
// hola mundo en java con runnable y thread

public class HolaMundoConHilos implements Runnable {
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println("Hola Mundo desde el hilo" + Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            Thread hilo = new Thread(new HolaMundoConHilos(),":" +i);
            hilo.start();
        }
    }
}
class HilosConThread extends Thread{
        private int id;

        private HilosConThread(int id){
            this.id = id;
            this.setName("Hilo " + id);
        }
        public void run(){
            try{
                Thread.sleep(id * 1000);
                System.out.println("Hola Mundo desde el hilo " + this.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
class HilosConRunnable implements Runnable{
    private int id;

    public HilosConRunnable(int id){
        this.id = id;
        }
    
        public void run(){
            try{
                Thread.sleep(id * 1000);
                System.out.println("Hola Mundo desde el hilo " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


