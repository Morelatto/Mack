algoritmo "Cálculo-Conta de água e desconto"
// Função : Calcular conta de água e desconto
// Autor : Pedro Morelatto
// Data : 11/02/2014
// Seção de Declarações 
var
A, B, C, D: real
inicio
// Seção de Comandos 
escreva("Salário Mínimo: ")
leia (A)
escreva ("Quantidade de água: ")
leia (B)
C<-B*A*0.02/1000
D<-0.85*C
escreva ("Valor da conta de água: ", C)
escreva ("Valor com 15% de desconto: ", D)
fimalgoritmo
