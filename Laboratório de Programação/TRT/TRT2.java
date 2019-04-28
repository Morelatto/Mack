import javax.swing.JOptionPane;
public class TRT2{
  public static void main (String args []){
    int numero_eleitores, contador=0;
    float codigo, senha;
    numero_eleitores=Integer.parseInt (JOptionPane.showInputDialog ("Número de Eleitores: "));
    while (numero_eleitores>0){
      codigo=Float.parseFloat (JOptionPane.showInputDialog ("Tabela de Códigos para a Eleição Municipal\nCódigo               Nome do candidato\n11                                João\n45                                Maria\n0                                  Voto em Branco\nOutros códigos       Voto Nulo"));
      contador++;
      if(numero_eleitores==contador){
        JOptionPane.showMessageDialog (null, "Todos os eleitores já votaram.");
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
      