import java.util.Scanner;
public class NovoSalario {
  public static void main (String args []){
    double S, NS;
    Scanner teclado = new Scanner (System.in);
    System.out.println ("Sal�rio: ");
    S = teclado.nextDouble ();
    NS = S*1.153;
    System.out.println ("Novo Sal�rio: " + NS);
  }
}
    
 
  