import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] matriz = fazMatriz(3, 5);
        preencheColunas(matriz, 7);
        System.out.println(Arrays.deepToString(matriz));
    }

    private static int[][] fazMatriz(int qtdLinha, int qtdColuna) {
        return new int[qtdLinha][qtdColuna];
    }

    private static int[][] preencheColunas(int[][] matriz, int valorMaximo){
        int contagem = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (contagem > valorMaximo){
                    contagem = 1;
                }
                matriz[i][j] = contagem;
                contagem += 1;
            }
        }
        return matriz;
    }

    private static void somaCaminhos(int[][] matrizPreenchida){
        for (int i = 1; i < matrizPreenchida.length; i++) {
            int ultimaColuna = matrizPreenchida[i].length;
            for (int j = 0; j < matrizPreenchida[i].length; j++) {
                //verifica sempre se for a primeira coluna de uma linha
                if(matrizPreenchida[i][j] == matrizPreenchida[i][0]){
                    //verifica se a soma da linha acima com o elemento da linha atual
                    //é menor que a soma da linha acima com o elemento à direita
                    //assim é colocado o valor menor na linha e coluna atual
                    if(matrizPreenchida[i - 1][j] + matrizPreenchida[i + 1][j] < matrizPreenchida[i - j][j] + matrizPreenchida[i][j + 1]) {
                        matrizPreenchida[i][j] = matrizPreenchida[i - 1][j] + matrizPreenchida[i + 1][j];
                    }
                    else{
                        matrizPreenchida[i][j] = matrizPreenchida[i - j][j] + matrizPreenchida[i][j + 1];
                    }
                //verifica sempre se for a última coluna de uma linha
                } else if (matrizPreenchida[i][j] == matrizPreenchida[i][ultimaColuna - 1]) {
                    //verifica se a soma da linha acima com o elemento da linha atual
                    //é menor que a soma da linha acima com o elemento à esquerda
                    //assim é colocado o valor menor na linha e coluna atual
                    if(matrizPreenchida[i - 1][j] + matrizPreenchida[i + 1][j] < matrizPreenchida[i - j][j] + matrizPreenchida[i][j - 1]) {
                        matrizPreenchida[i][j] = matrizPreenchida[i - 1][j] + matrizPreenchida[i + 1][j];
                    }
                    else{
                        matrizPreenchida[i][j] = matrizPreenchida[i - j][j] + matrizPreenchida[i][j - 1];
                    }
                }
            }
        }
    }

}