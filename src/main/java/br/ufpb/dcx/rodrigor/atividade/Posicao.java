package br.ufpb.dcx.rodrigor.atividade;

public class Posicao {
    private int x;
    private int y;
    private boolean haveNavio;
    private boolean baleada;
    private String tipoNavio;

    public Posicao(){}

    public Posicao(int x, int y) {
        this.x = x;
        this.y = y;
        haveNavio = false;
        baleada = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isHaveNavio(){
        return haveNavio;
    }

    public void receberNavio(String tipoNavio){
        haveNavio = true;
        this.tipoNavio = tipoNavio;
    }

    public boolean isBaleada(){
        return baleada;
    }

    public void receberBala(){
        baleada = true;
    }

    public String getTipoNavio(){
        return tipoNavio;
    }

    @Override
    public String toString() {
        return "Coordenada: " + x + " " + y;
    }
}
