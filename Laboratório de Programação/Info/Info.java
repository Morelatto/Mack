import javax.swing.JOptionPane;
  public class Info {
  public static void main (String args []) {
    String NM, CG, IDS, SBS;
    int ID;
    double SB, SBR, SBG, SF;
    NM=JOptionPane.showInputDialog("Qual � o seu nome?");
    CG=JOptionPane.showInputDialog("Qual � o seu cargo?");
    IDS=JOptionPane.showInputDialog("Qual � a sua idade?");
    ID = Integer.parseInt(IDS); 
    SBS=JOptionPane.showInputDialog("Qual � o seu sal�rio bruto?");
    SB = Double.parseDouble(SBS);
    SBR=1.38*SB;
    SBG=1.20*SBR;
    SF=0.85*SBG;
    JOptionPane.showMessageDialog(null, "Nome: " + NM + "\nCargo: " + CG +
                                  "\nIdade: " + ID + "\nSal�rio Bruto: " + 
                                  SB + "\nSal�rio Bruto Reajustado: " + SBR +
                                  "\nGratifica��o: " + SBG + "\nSal�rio Bruto Final: " + SF);
  }
  }