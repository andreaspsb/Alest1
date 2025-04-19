package Aula12_lista_encadeada;

public class ListaEncadeada {

    private class Nodo {
        public String item;
        public Nodo proximo;

        public Nodo(String item) {
            this.item = item;
            this.proximo = null;
        }
    }

    private Nodo inicio;
    private Nodo fim;
    private int tamanho;

    public void adicionar(String item) {
        Nodo n = new Nodo(item);
        if (inicio == null) { // lista esta vazia
            inicio = n;
            fim = n;
        } else { // adicionar no final da lista
            fim.proximo = n;
            fim = n;
        }
        tamanho++;
    }

    public void adicionarNoInicio(String item) {
        Nodo n = new Nodo(item);
        if (inicio == null) { // lista esta vazia
            inicio = n;
            fim = n;
        } else { // adicionar no inicio da lista
            n.proximo = inicio;
            inicio = n;
        }
        tamanho++;
    }
    
    public void adicionarNoMeio(String item, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        Nodo n = new Nodo(item);
        if (posicao == 0) { // adicionar no inicio
            adicionarNoInicio(item);
        } else if (posicao == tamanho) { // adicionar no final
            adicionar(item);
        } else { // adicionar no meio
            Nodo aux = inicio;
            Nodo anterior = aux;
            for (int i = 0; i < posicao; i++) {
                anterior = aux;
                aux = aux.proximo;
            }
            anterior.proximo = n;
            n.proximo = aux;            
            tamanho++;
        }
    }

    public void remover(String item) {
        if (inicio == null) { // lista vazia
            return;
        }
        if (inicio.item.equals(item)) { // remover o primeiro elemento
            inicio = inicio.proximo;
            tamanho--;
            return;
        }
        Nodo aux = inicio;
        while (aux.proximo != null && !aux.proximo.item.equals(item)) {
            aux = aux.proximo;
        }
        if (aux.proximo != null) { // encontrou o elemento
            aux.proximo = aux.proximo.proximo;
            tamanho--;
        }
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        if (posicao == 0) { // remover o primeiro elemento
            inicio = inicio.proximo;
            tamanho--;
            return;
        }
        Nodo aux = inicio;
        Nodo anterior = aux;
        for (int i = 0; i < posicao; i++) {
            anterior = aux;
            aux = aux.proximo;
        }
        anterior.proximo = aux.proximo;
        tamanho--;
    }

    public int buscar(String item) {
        Nodo aux = inicio;
        int posicao = 0;
        while (aux != null) {
            if (aux.item.equals(item)) {
                return posicao;
            }
            aux = aux.proximo;
            posicao++;
        }
        return -1; // elemento nao encontrado
    }

    public String buscar(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        Nodo aux = inicio;
        for (int i = 0; i < posicao; i++) {
            aux = aux.proximo;
        }
        return aux.item;
    }

    public boolean existe(String item) {
        Nodo aux = inicio;
        while (aux != null) {
            if (aux.item.equals(item)) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    public void esvaziarLista() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void imprimir() {
        // imprime todos elementos da lista
        Nodo aux = inicio;
        while (aux != null) {
            System.out.println(aux.item);
            aux = aux.proximo;
        }
    }

    public int retornarTamanho() {
        return tamanho;
    }

}
