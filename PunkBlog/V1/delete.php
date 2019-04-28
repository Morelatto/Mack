<?php
  include "conecta_mysql.php";

  $nome = $_POST['nome'];
  
  $resultado = mysqli_query($conexao, "DELETE FROM tabelapunkblog WHERE nome='".$nome."'") or die("Não foi possível executar a SQL: ".mysqli_error($conexao));

  if($resultado === TRUE){
	echo "<br/>Nome removido com sucesso!";
  } else {
        echo "<br/>Erro na remoção!";
  }
  mysqli_close($conexao);
?>
