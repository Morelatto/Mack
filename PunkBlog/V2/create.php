<?php
  // conctando ao BD
  include "conecta_mysql.php";

  $nome = $_POST['nome'];
  $nomeBanda = $_POST['nomeBanda'];
  $genero = $_POST['genero'];
  
  // executando a operação de SQL
  $resultado = mysqli_query($conexao, "INSERT INTO tabelapunkblog(nome, nomeBanda,genero) VALUES ('".$nome."','".$nomeBanda."','".$genero."')") or die("Não foi possível executar a SQL: ".mysqli_error($conexao));

  if($resultado === TRUE){
	echo "<br/>Usuário inserido com sucesso!";
  } else {
        echo "<br/>Erro na inserção!";
  }
   
  
  
  // fechamento da conexão   
  mysqli_close($conexao);
?>
