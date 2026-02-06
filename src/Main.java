import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();

        int[][] matriz = gerarMatriz(R, C, M);

        Resultado resultado = menorCaminhoComRota(matriz);

        System.out.println("Menor custo: " + resultado.custo);
        System.out.println("Caminho (linha -> coluna):");

        for (int i = 0; i < R; i++) {
            System.out.println("Linha " + i + " -> Coluna " + resultado.caminho[i]);
        }

        sc.close();
    }

    private static int[][] gerarMatriz(int R, int C, int M) {
        int[][] matriz = new int[R][C];
        int valor = 1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matriz[i][j] = valor;
                valor++;
                if (valor > M) valor = 1;
            }
        }
        return matriz;
    }

    // ================================
    // Programação Dinâmica + Caminho
    // ================================
    private static Resultado menorCaminhoComRota(int[][] matriz) {
        int R = matriz.length;
        int C = matriz[0].length;

        int[][] dp = new int[R][C];
        int[][] pai = new int[R][C]; // guarda de onde veio

        // Primeira linha
        for (int j = 0; j < C; j++) {
            dp[0][j] = matriz[0][j];
            pai[0][j] = -1; // não tem pai
        }

        // DP
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int menor = dp[i - 1][j];
                int colunaPai = j;

                if (j > 0 && dp[i - 1][j - 1] < menor) {
                    menor = dp[i - 1][j - 1];
                    colunaPai = j - 1;
                }

                if (j < C - 1 && dp[i - 1][j + 1] < menor) {
                    menor = dp[i - 1][j + 1];
                    colunaPai = j + 1;
                }

                dp[i][j] = matriz[i][j] + menor;
                pai[i][j] = colunaPai;
            }
        }

        // Encontra o menor valor na última linha
        int menorCusto = dp[R - 1][0];
        int colunaFinal = 0;

        for (int j = 1; j < C; j++) {
            if (dp[R - 1][j] < menorCusto) {
                menorCusto = dp[R - 1][j];
                colunaFinal = j;
            }
        }

        // Reconstrói o caminho
        int[] caminho = new int[R];
        int col = colunaFinal;

        for (int i = R - 1; i >= 0; i--) {
            caminho[i] = col;
            col = pai[i][col];
        }

        return new Resultado(menorCusto, caminho);
    }

    // ================================
    // Classe auxiliar
    // ================================
    private static class Resultado {
        int custo;
        int[] caminho;

        Resultado(int custo, int[] caminho) {
            this.custo = custo;
            this.caminho = caminho;
        }
    }
}