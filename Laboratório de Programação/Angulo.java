import javax.swing.JOptionPane;
  public class Angulo {
  public static void main (String args []){
    String AS;
    int A;
    double SN, CSN, TG, SC, CSC, CTG;
    AS=JOptionPane.showInputDialog ("Ângulo: ");
    A = Integer.parseInt(AS);
    SN=Math.sin(A);
    CSN=Math.cos(A);
    TG=Math.tan(A);
    SC=1/CSN;
    CSC=1/SN;
    CTG=CSN/SN;
    JOptionPane.showMessageDialog (null, "Seno: " + SN + "\nCosseno: " + CSN + 
                                   "\nTangente: " + TG + "\nSecante: " + SC + "\nCossecante: " + 
                                   CSC+ "\nCotangente: " + CTG);
  }
  }
    
    