import java.util.Scanner;
  public class Conta {
  public static void main (String args []){
    double SM, QC, VC, VD;
    Scanner teclado = new Scanner (System.in);
    System.out.println ("Sal�rio M�nimo: ");
    SM = teclado.nextDouble ();
    System.out.println ("Quantidade Consumida de �gua: ");
    QC = teclado.nextDouble ();
    VC = QC*SM*0.02/1000;
    VD = VC*0.85;
    System.out.println ("Valor da Conta: " + VC);
    System.out.println ("Valor da Conta com Desconto: " +VD);
  }
  }
                         
 
    