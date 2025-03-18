package Aula05_recursao;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println(exercicio02(6));

        int[] array = new int[4];
        array[0] = 2;
        array[1] = 3;
        array[2] = 5;
        array[3] = 2;
        System.out.println(Arrays.toString(exercicio04NaoRecursivo(array)));
        System.out.println(exercicio05NaoRecursivo(array));
    }

    public static void exercicio01(int n) {
        if (n > 0) {
            System.out.println("oi");
            exercicio01(n - 1);
        }
    }

    public static int exercicio02(int n) {
        int retorno = 0;
        if (n > 0) {
            retorno = n + exercicio02(n - 1);
        }
        return retorno;
    }

    public static int fatorialRecursivo(int n) {
        if (n < 0)
            return -1;
        if (n == 0 || n == 1)
            return 1;
        return n * fatorialRecursivo(n - 1);
    }

    public static int exercicio03(int n) {
        int f = 1;
        for (int i = n; i < 0; i--) {
            f = f * i;
        }
        return f;
    }

    // Implemente um método recursivo em Java que
    // inverta um array de inteiros de tamanho n.
    public static int[] exercicio04NaoRecursivo(int[] array) {
        int[] retorno = new int[array.length];
        int n = 0;

        for (int i = array.length - 1; i > -1; i--) {
            retorno[n] = array[i];
            n++;
        }

        return retorno;
    }

    // Implemente um método recursivo em Java que
    // inverta um array de inteiros de tamanho n.
    public static int[] exercicio04(int[] array, int aux1, int aux2) {

        retorno[aux1] = array[aux2];
        exercicio04(array, aux1, aux2);
        return null;
    }

    // um método recursivo que receba um
    // array de inteiros e devolva o maior valor dentro
    // desse array.
    public static int exercicio05NaoRecursivo(int[] array) {
        int maiorValor = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maiorValor) {
                maiorValor = array[i];
            }
        }

        return maiorValor;
    }

    // um método recursivo que receba um
    // array de inteiros e devolva o maior valor dentro
    // desse array.
    public static int exercicio05(int[] array, int aux) {
        int maiorValor = array[0];

        if (array[n] > maiorValor) {
            
        }

        return maiorValor;
    }

}
