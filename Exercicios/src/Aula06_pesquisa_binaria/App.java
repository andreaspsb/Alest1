package Aula06_pesquisa_binaria;

public class App {

    public static void main(String[] args) {
        int[] lista = new int[10];
        lista[0] = 2;
        lista[1] = 3;
        lista[2] = 4;
        lista[3] = 5;
        lista[4] = 6;
        lista[5] = 7;
        lista[6] = 8;
        lista[7] = 9;
        lista[8] = 10;
        lista[9] = 11;
        for (int i = 1; i < 13; i++) {
            System.out.println(pesquisaBinaria(lista, i));
        }
    }

    public static int pesquisaBinaria(int[] lista, int valor) {
        int meio = lista.length / 2;
        int aux;
        while (meio > 0 && meio < lista.length + 1) {
            if (lista[meio - 1] == valor) {
                return meio - 1;
            } else if (lista[meio - 1] > valor) {
                meio = meio / 2;
            } else {
                aux = (lista.length - meio) / 2;
                if (aux == 0) {
                    aux = 1;
                }
                meio = meio + aux;
            }
        }

        return -1;
    }
}
