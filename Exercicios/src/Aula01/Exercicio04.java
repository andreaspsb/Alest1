package Aula01;

public class Exercicio04 {

    public int[] retornarArrayComPrimosEntreDoisNumeros (int i, int j) {
        int[] retorno = new int[j - i];
        Exercicio03 ex03 = new Exercicio03();
        int l = 0;

        for (int k = i + 1; k < j; k++) {
            if (ex03.verificarNumeroPrimo(k)) {
                retorno[l] = k;
            }
            l++;
        }

        return retorno;

    }

}
