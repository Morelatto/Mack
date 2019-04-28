package pontuacao;

import java.util.Scanner;

/**
 *
 * @author Pedro Morelatto
 */
public class Pontuacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Jogador[] listaScore = new Jogador[100];
        Scanner input = new Scanner(System.in);

        String opcao = "";
        String nome;
        int score;
        int i = 0;
        boolean fnd;

        for (int j = 0; j < listaScore.length; j++) {
            Jogador b = new Jogador("", 0);
            listaScore[j] = b;
        }

        while (!"D".equals(opcao.toUpperCase())) {
            System.out.printf("\nOpção A\t\tInserir\nOpção B\t\tRemover\nOpção C\t\tExibir\nOpção D\t\tSair\n\nOpção: ");
            opcao = input.next();

            switch (opcao.toUpperCase()) {

                case "A":

                    System.out.printf("\nNome: ");
                    nome = input.next();
                    System.out.printf("Pontuação: ");
                    score = input.nextInt();

                    Jogador a = new Jogador(nome, score);

                    if (i < listaScore.length) {
                        inserir(listaScore, a, i++);
                    } else {
                        inserir(listaScore, a, --i);
                        i++;
                    }

                    break;

                case "B":

                    System.out.printf("\nNome: ");
                    nome = input.next();

                    fnd = remover(listaScore, nome, i--);

                    if (fnd) {
                        System.out.printf("\nJogador %s removido.\n", nome);
                    } else {
                        System.out.printf("\nJogador %s não encontrado.\n", nome);
                    }

                    break;

                case "C":

                    if ("".equals(listaScore[0].getNome())) {
                        System.out.printf("\nNenhuma pontuação cadastrada.\n");
                    } else {
                        printVector(listaScore, i);
                    }

                    break;

                default:

                    System.out.printf("\nOpção %s inválida.\n", opcao);
            }
        }
    }

    public static void inserir(Jogador[] listaScore, Jogador a, int i) {
        if (listaScore[i].getScore() < a.getScore()) {
            listaScore[i] = a;
            insertionSort(listaScore);
        }
    }

    public static boolean remover(Jogador[] listaScore, String nome, int i) {
        for (Jogador listaScore1 : listaScore) {
            if (listaScore1.getNome().equalsIgnoreCase(nome)) {
                listaScore1.setNome("");
                listaScore1.setScore(0);
                insertionSort(listaScore);
                return true;
            }
        }
        return false;
    }

    public static void insertionSort(Jogador[] vetor) {
        int j;
        Jogador aux;
        for (int i = 1; i < vetor.length; i++) {
            aux = vetor[i];
            for (j = i - 1; j >= 0 && aux.getScore() > vetor[j].getScore(); j--) {
                vetor[j + 1] = vetor[j];
            }
            vetor[j + 1] = aux;
        }
    }

    public static void printVector(Jogador[] vector, int j) {
        System.out.printf("\nRanking:\n");
        for (int i = 0; i < j; i++) {
            System.out.printf("Nome: %s\tPontuação: %d\n", vector[i].getNome(), vector[i].getScore());
        }
    }

}
