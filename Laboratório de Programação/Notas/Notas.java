import javax.swing.JOptionPane;
public class Notas {
  public static void main (String args []){
    String NM, NT1S, NT2S, NT3S;
    float NT1, NT2, NT3, M;
    NM=JOptionPane.showInputDialog ("Nome: ");
    NT1S=JOptionPane.showInputDialog ("Nota 1: ");
    NT1=Float.parseFloat (NT1S);
    NT2S=JOptionPane.showInputDialog ("Nota 2: ");
    NT2=Float.parseFloat (NT2S);
    NT3S=JOptionPane.showInputDialog ("Nota 3: ");
    NT3=Float.parseFloat (NT3S);
      M=(NT1+NT2+NT3)/3;
      JOptionPane.showMessageDialog (null, "Nome: " + NM + "\nMédia: " + M);
  }
}
      
      
                                     
 
    