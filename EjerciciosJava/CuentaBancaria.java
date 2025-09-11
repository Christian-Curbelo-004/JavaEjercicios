package EjerciciosJava;

public class CuentaBancaria implements Runnable {
    
    public String ClienteUno;
    public String ClienteDos;
    public int Digito;
    private int Saldo;
    private int Deposito;
    private int Retiro;

    public CuentaBancaria(int saldoInicial, int digito, int deposito, int retiro, String clienteUno, String clienteDos) {
        this.ClienteUno = clienteUno;
        this.ClienteDos = clienteDos;
        this.Digito = digito;
        this.Saldo = saldoInicial;
        this.Deposito = deposito;
        this.Retiro = retiro;
        
    }

    public void run() {
       if(Digito == 1) {
        System.out.println(ClienteUno + " consultó su saldo: " + Saldo);
        System.out.println(ClienteDos + " consultó su saldo: " + Saldo);

           // Lógica para el cliente uno
       } else if(Digito == 2) {
           Saldo -= Retiro;
           System.out.println(ClienteUno + " retiró: " + "Saldo actual: " + Saldo);
           System.out.println(ClienteDos + " retiró: " + "Saldo actual: " + Saldo);

       } else if (Digito == 3) {
           Saldo += Deposito;
           System.out.println(ClienteUno + " depositó: " + "Saldo actual: " + Saldo);
           System.out.println(ClienteDos + " depositó: " + "Saldo actual: " + Saldo);
       }
       
    }
    public static void main(String[] args) {
           CuentaBancaria cuenta = new CuentaBancaria(100, 1, 50, 30, "Cliente Uno", "Cliente Dos");
           CuentaBancaria cuenta2 = new CuentaBancaria(100, 2, 50, 30, "Cliente Uno", "Cliente Dos");
           CuentaBancaria cuenta3 = new CuentaBancaria(100, 3, 50, 30, "Cliente Uno", "Cliente Dos");
           Thread cliente1 = new Thread(cuenta);
           Thread cliente2 = new Thread(cuenta2);
           Thread cliente3 = new Thread(cuenta3);
           cliente1.start();
           cliente2.start();
           cliente3.start();
       }
}
