import java.util.Scanner; 
 
public class Soma{ 
  
 public static void main(String[ ] args) { 
 double A, B,C; 
 Scanner entrada; 
 entrada = new Scanner(System.in); 
 System.out.println ("Digite um n�mero: ");
 A= entrada.nextDouble();
 System.out.println ("Digite outro n�mero: ");
 B= entrada.nextDouble();
 C=A+B;
 System.out.println ("Soma= " + C);
 
 } 
}