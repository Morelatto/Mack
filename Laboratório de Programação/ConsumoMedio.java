import java.util.Scanner;
public class ConsumoMedio {
  public static void main (String args []){
    double DTP, CTG, CM;
    Scanner teclado = new Scanner (System.in);
    System.out.println ("Dist�ncia Total Percorrida (KM): ");
    DTP = teclado.nextDouble ();
    System.out.println ("Combust�vel Total Gasto (L): ");
    CTG = teclado.nextDouble ();
    CM = CTG / DTP;
    System.out.println ("Consumo M�dio (L/KM): " + CM);
  }
}
  