import java.util.Scanner;

public class Conexoes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int linha = sc.nextInt();
        int coluna = sc.nextInt();
        int numeroMaximo = sc.nextInt();

        int[][] matriz = gerarMatriz(linha, coluna, numeroMaximo);

        Resultado resultado = menorCaminhoComRota(matriz);

        System.out.println("Menor custo: " + resultado.custo);

        sc.close();
    }

    private static int[][] gerarMatriz(int linha, int coluna, int numeroMaximo) {
        int[][] matriz = new int[linha][coluna];
        int valor = 1;

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                matriz[i][j] = valor;
                valor++;
                if (valor > numeroMaximo) valor = 1;
            }
        }
        return matriz;
    }

    private static Resultado menorCaminhoComRota(int[][] matriz) {
        int linha = matriz.length;
        int coluna = matriz[0].length;

        int[][] dp = new int[linha][coluna];
        int[][] pai = new int[linha][coluna];

        for (int j = 0; j < coluna; j++) {
            dp[0][j] = matriz[0][j];
            pai[0][j] = -1;
        }

        for (int i = 1; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                int menor = dp[i - 1][j];
                int colunaPai = j;

                if (j > 0 && dp[i - 1][j - 1] < menor) {
                    menor = dp[i - 1][j - 1];
                    colunaPai = j - 1;
                }

                if (j < coluna - 1 && dp[i - 1][j + 1] < menor) {
                    menor = dp[i - 1][j + 1];
                    colunaPai = j + 1;
                }

                dp[i][j] = matriz[i][j] + menor;
                pai[i][j] = colunaPai;
            }
        }

        int menorCusto = dp[linha - 1][0];
        int colunaFinal = 0;

        for (int j = 1; j < coluna; j++) {
            if (dp[linha - 1][j] < menorCusto) {
                menorCusto = dp[linha - 1][j];
                colunaFinal = j;
            }
        }

        int[] caminho = new int[linha];
        int col = colunaFinal;

        for (int i = linha - 1; i >= 0; i--) {
            caminho[i] = col;
            col = pai[i][col];
        }

        return new Resultado(menorCusto, caminho);
    }

    private static class Resultado {
        int custo;
        int[] caminho;

        Resultado(int custo, int[] caminho) {
            this.custo = custo;
            this.caminho = caminho;
        }
    }
}