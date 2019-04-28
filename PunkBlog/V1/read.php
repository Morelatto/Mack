<?php
  include "conecta_mysql.php";
  
  $resultado = mysqli_query($conexao, "SELECT * from tabelapunkblog") or die("Não foi possível executar a SQL: ".mysqli_error($conexao));
  if($resultado){
      while($row = mysqli_fetch_array($resultado) ){
         echo $row["Nome"]. " - ".$row["Email"]." - ".$row["Mensagem"]."<br/>";
      }
  }
  mysqli_close($conexao);
?>
