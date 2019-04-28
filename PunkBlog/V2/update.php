<?php
  // conctando ao BD
  include "conecta_mysql.php";

  $nome = $_POST['nome'];
  $nomebanda = $_POST['nomebanda'];
  
  // executando a operação de SQL
  $resultado = mysqli_query($conexao, "UPDATE tabelapunkblog SET nomebanda='".$nomebanda."' WHERE nome='".$nome."'") or die("Não foi possível executar a SQL: ".mysqli_error($conexao));

  if($resultado === TRUE){
	echo "<br/>Usuário atualizado com sucesso!";
  } else {
        echo "<br/>Erro na atualização!";
  }
  // fechamento da conexão   
  mysqli_close($conexao);
?>
