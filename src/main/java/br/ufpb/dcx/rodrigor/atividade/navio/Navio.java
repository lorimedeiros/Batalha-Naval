package br.ufpb.dcx.rodrigor.atividade.navio;

import br.ufpb.dcx.rodrigor.atividade.Posicao;

public interface Navio {
    public String getNome();
    public int getTamanho();
    public int getVida();
    public void sofrerDano(Posicao p);

}
