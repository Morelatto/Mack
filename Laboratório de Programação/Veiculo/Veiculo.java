import java.util.Scanner;
public class Veiculo {
  public static void main (String args []){
    double DTP, CG, CM;
    Scanner teclado = new Scanner (System.in);
    System.out.println ("Dist�ncia Total Percorrida: ");
    DTP = teclado.nextDouble ();
    System.out.println ("Combust�vel Gasto: ");
    CG = teclado.nextDouble ();
    CM=CG/DTP;
    System.out.println ("Consumo M�dio: " + CM);
  }
}