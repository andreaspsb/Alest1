package Aula20_arvore_generica;

public class App {
    public static void main(String[] args) {
        ArvoreGenerica arvore = new ArvoreGenerica("A");
        arvore.getRaiz().adicionarFilho("B");
        arvore.getRaiz().adicionarFilho("C");
        arvore.getRaiz().adicionarFilho("D");
        arvore.imprimirFilhos(arvore.getRaiz());

        //arvore.getNodo("B").adicionarFilho("E");
        //arvore.getNodo("B").adicionarFilho("F");
        //arvore.getNodo("B").adicionarFilho("G");

        //arvore.imprimirFilhos(arvore.getNodo("B"));

        System.out.println("Altura = " + arvore.getAltura());

        System.out.println("Grau da raiz = " + arvore.getGrau("A"));
    }
}
