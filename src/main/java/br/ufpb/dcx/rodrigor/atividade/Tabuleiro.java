package br.ufpb.dcx.rodrigor.atividade;

import br.ufpb.dcx.rodrigor.atividade.navio.*;

import java.util.*;

public class Tabuleiro {

    private Posicao[][] tabuleiro = new Posicao[15][15];
    private Map<String, Navio> navios = new HashMap();

    public Tabuleiro() {
        for (int i = tabuleiro.length - 1; i >= 0; i--) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = new Posicao(i, j);
            }
        }
    }

    public Posicao getPosicao(int i, int j) {
        return tabuleiro[i][j];
    }

    public void botaNavio(String nomeNavio, Posicao inicio, Posicao fim) {
        Navio navio = getNavio(nomeNavio);
        if (inicio.isHaveNavio() || fim.isHaveNavio())
            throw new TabuleiroException("NÃO É PERMITIDO 2 NAVIOS NA MESMA POSIÇÃO");
        if (inicio.getX() == fim.getX() || inicio.getY() == fim.getY()) {
            if (inicio.getX() == fim.getX()) { // Mesma coluna, altera linha
                int menorY = Math.min(inicio.getY(), fim.getY());
                int maiorY = Math.max(inicio.getY(), fim.getY());
                int diferenca = maiorY - menorY + 1;

                if (diferenca == navio.getTamanho()) {
                    for (int i = menorY; i <= maiorY; i++) {
                        Posicao p = tabuleiro[inicio.getX()][i];
                        p.receberNavio(navio.getNome());
                    }
                    navios.put(navio.getNome(), navio);
                } else {
                    throw new TabuleiroException("NÃO É PERMITIDO COORDENADAS MAIORES QUE O NAVIO");
                }

            } else { // Mesma linha, altera coluna
                int menorX = Math.min(inicio.getX(), fim.getX());
                int maiorX = Math.max(inicio.getX(), fim.getX());
                int diferenca = maiorX - menorX + 1;

                if (diferenca == navio.getTamanho()) {
                    for (int i = menorX; i <= maiorX; i++) {
                        Posicao p = tabuleiro[i][inicio.getY()];
                        p.receberNavio(navio.getNome());
                    }
                    navios.put(navio.getNome(), navio);
                } else {
                    throw new TabuleiroException("NÃO É PERMITIDO COORDENADAS MAIORES QUE O NAVIO");
                }
            }

        }
    }

    private static Navio getNavio(String nomeNavio) {
        Navio navio = null;
        String[] vect = {"PATRULHA", "PORTA_AVIOES", "CRUZADOR", "DESTROYER", "SUBMARINO"};
        for (int i = 0; i < vect.length; i++) {
            if(vect[i].equals(nomeNavio)){
                if(nomeNavio.equals("CRUZADOR")){
                    navio = new Cruzador();
                } else if (nomeNavio.equals("DESTROYER")) {
                    navio = new Destroyer();
                } else if (nomeNavio.equals("PORTA_AVIOES")) {
                    navio = new PortaAvioes();
                } else if (nomeNavio.equals("SUBMARINO")) {
                    navio = new Submarino();
                } else if (nomeNavio.equals("PATRULHA")) {
                    navio = new Patrulha();
                }
            }
        }
        return navio;
    }


    public Map<String, Navio> getNavios() {
        return navios;
    }

    public String levarBala(Posicao p) {
        if (p.getX() > 14 || p.getY() > 14 || p.getX() <= 0 || p.getY() <= 0) {
            return "JOGADA INVALIDA";
        }
        if (p.isBaleada()) {
            return "TIRO JA EXECUTADO";
        }
        if (p.isHaveNavio()) {
            Navio n = navios.get(p.getTipoNavio());
            n.sofrerDano(p);
            p.receberBala();
            if (n.getVida() == 0) {
                navios.remove(n.getNome());
                return "ACERTOU\nAFUNDOU " + n.getNome();
            }
            return "ACERTOU";
        }
        p.receberBala();
        return "ÁGUA";
    }

    //eu fiz o tostring printar o tabuleiro invertido, ou seja, essa porra ta toda ao contrario, me refiro aos metodos
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("| ");  // Usando StringBuilder para melhor eficiência em concatenação de strings em loops
        for (int i = tabuleiro.length - 1; i >= 0; i--) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j].isBaleada()) {
                    str.append("x | ");
                } else {
                    str.append("- | ");
                }
            }
            if (i > 0) { // Para evitar adicionar "|" desnecessariamente após a última linha
                str.append("\n| ");
            }
        }
        return str.toString();
    }


    //método exclusivo para testar se navios estão sendo postos no tabuleiro
    public String mostraNavios() {
        StringBuilder str = new StringBuilder("| ");
        for (int i = tabuleiro.length - 1; i >= 0; i--) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j].isHaveNavio()) {
                    str.append("x | ");
                } else {
                    str.append("- | ");
                }
            }
            if (i > 0) {
                str.append("\n| ");
            }
        }
        return str.toString();
    }
}