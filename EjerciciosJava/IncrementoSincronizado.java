package EjerciciosJava;

// este es con semaforo broo
import java.util.concurrent.Semaphore;
// Con sincronziacion con semaforos
public class IncrementoSincronizado implements Runnable {
    public String ClienteUno;
    public String ClienteDos;
    public int Digito;
    private int Saldo;
    private int Deposito;
    private int Retiro;

    Semaphore semaphore = new Semaphore(1);

    public IncrementoSincronizado(String clienteUno, String clienteDos, int digito, int saldo, int deposito, int retiro){
        this.ClienteUno = clienteUno;
        this.ClienteDos = clienteDos;
        this.Digito = digito;
        this.Saldo = saldo;
        this.Deposito = deposito;
        this.Retiro = retiro;
    }

    public void Consultar(){
        try {
            semaphore.acquire();
            System.out.println(ClienteUno + " consulto su saldo : " + Saldo);
            System.out.println(ClienteDos + " consulto su saldo : " + Saldo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public void Depositar(){
        try {
            semaphore.acquire();
            Saldo += Deposito;
            System.out.println(ClienteUno + " deposito: " + Deposito + " en su cuenta, ahora su saldo es de: " + Saldo);
            System.out.println(ClienteDos + " deposito: " + Deposito + " en su cuenta, ahora su saldo es de:  " + Saldo);
        } catch (InterruptedException e) {
            e.printStackTrace();    
        } finally {
            semaphore.release();
        }
    }

    public void Retirar(){
        try {
            semaphore.acquire();
            Saldo -= Retiro;
            System.out.println(ClienteUno + " retiro: " + Retiro + " y ahora tiene: " + Saldo);
            System.out.println(ClienteDos + " retiro: " + Retiro + " y ahora tiene: " + Saldo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void run(){
        if (Digito == 1) {
            Consultar();
        } else if (Digito == 2) {
            Depositar();
        } else if (Digito == 3) {
            Retirar();
        }
    }

    public static void main(String[] args){
        IncrementoSincronizado cuenta1 = new IncrementoSincronizado("Cliente Uno", "Cliente Dos", 1, 100, 70, 50);
        IncrementoSincronizado cuenta2 = new IncrementoSincronizado("Cliente Uno", "Cliente Dos", 2, 100, 80, 30);
        IncrementoSincronizado cuenta3 = new IncrementoSincronizado("Cliente Uno", "Cliente Dos", 3, 1000, 200, 100);

        Thread c1 = new Thread(cuenta1);
        Thread c2 = new Thread(cuenta2);
        Thread c3 = new Thread(cuenta3);

        c1.start();
        c2.start();
        c3.start();
    }
}
