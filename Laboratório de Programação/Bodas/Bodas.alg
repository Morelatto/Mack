algoritmo "semnome"
// Função :
// Autor :
// Data : 11/03/2014
// Seção de Declarações
var
AC, AA, QA: inteiro
inicio
escreva ("Ano de Casamento: ")
leia (AC)
escreva ("Ano Atual: ")
leia (AA)
QA<-AA-AC
escolha QA
caso 25
   escreva ("Boas de Prata")
caso 50
   escreva ("Bodas de Ouro")
caso 75
   escreva ("Bodas de Diamante")
outrocaso
   escreva ("Você está casado à ", QA, "anos")
fimescolha
// Seção de Comandos
fimalgoritmo
