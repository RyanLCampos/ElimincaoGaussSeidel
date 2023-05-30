import java.util.Scanner;

public class EliminacaoGaussSeidel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de equações: ");
        int n = scanner.nextInt();

        double[][] matriz = new double[n][n + 1];
        double[] solucao = new double[n];

        System.out.println("Digite os elementos da matriz estendida (coeeficientes e termos independentes):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                matriz[i][j] = scanner.nextDouble();
            }
        }

        System.out.print("Digite a tolerância desejada: ");
        double tolerancia = scanner.nextDouble();

        System.out.print("Digite o número máximo de iterações: ");
        int maxIteracoes = scanner.nextInt();

        boolean convergiu = false;
        int iteracao = 0;

        while (!convergiu && iteracao < maxIteracoes) {
            double norma = 0.0;

            for (int i = 0; i < n; i++) {
                double soma = 0.0;

                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        soma += matriz[i][j] * solucao[j];
                    }
                }

                double novoValor = (matriz[i][n] - soma) / matriz[i][i];

                norma += Math.abs(novoValor - solucao[i]);
                solucao[i] = novoValor;
            }

            iteracao++;

            if (norma < tolerancia) {
                convergiu = true;
            }
        }

        if (convergiu) {
            System.out.println("Solução encontrada após " + iteracao + " iterações:");
            for (int i = 0; i < n; i++) {
                System.out.printf("x%d = %.4f%n", i + 1, solucao[i]);
            }
        } else {
            System.out.println("O método de Gauss-Seidel não convergiu após " + maxIteracoes + " iterações.");
        }
    }
}


