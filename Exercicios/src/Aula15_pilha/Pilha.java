package Aula15_pilha;

public class Pilha {
    private int CAPACIDADE_DEFAULT = 5;
    String[] itens;
    private int capacidade;
    private int base;
    private int topo;
    private int quantidade;

    public Pilha() {
        this.capacidade = CAPACIDADE_DEFAULT;
        this.itens = new String[this.capacidade];
        this.quantidade = 0;
        this.topo = -1;
        this.base = 0;
    }

    public void empilhar(String item) {
        if (this.quantidade == this.capacidade) {
            duplicar();
        }
        this.topo++;
        this.itens[topo] = item;
        this.quantidade++;
    }

    private void duplicar() {
        String[] aux = new String[capacidade * 2];
        capacidade = capacidade * 2;
        int j = 0;
        for (int i = base; i <= topo; i++) {
            aux[j] = itens[i];
            j++;
        }
        topo = j - 1;
        itens = aux;
    }

    public String desempilhar() {
        if (this.estaVazia()) {
            System.out.println("Pilha vazia");
            return "";
        }

        String valor = this.itens[this.topo];
        this.itens[this.topo] = null;
        topo--;
        quantidade--;
        return valor;
    }

    public boolean estaVazia() {
        if (this.quantidade == 0) {
            return true;
        }

        return false;
    }

    public void limpar() {
        this.itens = new String[this.capacidade];
        this.quantidade = 0;
        this.topo = -1;
        this.base = 0;
    }

    public String verTopo() {
        return this.itens[this.topo];
    }

    public void imprimir() {
        System.out.println();
        for (int i = topo; i >= base; i--) {
            System.out.print(itens[i] + " ");
        }
        System.out.println();
    }
}
