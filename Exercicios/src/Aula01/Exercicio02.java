package Aula01;

public class Exercicio02 {

    public int[] retornarArrayComInteirosDe0aN(int n) {
        int[] retorno = new int[n + 1];

        for (int index = 0; index <= n; index++) {
            retorno[index] = index;
        }

        return retorno;
    }
}
