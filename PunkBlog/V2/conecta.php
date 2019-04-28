<?php
  include "conecta_mysql.php";
  
  $resultado = mysqli_query($conexao, "SELECT * from TabelaPunk");
  if($resultado){
      while($row = mysqli_fetch_array($resultado) ){
         echo $row["nome"]." - ".$row["email"]." - ".$row["mensagem"]."<br/>";
      }
  }
  mysqli_close($conexao);
?>
