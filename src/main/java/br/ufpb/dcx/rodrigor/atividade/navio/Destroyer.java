package br.ufpb.dcx.rodrigor.atividade.navio;

import br.ufpb.dcx.rodrigor.atividade.Posicao;
import br.ufpb.dcx.rodrigor.atividade.navio.Navio;

public class Destroyer implements Navio {
    private static final String NOME = "DESTROYER";
    private static final int TAMANHO = 4;
    private int vida = 4;

    public Destroyer() {
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
