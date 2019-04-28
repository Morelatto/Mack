<?php
  // abrir conexao e selecionar o banco de dados
  // CONFERIR A PORTA ABERTA PARA MYSQL NO MACKENZIE
  $conexao = mysqli_connect("localhost:80","root","","basepunk");
  
  // tratamento de erros
  if (mysqli_connect_errno())
  {
      echo "Não foi possível conectar: " . mysqli_connect_error();
  } 	
?>