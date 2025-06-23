package Aula21_arvore_generica_com_array;

public class App {
    public static void main(String[] args) {
        ArvoreGenerica a = new ArvoreGenerica("A");
        a.adicionarFilho("A", "B");
        a.adicionarFilho("A", "C");
        a.adicionarFilho("A", "D");
        a.adicionarFilho("B", "E");
        a.adicionarFilho("B", "F");
        a.adicionarFilho("D", "G");
        a.adicionarFilho("D", "H");
        a.adicionarFilho("D", "I");

        a.imprimirFilhos("A");

        a.imprimirArvoreCompleta();
    }

}
