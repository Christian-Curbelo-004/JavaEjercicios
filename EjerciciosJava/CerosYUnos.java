package EjerciciosJava;
public class CerosYUnos{
    public void procesarNumeros() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 1000; i++) {
            sb.append("0");
        }
        for (int i = 0; i < 1000; i++) {
            sb.append("1");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        CerosYUnos numeros = new CerosYUnos();
        numeros.procesarNumeros();
    }
}
    

  


