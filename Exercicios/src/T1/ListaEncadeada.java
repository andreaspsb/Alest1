package T1;

public class ListaEncadeada {

    private class Nodo {
        public Aux item;
        public Nodo proximo;

        public Nodo(String palavra) {
            this.item = new Aux(palavra, 1);
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

    public void remover(String palavra) {
        if (inicio == null) { // lista vazia
            return;
        }
        if (inicio.item.palavra.equals(palavra)) { // remover o primeiro elemento
            inicio = inicio.proximo;
            tamanho--;
            return;
        }
        Nodo aux = inicio;
        while (aux.proximo != null && !aux.proximo.item.palavra.equals(palavra)) {
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

    public int buscar(String palavra) {
        Nodo aux = inicio;
        int posicao = 0;
        while (aux != null) {
            if (aux.item.palavra.equals(palavra)) {
                return posicao;
            }
            aux = aux.proximo;
            posicao++;
        }
        return -1; // elemento nao encontrado
    }

    public Aux buscar(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        Nodo aux = inicio;
        for (int i = 0; i < posicao; i++) {
            aux = aux.proximo;
        }
        return aux.item;
    }

    public boolean existe(String palavra) {
        Nodo aux = inicio;
        while (aux != null) {
            if (aux.item.palavra.equals(palavra)) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    public void incrementarQuantidade(String palavra) {
        Nodo aux = inicio;
        while (aux != null) {
            if (aux.item.palavra.equals(palavra)) {
                aux.item.quantidade++;
                return;
            }
            aux = aux.proximo;
        }
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
            System.out.println(aux.item.toString());
            aux = aux.proximo;
        }
    }

    public int retornarTamanho() {
        return tamanho;
    }

    public void ordenarPorQuantidade() {
        // Ordena a lista por quantidade
        if (inicio == null || inicio.proximo == null) {
            return; // lista vazia ou com apenas um elemento
        }
        Nodo atual = inicio;
        while (atual != null) {
            Nodo proximo = atual.proximo;
            while (proximo != null) {
                if (atual.item.quantidade < proximo.item.quantidade) {
                    Aux temp = atual.item;
                    atual.item = proximo.item;
                    proximo.item = temp;
                }
                proximo = proximo.proximo;
            }
            atual = atual.proximo;
        }
    }

}
