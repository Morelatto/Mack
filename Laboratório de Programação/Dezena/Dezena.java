import javax.swing.JOptionPane;
  public class Dezena {
  public static void main (String args []){
    String NS;
    int N, D, C;
    NS=JOptionPane.showInputDialog("Número: ");
    N=Integer.parseInt(NS);
    C=N%100;
    D=(int)(C/10);
    JOptionPane.showMessageDialog(null, "Dezena: " + D);
  }
  }
    
    
    
    
    
    
    
    
    
    
    
    
  
  
  