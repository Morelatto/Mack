import java.util.Scanner;
  public class Agua {
  public static void main (String args []){
    double CA, QA, SM, DC;
      Scanner teclado=new Scanner (System.in);
      System.out.println ("Quantidade de Água: ");
      QA=teclado.nextDouble ();
      System.out.println ("Salário Mínimo: ");
      SM=teclado.nextDouble ();
    CA=QA*SM*0.02/1000;
    DC=0.85*CA;
    System.out.println ("Conta de Água: " + CA);
    System.out.println ("Valor com Desconto: " +DC);
  }
  }
