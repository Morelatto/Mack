algoritmo "semnome"
// Fun��o :
// Autor :
// Data : 11/03/2014
// Se��o de Declara��es
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
   escreva ("Voc� est� casado � ", QA, "anos")
fimescolha
// Se��o de Comandos
fimalgoritmo
