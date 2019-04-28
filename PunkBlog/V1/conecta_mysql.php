<?php
  // CONFERIR A PORTA ABERTA PARA MYSQL NO MACKENZIE
  $conexao = mysqli_connect("localhost:3308","root","","tecweb2");
  
  if (mysqli_connect_errno())
  {
      echo "Não foi possível conectar: " . mysqli_connect_error();
  } 	
?>