import javax.swing.JOptionPane;
public class Produtos {
  public static void main (String args []){
    double VP, VPA;
    int CP;
    String VPS, CPS;
      VPS=JOptionPane.showInputDialog ("Valor do Produto: ");
      VP=Double.parseDouble(VPS);
      CPS=JOptionPane.showInputDialog ("Inserir: \n10% de Aumento-1 \n25% de Aumento-3 \n30% de Aumento-4 \n50% de Aumento-8 ");
      CP=Integer.parseInt(CPS);
      switch (CP) {
        case 1: VPA=VP*1.10;
        JOptionPane.showMessageDialog (null, "Valor do Produto com Aumento: "+VPA);
        break;
        case 3: VPA=VP*1.25;
        JOptionPane.showMessageDialog (null, "Valor do Produto com Aumento: "+VPA);
        break;
        case 4: VPA=VP*1.30;
        JOptionPane.showMessageDialog (null, "Valor do Produto com Aumento: "+VPA);
        break;
        case 8: VPA=VP*1.50;
        JOptionPane.showMessageDialog (null, "Valor do Produto com Aumento: "+VPA);
        break;
        default: 
        JOptionPane.showMessageDialog (null, "Insira somente os números 1, 3, 4 ou 8.");    
      }
  }
}
        
      
