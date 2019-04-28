import java.util.Scanner;
public class Contas {
  public static void main (String args []){
    double N1, N2, SM, SB, MP, DV;
    Scanner teclado = new Scanner (System.in);
    System.out.println ("Número 1: ");
    N1 = teclado.nextDouble ();
    System.out.println ("Número 2: ");
    N2 = teclado.nextDouble ();
    SM = N1 + N2;
    SB = N1 - N2;
    MP = N1 * N2;
    DV = N1 / N2;
    System.out.println ("Soma: " + SM);
    System.out.println ("Subtração: " + SB);
    System.out.println ("Multiplicação: " + MP);
    System.out.println ("Divisão: " + DV);
  }
}
      