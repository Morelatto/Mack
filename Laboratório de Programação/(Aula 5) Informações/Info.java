import javax.swing.JOptionPane;
  public class Info {
  public static void main (String args []) {
    String NM, CG, IDS, SBS;
    int ID;
    double SB, SBR, SBG, SF;
    NM=JOptionPane.showInputDialog("Qual é o seu nome?");
    CG=JOptionPane.showInputDialog("Qual é o seu cargo?");
    IDS=JOptionPane.showInputDialog("Qual é a sua idade?");
    ID = Integer.parseInt(IDS); 
    SBS=JOptionPane.showInputDialog("Qual é o seu salário bruto?");
    SB = Double.parseDouble(SBS);
    SBR=1.38*SB;
    SBG=1.20*SBR;
    SF=0.85*SBG;
    JOptionPane.showMessageDialog(null, "Nome: " + NM + "\nCargo: " + CG +
                                  "\nIdade: " + ID + "\nSalário Bruto: " + 
                                  SB + "\nSalário Bruto Reajustado: " + SBR +
                                  "\nGratificação: " + SBG + "\nSalário Bruto Final: " + SF);
  }
  }