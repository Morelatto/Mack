algoritmo "C�lculo-Conta de �gua e desconto"
// Fun��o : Calcular conta de �gua e desconto
// Autor : Pedro Morelatto
// Data : 11/02/2014
// Se��o de Declara��es 
var
A, B, C, D: real
inicio
// Se��o de Comandos 
escreva("Sal�rio M�nimo: ")
leia (A)
escreva ("Quantidade de �gua: ")
leia (B)
C<-B*A*0.02/1000
D<-0.85*C
escreva ("Valor da conta de �gua: ", C)
escreva ("Valor com 15% de desconto: ", D)
fimalgoritmo
