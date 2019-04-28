import java.util.Scanner; 
 
public class Soma{ 
  
 public static void main(String[ ] args) { 
 double A, B,C; 
 Scanner entrada; 
 entrada = new Scanner(System.in); 
 System.out.println ("Digite um número: ");
 A= entrada.nextDouble();
 System.out.println ("Digite outro número: ");
 B= entrada.nextDouble();
 C=A+B;
 System.out.println ("Soma= " + C);
 
 } 
}