package br.ufpb.dcx.rodrigor.atividade.navio;

import br.ufpb.dcx.rodrigor.atividade.Posicao;
import br.ufpb.dcx.rodrigor.atividade.navio.Navio;

public class Patrulha implements Navio {
    private static final String NOME = "PATRULHA";
    private static final int TAMANHO = 2;
    private int vida = 2;

    public Patrulha() {
    }

    @Override
    public String getNome() {
        return NOME;
    }

    @Override
    public int getTamanho() {
        return TAMANHO;
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public void sofrerDano(Posicao p) {
        vida -= 1;
    }

}
