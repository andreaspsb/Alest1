package Aula24_arvore_binaria_pesquisa;

public class App {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa(10);
        abp.inserir(5);
        abp.inserir(15);
        abp.inserir(20);
        abp.inserir(3);
        abp.inserir(11);
        abp.inserir(8);
        abp.inserir(6);

        System.out.println("Tamanho = " + abp.obterTamanho());

        int i = 11;
        System.out.print("Filhos de " + i + " = ");
        abp.imprimirFilhos(i);

        i = 6;
        int k = abp.obterPai(6);
        if (i != -1) {
            System.out.println("Pai de " + i + " = " + k);
        }

        System.out.println();

        int[] elementos = abp.elementosPosOrdem();
        for (int j : elementos) {
            System.out.print(j + " ");
        }

        System.out.println();

        elementos = abp.elementosPreOrdem();
        for (int j : elementos) {
            System.out.print(j + " ");
        }

        System.out.println();

        elementos = abp.elementosCentralOrdem();
        for (int j : elementos) {
            System.out.print(j + " ");
        }

        System.out.println();

        i = 5;
        abp.remover(i);

        System.out.println("Tamanho = " + abp.obterTamanho());

        i = 11;
        System.out.print("Filhos de " + i + " = ");
        abp.imprimirFilhos(i);

        i = 6;
        k = abp.obterPai(6);
        if (i != -1) {
            System.out.println("Pai de " + i + " = " + k);
        }

        System.out.println();

        elementos = abp.elementosPosOrdem();
        for (int j : elementos) {
            System.out.print(j + " ");
        }

        System.out.println();

        elementos = abp.elementosPreOrdem();
        for (int j : elementos) {
            System.out.print(j + " ");
        }

        System.out.println();

        elementos = abp.elementosCentralOrdem();
        for (int j : elementos) {
            System.out.print(j + " ");
        }

        System.out.println();
    }
}
