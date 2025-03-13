package Aula05_recursao;

public class App {
    public static void main(String[] args) {
        System.out.println(Exercicio02(6));
    }

    public static void Exercicio01(int n) {
        if (n > 0) {
            System.out.println("oi");
            Exercicio01(n - 1);
        }
    }

    public static int Exercicio02(int n) {
        int retorno = 0;
        if (n > 0) {
            retorno = n + Exercicio02(n - 1);
        }
        return retorno;
    }

    public static int fatorialRecursivo(int n) {
        if (n < 0) return -1;
        if (n == 0 || n == 1)
            return 1;
        return n * fatorialRecursivo(n - 1);
    }

    public static int Exercicio03(int n) {
        int f = 1;
        for (int i = n; i < 0; i--) {
            f = f * i;
        }
        return f;
    }

    //Implemente um método recursivo em Java que
    //inverta um array de inteiros de tamanho n.
    public static int[] Exercicio04(int[] array) {

    }

    // um método recursivo que receba um
    //array de inteiros e devolva o maior valor dentro
    // desse array.
    public static int Exercicio05(int[] array) {

    }

}
