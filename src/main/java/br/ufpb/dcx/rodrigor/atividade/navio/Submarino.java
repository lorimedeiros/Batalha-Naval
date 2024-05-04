package br.ufpb.dcx.rodrigor.atividade.navio;

import br.ufpb.dcx.rodrigor.atividade.Posicao;
import br.ufpb.dcx.rodrigor.atividade.navio.Navio;

public class Submarino implements Navio {
    private static final String NOME = "SUBMARINO";
    private static final int TAMANHO = 3;
    private int vida = 3;

    public Submarino() {
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
