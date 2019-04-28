<?php
  include "conecta_mysql.php";

  $nome = $_POST['nome'];
  $email = $_POST['email'];
  
  $resultado = mysqli_query($conexao, "UPDATE tabelapunkblog SET nome='".$nome."' WHERE nome='".$nome."'") or die("Não foi possível executar a SQL: ".mysqli_error($conexao));

  if($resultado === TRUE){
	echo "<br/>Nome atualizado com sucesso!";
  } else {
        echo "<br/>Erro na atualização!";
  }
  mysqli_close($conexao);
?>
