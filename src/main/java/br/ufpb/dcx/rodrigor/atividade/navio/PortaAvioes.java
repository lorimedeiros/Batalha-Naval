package br.ufpb.dcx.rodrigor.atividade.navio;

import br.ufpb.dcx.rodrigor.atividade.Posicao;
import br.ufpb.dcx.rodrigor.atividade.navio.Navio;

public class PortaAvioes implements Navio {
    private static final String NOME = "PORTA_AVIOES";
    private static final int TAMANHO = 5;
    private int vida = 5;

    public PortaAvioes() {
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
