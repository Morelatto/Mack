import javax.swing.JOptionPane;
public class TRT2{
  public static void main (String args []){
    int numero_eleitores, contador=0;
    float codigo, senha;
    numero_eleitores=Integer.parseInt (JOptionPane.showInputDialog ("N�mero de Eleitores: "));
    while (numero_eleitores>0){
      codigo=Float.parseFloat (JOptionPane.showInputDialog ("Tabela de C�digos para a Elei��o Municipal\nC�digo               Nome do candidato\n11                                Jo�o\n45                                Maria\n0                                  Voto em Branco\nOutros c�digos       Voto Nulo"));
      contador++;
      if(numero_eleitores==contador){
        JOptionPane.showMessageDialog (null, "Todos os eleitores j� votaram.");
      if (codigo==-12345){
        senha=Float.parseFloat (JOptionPane.showInputDialog ("Senha: "));
        if (senha==-35719)
          JOptionPane.showMessageDialog (null, "Total de votos.....");
        else
          JOptionPane.showMessageDialog (null, "Senha Incorreta");
      }
    }
  }
}
}
      