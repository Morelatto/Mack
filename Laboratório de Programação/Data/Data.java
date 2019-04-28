import javax.swing.JOptionPane;
public class Data{
  public static void main (String args []){
    int D, M, A;
    String DS, MS, AS, MES;
      DS=JOptionPane.showInputDialog ("Dia: ");
      D=Integer.parseInt (DS);
      MS=JOptionPane.showInputDialog ("Mês: ");
      M=Integer.parseInt (MS);
      if (M>12 || M<1){
        JOptionPane.showMessageDialog (null, "Digite um número de 1 até 12");
      }
      else {
      AS=JOptionPane.showInputDialog ("Ano: ");
      A=Integer.parseInt (AS);
      switch (M){
        case 1:JOptionPane.showMessageDialog (null, D+" de Janeiro de "+A);
          break;
        case 2:JOptionPane.showMessageDialog (null, D+" de Fevereiro de "+A);
        break;
        case 3:JOptionPane.showMessageDialog (null, D+" de Março de "+A);
        break;
        case 4:JOptionPane.showMessageDialog (null, D+" de Abril de "+A);
        break;
        case 5:JOptionPane.showMessageDialog (null, D+" de Maio de "+A);
        break;
        case 6:JOptionPane.showMessageDialog (null, D+" de Junho de "+A);
        break;
        case 7:JOptionPane.showMessageDialog (null, D+" de Julho de "+A);
        break;
        case 8:JOptionPane.showMessageDialog (null, D+" de Agosto de "+A);
        break;
        case 9:JOptionPane.showMessageDialog (null, D+" de Setembro de "+A);
        break;
        case 10:JOptionPane.showMessageDialog (null, D+" de Outubro de "+A);
        break;
        case 11:JOptionPane.showMessageDialog (null, D+" de Novembro de "+A);
        break;
        case 12:JOptionPane.showMessageDialog (null, D+" de Dezembro de "+A);
        break;
      }
  }
}
}