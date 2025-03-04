package Aula01;

import java.util.Arrays;

public class Teste {
    public static void main(String[] args) throws Exception {
        System.out.println(new Exercicio01().retornarInteirosDe0aN(3));
        System.out.println(Arrays.toString(new Exercicio02().retornarArrayComInteirosDe0aN(4)));
        System.out.println(new Exercicio03().verificarNumeroPrimo(8));
        System.out.println(Arrays.toString(new Exercicio04().retornarArrayComPrimosEntreDoisNumeros(2, 12)));
    }
}
