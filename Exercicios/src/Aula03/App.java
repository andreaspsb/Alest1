package Aula03;

public class App {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            System.out.println(alg_07(i));
        }
    }

    public static int alg_02(int n) {
        int operacoes = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                operacoes++;
        return operacoes;
    }

    public static int alg_03(int n) {
        int operacoes = 100;
        return operacoes;
    }

    public static int alg_04(int n) {
        int operacoes = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < i + 2; j++)
                for (int k = 0; k < n; k++)
                    operacoes++;
        return operacoes;
    }

    public static int alg_05(int n) {
        int operacoes = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < 2 * i; j++)
                operacoes++;
        return operacoes;
    }

    public static long alg_06(int n) {
        long operacoes = 1;
        for (int i = 1; i <= n / 2; i++) {
            operacoes = operacoes * n;
            if (operacoes >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return operacoes;
    }

    public static int alg_07(int n) {
        int operacoes = 0;
        int aux = n;
        do {
            aux = aux / 2;
            operacoes++;
        } while (aux > 1);
        return operacoes;
    }
}
