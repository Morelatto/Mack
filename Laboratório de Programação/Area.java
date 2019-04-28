import java.util.Scanner;
public class Area {
  public static void main (String args []){
    float L, A;
    Scanner teclado = new Scanner (System.in);
    System.out.println ("Lado = ");
    L = teclado.nextFloat ();
    A = L*L;
      System.out.println ("Área = " + A);
  }
}
   
      