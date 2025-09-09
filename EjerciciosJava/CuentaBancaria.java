package EjerciciosJava;

public class CuentaBancaria implements Runnable {
    
    public String ClienteUno;
    public String ClienteDos;

    public int Digito;
    private int Saldo;
    private int Deposito;
    private int Retiro;

    public CuentaBancaria(int saldoInicial) {
        this.Saldo = saldoInicial;
        this.Deposito = 0;
        this.Retiro = 0;
    }

    public void run() {
       if(Digito == 1) {
        System.out.println("Cliente nno consultó su saldo: " + Saldo);
        System.out.println("Cliente dos consultó su saldo: " + Saldo);

           // Lógica para el cliente uno
       } else if(Digito == 2) {
           System.out.println("Cliente uno retiró: " + (Retiro - Saldo));
           System.out.println("Cliente dos retiró: " + (Retiro - Saldo));

       } else if (Digito == 3) {
           System.out.println("Cliente uno depositó: " + (Deposito + Saldo));
           System.out.println("Cliente dos depositó: " + (Deposito + Saldo));
       }
       
    }
    public static void main(String[] args) {
           CuentaBancaria cuenta = new CuentaBancaria(100);
           Thread cliente1 = new Thread(cuenta);
           Thread cliente2 = new Thread(cuenta);
           cliente1.start();
           cliente2.start();
       }

}
