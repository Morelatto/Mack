import javax.swing.JOptionPane;
public class Operaçoes{
  public static void main (String args []){
    int NE;
    double N1, N2, R;
    String N1S, N2S, NES;
      N1S=JOptionPane.showInputDialog ("Digite um número: ");
      N1=Double.parseDouble(N1S);
      N2S=JOptionPane.showInputDialog ("Digite outro número: ");
      N2=Double.parseDouble(N2S);
      NES=JOptionPane.showInputDialog ("Escolha umas das opções:\n1) Média \n2)Subtração (Maior pelo Menor) \n3)Multiplicação \n4)Divisão (1º Número/2º Número)");
      NE=Integer.parseInt (NES);
        if (NE<1 || NE>4){
        JOptionPane.showMessageDialog (null, "Digite um número de 1 até 4.");
      }
      else {
      switch (NE) {
        case 1:R=(N1+N2)/2;
          JOptionPane.showMessageDialog (null, "Média: "+R);
          break;
        case 2: 
          if (N1>N2){
          R=N1-N2;
          JOptionPane.showMessageDialog (null, "Resultado Subtração: "+R);
        }
          else {
            R=N2-N1;
            JOptionPane.showMessageDialog (null, "Resultado Subtração: "+R);
          }
          break;
        case 3: 
          R=N1*N2;
        JOptionPane.showMessageDialog (null, "Resultado Multiplicação: "+R);
        break;
        case 4: 
          if (N2==0){
          JOptionPane.showMessageDialog (null, "Divisão Impossível.");
        }
          else {
            R=N1/N2;
            JOptionPane.showMessageDialog (null, "Resultado Divisão: "+R);
           
          }
          break;
      }
      }
  }
}