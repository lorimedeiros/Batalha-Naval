package br.ufpb.dcx.rodrigor.atividade;

import br.ufpb.dcx.rodrigor.atividade.navio.Cruzador;
import br.ufpb.dcx.rodrigor.atividade.navio.Navio;

import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] argsadd) {

        Scanner sc = new Scanner(System.in);

        //recebe o nome de 2 arquivos separados por espaço, obs: devem estar na área de trabalho
        String caminhoDoArquivoCriar = "C:\\Users\\Lori\\Desktop\\";
        String enderecos = sc.nextLine();
        String[] vect = enderecos.split(" ");

        String endereco1 = caminhoDoArquivoCriar + vect[0];
        String endereco2 = caminhoDoArquivoCriar + vect[1];

        File f1 = new File(endereco1);
        File f2 = new File(endereco2);

        //instanciando tabuleiros e jogadores
        Tabuleiro tabuleiroJogador1 = new Tabuleiro();
        Tabuleiro tabuleiroJogador2 = new Tabuleiro();

        Jogador j1 = new Jogador("Jogador 1", tabuleiroJogador1, tabuleiroJogador2);
        Jogador j2 = new Jogador("Jogador 2", tabuleiroJogador2, tabuleiroJogador1);

        if (f1.exists() && f2.exists()){

            int lineNumber = 0;

            //monta tabuleiro j1
            try (BufferedReader br = new BufferedReader(new FileReader(endereco1))){

                String line = br.readLine();
                while(line != null){

                    lineNumber++;
                    try {
                        String[] fields = line.split(" ");

                        tabuleiroJogador1.botaNavio((fields[0]),
                                new Posicao(Integer.parseInt(fields[1]), Integer.parseInt(fields[2])),
                                new Posicao(Integer.parseInt(fields[3]), Integer.parseInt(fields[4])));
                    } catch (Exception e) {
                        // Trata o erro específico para a linha atual e continua com a próxima linha
                        System.out.println("ERRO NA LINHA " + lineNumber + ": " + "j1.txt");
                        // Você pode optar por interromper o processamento com 'break;' ou continuar
                    }
                    line = br.readLine();

                }


            } catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }

            //monta tabuleiro j2
            try (BufferedReader br = new BufferedReader(new FileReader(endereco2))){

                String line = br.readLine();
                while(line != null){

                    lineNumber++;
                    try {
                        String[] fields = line.split(" ");
                        tabuleiroJogador2.botaNavio((fields[0]),
                                new Posicao(Integer.parseInt(fields[1]), Integer.parseInt(fields[2])),
                                new Posicao(Integer.parseInt(fields[3]), Integer.parseInt(fields[4])));
                    } catch (Exception e) {
                        // Trata o erro específico para a linha atual e continua com a próxima linha
                        System.out.println("ERRO NA LINHA " + lineNumber + ": " + "j2.txt");
                        // Você pode optar por interromper o processamento com 'break;' ou continuar
                    }
                    line = br.readLine();

                }


            } catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("TABULEIROS CARREGADOS COM SUCESSO");
        }

        //mostra os mapas de j1 e j2 apresentando com "x" as posições contendo naviosj1
        System.out.println(j2.gettDoRival().mostraNavios());
        System.out.println();
        System.out.println(j1.gettDoRival().mostraNavios());

        //começar bala
        System.out.println();
        boolean jogoAtivo = true;
        while(jogoAtivo) {
            for (int i = 0; i < 225 && jogoAtivo; i++) {  // Continua se o jogo estiver ativo e não excedeu as posições
                String coord;
                Posicao p;
                String resultadoJogada;

                if (i % 2 == 0) {  // Vez do Jogador 1
                    do {
                        System.out.printf("J1> ");
                        coord = sc.nextLine();
                        String[] fields = coord.split(" ");

                        p = j1.gettDoRival().getPosicao(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]));
                        resultadoJogada = j1.gettDoRival().levarBala(p);
                        System.out.println(resultadoJogada);
                    } while (resultadoJogada.equals("JOGADA INVALIDA") || resultadoJogada.equals("TIRO JA EXECUTADO"));

                    // Verifica se o jogador 1 venceu após sua jogada
                    if(j1.venceu()) {
                        jogoAtivo = false;
                        System.out.println("FIM DE JOGO\nVENCEDOR: " + j1.getNome());
                        break;  // Interrompe o loop forçando o fim do jogo
                    }
                } else {  // Vez do Jogador 2, apenas executa se o jogo ainda estiver ativo
                    do {
                        System.out.printf("J2> ");
                        coord = sc.nextLine();
                        String[] fields = coord.split(" ");

                        p = j2.gettDoRival().getPosicao(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]));
                        resultadoJogada = j2.gettDoRival().levarBala(p);
                        System.out.println(resultadoJogada);
                    } while (resultadoJogada.equals("JOGADA INVALIDA") || resultadoJogada.equals("TIRO JA EXECUTADO"));

                    // Verifica se o jogador 2 venceu após sua jogada
                    if(j2.venceu()) {
                        jogoAtivo = false;
                        System.out.println("FIM DE JOGO\nVENCEDOR: " + j2.getNome());
                    }
                }
            }
        }
    }
}