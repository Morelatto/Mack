<?php
  include "conecta_mysql.php";

  $nome = $_POST['nome'];
  $email = $_POST['email'];
  $mensagem = $_POST['mensagem'];
  
  $resultado = mysqli_query($conexao, "INSERT INTO tabelapunkblog(nome, email, mensagem) VALUES ('".$nome."','".$email."','".$mensagem."')") or die("Não foi possível executar a SQL: ".mysqli_error($conexao));

  if($resultado === TRUE){
	echo "<br/>Sugestão enviada com sucesso!";
  } else {
        echo "<br/>Erro na inserção!";
  }
   
  mysqli_close($conexao);
?>
