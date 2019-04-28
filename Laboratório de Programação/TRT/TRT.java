import javax.swing.JOptionPane;
public class TRT{
  public static void main  (String args []){
    int codigo, numero_eleitores, senha, codigo_joao=0, codigo_maria=0, codigo_branco=0, codigo_nulo=0, total=0;
    float porcentagem;
    
    numero_eleitores=Integer.parseInt (JOptionPane.showInputDialog ("Número de eleitores: "));
    do{
      codigo=Integer.parseInt (JOptionPane.showInputDialog ("Tabela de Códigos para a Eleição Municipal\nCódigo               "
                                                              +"Nome do candidato\n11                                João\n45                                "
                                                              +"Maria\n0                                  Voto em Branco\nOutros códigos       Voto Nulo"));
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
        senha=Integer.parseInt (JOptionPane.showInputDialog ("Digite a senha para confirmar o encerramento da seção: "));
        if (senha!=35719)
          JOptionPane.showMessageDialog (null, "Senha Incorreta");
        else{
          break;
        }
      }
    }
    while (total<numero_eleitores);
    porcentagem=100*total/numero_eleitores;
    JOptionPane.showMessageDialog (null, "Total de votos esperados na seção: "+numero_eleitores+".\nTotal de votos depositados: "+total+" ("+porcentagem+"%).\nJoão: "
                                     +codigo_joao+" votos.\nMaria: "+codigo_maria+" votos.\nVotos Brancos: "+codigo_branco+".\nVotos Nulos: "+codigo_nulo+"."); 
  }
}
