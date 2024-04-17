public enum Navio {

    PORTA_AVIOES(5),
    DESTROYER(4),
    CRUZADOR(4),
    SUBMARINO(3),
    PATRULHA(2);

    private int tamanho;
    private int saude;

    Navio(int tamanho) {
        this.tamanho = tamanho;
        saude = tamanho;
    }

    public void sofrerDano(){
        saude -= 1;
    }
}
