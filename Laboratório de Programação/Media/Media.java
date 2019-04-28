import javax.swing.JOptionPane;
public class Media {
  public static void main (String args []) {
    String NT1S, NT2S, NT3S;
    double NT1, NT2, NT3, NTF;
      NT1S=JOptionPane.showInputDialog ("Primeira Nota: ");
      NT1=Double.parseDouble (NT1S);
      NT2S=JOptionPane.showInputDialog ("Segunda Nota: ");
      NT2=Double.parseDouble (NT2S);
      NT3S=JOptionPane.showInputDialog ("Terceira Nota: ");
      NT3=Double.parseDouble (NT3S);
      NTF=NT1*0.2+NT2*0.3+NT3*0.5;
      if (NTF>=6){
        JOptionPane.showMessageDialog  (null, "Aprovado: "+NTF);
      }
       else {
          JOptionPane.showMessageDialog  (null, "Reprovado: "+NTF);
        }
  }
}
          
  
 
  