import javax.swing.JOptionPane;
public class ParImpar {
  public static void main (String args []) {
      String NS;
      int N, C, RDI;
       NS=JOptionPane.showInputDialog("Número: ");
       N=Integer.parseInt(NS);
       C=N%100;
       RDI=(int)C/2;
       if (RDI==0){
         JOptionPane.showMessageDialog (null, "A centena do número "+N+" é par");
       }
       else {
         JOptionPane.showMessageDialog (null, "A centena do número "+N+" é ímpar");
       }
  }
}
          