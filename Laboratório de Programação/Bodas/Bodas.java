import javax.swing.JOptionPane;
public class Bodas{
  public static void main (String args []){
    int AC, AA, QA;
    String ACS, AAS;
    ACS=JOptionPane.showInputDialog ("Ano de Casamento: ");
    AC=Integer.parseInt (ACS);
    AAS=JOptionPane.showInputDialog ("Ano Atual: ");
    AA=Integer.parseInt (AAS);
    QA=AA-AC;
    switch (QA){
      case 25:JOptionPane.showMessageDialog (null, "Bodas de Prata.");
      break;
         case 50:JOptionPane.showMessageDialog (null, "Bodas de Ouro.");
      break;   
      case 75:JOptionPane.showMessageDialog (null, "Bodas de Diamante.");
      break;
      default:JOptionPane.showMessageDialog (null, "Você está casado à "+QA+" anos.");
    }
  }
}