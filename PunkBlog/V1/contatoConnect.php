<?php
			$conexao = mysqli_connect("127.0.0.1:3306","root","","nome do banco");
 
			if (mysqli_connect_errno()){
			echo "Não foi possível conectar: " . mysqli_connect_error();
			} 
		
			$erro = 0;
			$nome = $_POST['nome'];
			$email = $_POST['email'];
			$mensagem = $_POST['mensagem'];
			
			mysqli_close($conexao);
			
?>