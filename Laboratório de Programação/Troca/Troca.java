import java.util.Scanner;
public class Troca{
  public static void main (String args []){
    double N1, N2;
    Scanner teclado = new Scanner (System.in);
    System.out.println ("Número 1: ");
    N1 = teclado.nextDouble ();
    System.out.println ("Número 2: ");
    N2 = teclado.nextDouble ();
    System.out.println ("Número 1: " + N2);
    System.out.println ("Número 2: " + N1);
  }
  }