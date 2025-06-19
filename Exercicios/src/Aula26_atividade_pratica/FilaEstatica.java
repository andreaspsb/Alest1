package Aula26_atividade_pratica;

public class FilaEstatica<T> {
    T[] itens;
    private int capacidade = 7;
    private int inicio;
    private int fim;
    private int tamanho;    

    public FilaEstatica() {
        itens = (T[]) new Object[capacidade];
        inicio = 0;
        fim = -1;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void enfileirar(T item) {
        if (tamanho + 2 > capacidade) {
            duplicar();
        }
        fim++;
        itens[fim] = item;
        tamanho++;
    }

    private void duplicar() {
        T[] aux = (T[]) new Object[capacidade * 2];
        capacidade = capacidade * 2;
        int j = 0;
        for (int i = inicio; i <= fim; i++) {
            aux[j] = itens[i];
            j++;
        }
        inicio = 0;
        fim = j - 1;
        itens = aux;
    }

    public T desenfileirar() {
        T retorno = itens[inicio];
        itens[inicio] = null;
        inicio++;
        tamanho--;
        return retorno;
    }

    public void imprimir() {
        System.out.println();
        for (int i = inicio; i <= fim; i++) {
            System.out.print(itens[i] + " ");
        }
        System.out.println();
    }
}
