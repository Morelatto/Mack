import javax.swing.JOptionPane;
public class TRT{
  public static void main  (String args []){
    int codigo, numero_eleitores, senha, codigo_joao=0, codigo_maria=0, codigo_branco=0, codigo_nulo=0, total=0;
    float porcentagem;
    
    numero_eleitores=Integer.parseInt (JOptionPane.showInputDialog ("N�mero de eleitores: "));
    do{
      codigo=Integer.parseInt (JOptionPane.showInputDialog ("Tabela de C�digos para a Elei��o Municipal\nC�digo               "
                                                              +"Nome do candidato\n11                                Jo�o\n45                                "
                                                              +"Maria\n0                                  Voto em Branco\nOutros c�digos       Voto Nulo"));
      if (codigo!=12345){
        total++;
        switch (codigo){
          case 11: codigo_joao++;
          break;
          case 45: codigo_maria++;
          break;
          case 0: codigo_branco++;
          break;
          default: codigo_nulo++;
        }
      }
      else {
        senha=Integer.parseInt (JOptionPane.showInputDialog ("Digite a senha para confirmar o encerramento da se��o: "));
        if (senha!=35719)
          JOptionPane.showMessageDialog (null, "Senha Incorreta");
        else{
          break;
        }
      }
    }
    while (total<numero_eleitores);
    porcentagem=100*total/numero_eleitores;
    JOptionPane.showMessageDialog (null, "Total de votos esperados na se��o: "+numero_eleitores+".\nTotal de votos depositados: "+total+" ("+porcentagem+"%).\nJo�o: "
                                     +codigo_joao+" votos.\nMaria: "+codigo_maria+" votos.\nVotos Brancos: "+codigo_branco+".\nVotos Nulos: "+codigo_nulo+"."); 
  }
}
