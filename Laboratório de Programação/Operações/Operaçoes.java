import javax.swing.JOptionPane;
public class Opera�oes{
  public static void main (String args []){
    int NE;
    double N1, N2, R;
    String N1S, N2S, NES;
      N1S=JOptionPane.showInputDialog ("Digite um n�mero: ");
      N1=Double.parseDouble(N1S);
      N2S=JOptionPane.showInputDialog ("Digite outro n�mero: ");
      N2=Double.parseDouble(N2S);
      NES=JOptionPane.showInputDialog ("Escolha umas das op��es:\n1) M�dia \n2)Subtra��o (Maior pelo Menor) \n3)Multiplica��o \n4)Divis�o (1� N�mero/2� N�mero)");
      NE=Integer.parseInt (NES);
        if (NE<1 || NE>4){
        JOptionPane.showMessageDialog (null, "Digite um n�mero de 1 at� 4.");
      }
      else {
      switch (NE) {
        case 1:R=(N1+N2)/2;
          JOptionPane.showMessageDialog (null, "M�dia: "+R);
          break;
        case 2: 
          if (N1>N2){
          R=N1-N2;
          JOptionPane.showMessageDialog (null, "Resultado Subtra��o: "+R);
        }
          else {
            R=N2-N1;
            JOptionPane.showMessageDialog (null, "Resultado Subtra��o: "+R);
          }
          break;
        case 3: 
          R=N1*N2;
        JOptionPane.showMessageDialog (null, "Resultado Multiplica��o: "+R);
        break;
        case 4: 
          if (N2==0){
          JOptionPane.showMessageDialog (null, "Divis�o Imposs�vel.");
        }
          else {
            R=N1/N2;
            JOptionPane.showMessageDialog (null, "Resultado Divis�o: "+R);
           
          }
          break;
      }
      }
  }
}