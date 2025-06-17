package Aula29_AVL;

public class ArvoreAVL<T> {

    private class Nodo {
        T item;
        Nodo esquerda;
        Nodo direita;
        Nodo pai;

        public Nodo(T item) {
            this.item = item;
        }
    }

    private Nodo raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    public void adicionar(T item) {
        Nodo n = new Nodo(item);
        if (raiz == null) {
            raiz = n;
            return;
        }

        adicionar(n, raiz);
    }

    private void adicionar(Nodo n, Nodo pai) {
        if ()
    }

    private int obterFatorBalanceamento(Nodo n) {

        return 0;
    }

}
