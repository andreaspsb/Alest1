package Aula06_pesquisa_binaria;

public class App {

    public static void main(String[] args) {
        int[] lista = new int[5];
        lista[0] = 2;
        lista[1] = 3;
        lista[2] = 4;
        lista[3] = 5;
        lista[4] = 6;
        System.out.println(pesquisaBinaria(lista, 6));
    }

    public static int pesquisaBinaria(int[] lista, int valor) {
        int meio = lista.length / 2;        
        while (meio > 0 && meio < lista.length + 1) {            
            if (lista[meio - 1] == valor) {
                return meio - 1;
            }
            else if (lista[meio - 1] > valor) {
                meio = meio / 2;
            }
            else {
                meio = (meio / 2) + meio;
            }            
        }

        return -1;
    }
}
