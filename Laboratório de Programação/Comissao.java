import javax.swing.JOptionPane;
public class Comissao {
  public static void main (String args []){
    String NM, SFS, TVS;
    double SF, TV, SFF;
    NM=JOptionPane.showInputDialog ("Nome: ");
    SFS=JOptionPane.showInputDialog ("Sal�rio Fixo: ");
    SF=Double.parseDouble (SFS);
    TVS=JOptionPane.showInputDialog ("Total de Vendas: ");
    TV=Double.parseDouble (TVS);
    SFF=TV*0.15+SF;
    JOptionPane.showMessageDialog (null, "Nome: " + NM + "\nSal�rio Fixo: " + SF + "\nTotal de Vendas: " + TV + "\nSal�rio Fixo Final: " + SFF);
  }
}