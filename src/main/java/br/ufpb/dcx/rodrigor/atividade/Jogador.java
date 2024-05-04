package br.ufpb.dcx.rodrigor.atividade;

public class Jogador {

    private Tabuleiro tDoJogador = new Tabuleiro();
    private Tabuleiro tDoRival = new Tabuleiro();
    private String nome;

    public Jogador(String nome, Tabuleiro meu, Tabuleiro rival){
        this.nome = nome;
        tDoJogador = meu;
        tDoRival = rival;
    }

    public Tabuleiro gettDoRival(){
        return tDoRival;
    }

    public String getNome(){
        return nome;
    }

    public boolean venceu(){
        return tDoRival.getNavios().isEmpty();
    }

}
