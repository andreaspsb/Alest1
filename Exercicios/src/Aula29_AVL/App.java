package Aula29_AVL;

public class App {
    public static void main(String[] args) {
        ArvoreAVL<Integer> avl = new ArvoreAVL<Integer>();
        avl.inserir(30);
        avl.inserir(15);
        avl.inserir(80);
        avl.inserir(90);
        avl.inserir(100);
       // avl.adicionar(70);

        avl.imprimirArvore();
        System.out.println(avl.obterAltura());
    }
}
