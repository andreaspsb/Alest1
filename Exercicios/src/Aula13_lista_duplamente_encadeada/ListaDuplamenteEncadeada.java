package Aula13_lista_duplamente_encadeada;

public class ListaDuplamenteEncadeada {

    private class Nodo {
        String item;
        Nodo anterior;
        Nodo proximo;

        public Nodo(String item) {
            this.item = item;
        }
    }

    private Nodo inicio;
    private Nodo fim;

    public ListaDuplamenteEncadeada() {
        inicio = new Nodo(null);
        fim = new Nodo(null);
        inicio.proximo = fim;
        fim.anterior = inicio;
    }

    public void adicionar(String item) {
        Nodo n = new Nodo(item);
        n.proximo = fim;
        n.anterior = fim.anterior;
        fim.anterior.proximo = n;
        fim.anterior = n;
    }

    public void adicionar(int posicao, String item) {
        //tratar quando nao existe a posicao
        Nodo n = new Nodo(item);
        Nodo aux = inicio.proximo;
        int i = 0;
        while (aux != fim && i < posicao) {
            aux = aux.proximo;
            i++;
        }
        n.proximo = aux;
        n.anterior = aux.anterior;
        aux.anterior.proximo = n;
        aux.anterior = n;
    }

    public void remover(int posicao) {

    }

    public void remover(String item) {

    }

    public boolean existe (String item) {
        return false;
    }

    public int retornarQuantidade() {
        int q = 0;
        Nodo aux = inicio.proximo;
        while(aux != fim) {
            q++;
            aux = aux.proximo;
        }
        return q;
    }

    public void imprimir() {
        Nodo aux = inicio.proximo;
        while (aux != fim) {
            System.out.println(aux.item);
            aux = aux.proximo;
        }
    }

}
