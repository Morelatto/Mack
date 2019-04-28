/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontuacao;

/**
 *
 * @author Pedro Morelatto
 */
public class Jogador {

    private String nome;
    private int score;

    /**
     *
     * @param nome Nome do jogador;
     * @param score Pontuação do jogador;
     */
    public Jogador(String nome, int score) {
        this.nome = nome;
        this.score = score;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNome() {
        return nome;
    }

    public int getScore() {
        return score;
    }
}
